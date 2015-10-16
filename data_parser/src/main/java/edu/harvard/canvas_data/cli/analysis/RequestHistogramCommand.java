package edu.harvard.canvas_data.cli.analysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.analysis.RequestAnalysis;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFormat;
import edu.harvard.data.client.canvas.tables.Requests;
import edu.harvard.data.client.filters.FilterCriteria;
import edu.harvard.data.client.filters.FilteredRequestTableReader;
import edu.harvard.data.client.filters.RequestIPFilter;
import edu.harvard.data.client.filters.RequestUserIDFilter;

public class RequestHistogramCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Argument(index = 1, usage = "Output directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File output;

  @Option(name = "-f", usage = "Format for the output data. Defaults to match the input", metaVar = "format")
  private String format;

  @Option(name = "-filterUsers", usage = "Comma-separated list of user IDs to filter out", metaVar = "123,456,789")
  private String filterUsers;

  @Option(name = "-requireUsers", usage = "Comma-separated list of user IDs to include in results", metaVar = "123,456,789")
  private String requireUsers;

  @Option(name = "-filterIPs", usage = "Comma-separated list of IP addresses to filter out", metaVar = "127.0.0.1,127.0.0.2")
  private String filterIps;

  @Option(name = "-requireIPs", usage = "Comma-separated list of IP addresses to include in results", metaVar = "127.0.0.1,127.0.0.2")
  private String requireIps;

  @Option(name = "-byAccount", usage = "Split analysis between root accounts.")
  private boolean byAccount = false;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws IOException {
    final DataSetUtils utils = new DataSetUtils(config);
    final DataSetInfo info = utils.getDataSetInfo(input);
    if (info == null) {
      return ReturnStatus.BAD_DATA_SET;
    }

    final Format outputFormat = utils.getFormatFromString(format, info.getFormat());
    final TableFormat tableFormat = new FormatLibrary().getFormat(outputFormat);

    try (DataSetReader in = utils.getReaderFromString(input)) {
      final List<FilterCriteria<Requests>> filters = buildFilters();
      if (filters.size() > 0) {
        final FilteredRequestTableReader<Requests> reader = new FilteredRequestTableReader<Requests>(
            Requests.class, in.getTable("requests", Requests.class), filters);
        in.replaceTable("requests", reader);
      }
      if (in == null) {
        return ReturnStatus.BAD_DATA_SET;
      }

      if (byAccount) {
        final Map<Long, RequestAnalysis> perAccount = RequestAnalysis.analyseDataSetPerAccount(in);
        for (final Long accountId : perAccount.keySet()) {
          perAccount.get(accountId).dumpOutput(output.toPath().resolve(accountId.toString()), tableFormat);
        }
      } else {
        final RequestAnalysis analysis = RequestAnalysis.analyseDataSet(in);
        analysis.dumpOutput(output.toPath(), tableFormat);
      }
    }
    return ReturnStatus.OK;
  }

  private List<FilterCriteria<Requests>> buildFilters() {
    final List<FilterCriteria<Requests>> filters = new ArrayList<FilterCriteria<Requests>>();
    createUserFilters(filterUsers, false, filters);
    createUserFilters(requireUsers, true, filters);
    createIpFilters(filterIps, false, filters);
    createIpFilters(requireIps, true, filters);
    return filters;
  }

  private static void createIpFilters(final String ips, final boolean requireMatch,
      final List<FilterCriteria<Requests>> filters) {
    if (ips != null) {
      for (final String ip : ips.split(",")) {
        filters.add(new RequestIPFilter<>(ip, requireMatch));
      }
    }
  }

  private static void createUserFilters(final String users, final boolean requireMatch,
      final List<FilterCriteria<Requests>> filters) {
    if (users != null) {
      for (final String userId : users.split(",")) {
        try {
          filters.add(new RequestUserIDFilter<>(Long.parseLong(userId), requireMatch));
        } catch (final NumberFormatException e) {
          throw new IllegalArgumentException("Can't parse " + userId + " as user ID");
        }
      }
    }
  }

  @Override
  public String getDescription() {
    return "Generate request statistics for a data set";
  }

}
