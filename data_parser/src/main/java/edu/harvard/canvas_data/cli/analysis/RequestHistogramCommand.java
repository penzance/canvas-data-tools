package edu.harvard.canvas_data.cli.analysis;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.nio.file.Path;
import java.util.Map;

import org.apache.commons.csv.CSVPrinter;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import edu.harvard.canvas_data.DataSetUtils;
import edu.harvard.canvas_data.analysis.Histogram;
import edu.harvard.canvas_data.analysis.Histogram.SortOrder;
import edu.harvard.canvas_data.analysis.RequestAnalysis;
import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataSetInfo;
import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.FormatLibrary;
import edu.harvard.data.client.FormatLibrary.Format;
import edu.harvard.data.client.TableFormat;

public class RequestHistogramCommand implements Command {

  @Argument(index = 0, usage = "Input Data Set (either a directory or LATEST). This argument is required", metaVar = "/path/to/directory", required = true)
  private String input;

  @Argument(index = 1, usage = "Output directory. This argument is required", metaVar = "/path/to/directory", required = true)
  private File output;

  @Option(name = "-f", usage = "Format for the output data. Defaults to match the input", metaVar = "format")
  private String format;

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
      if (in == null) {
        return ReturnStatus.BAD_DATA_SET;
      }
      final RequestAnalysis analysis = new RequestAnalysis();
      analysis.analyzeRequests(in);
      dumpOutput(analysis, tableFormat);
    }
    return ReturnStatus.OK;
  }

  private void dumpOutput(final RequestAnalysis analysis, final TableFormat tableFormat) throws IOException {
    if (!output.exists()) {
      output.mkdirs();
    }
    final Path dir = output.toPath();
    final String ext = tableFormat.getExtension();
    analysis.getActions().write(dir.resolve("requestsPerAction" + ext), tableFormat, SortOrder.Value);
    analysis.getControllers().write(dir.resolve("requestsPerController" + ext), tableFormat, SortOrder.Value);
    analysis.getHours().write(dir.resolve("requestsPerHour" + ext), tableFormat, SortOrder.Key);
    analysis.getMinutes().write(dir.resolve("requestsPerMinute" + ext), tableFormat, SortOrder.Key);
    analysis.getUserRequests().write(dir.resolve("requestsPerUser" + ext), tableFormat, SortOrder.Value);
    analysis.getUrls().write(dir.resolve("requestsPerUrl" + ext), tableFormat, SortOrder.Value);
    analysis.getUserAgents().write(dir.resolve("requestsPerUserAgent" + ext), tableFormat, SortOrder.Value);
    analysis.getLocalDates().write(dir.resolve("requestsPerLocalDate" + ext), tableFormat, SortOrder.Key);
    analysis.getCourses().write(dir.resolve("requestsPerCourse" + ext), tableFormat, SortOrder.Value);
    analysis.getDiscussions().write(dir.resolve("requestsPerDiscussion" + ext), tableFormat, SortOrder.Value);
    analysis.getQuizzes().write(dir.resolve("requestsPerQuiz" + ext), tableFormat, SortOrder.Value);
    analysis.getAssignments().write(dir.resolve("requestsPerAssignment" + ext), tableFormat, SortOrder.Value);
    analysis.getConversations().write(dir.resolve("requestsPerConversation" + ext), tableFormat, SortOrder.Value);
    analysis.getAccounts().write(dir.resolve("requestsPerAccount" + ext), tableFormat, SortOrder.Key);
    analysis.getBrowsers().write(dir.resolve("requestsPerBrowser" + ext), tableFormat, SortOrder.Value);
    analysis.getOperatingSystems().write(dir.resolve("requestsPerOS" + ext), tableFormat, SortOrder.Value);
    analysis.getDaysOfWeek().write(dir.resolve("requestsPerDayOfWeek" + ext), tableFormat, SortOrder.Key);
    writeUserIps(analysis.getUserIps(), dir, tableFormat);
  }

  private void writeUserIps(final Map<Long, Histogram<String>> userIps, final Path dir, final TableFormat tableFormat) throws IOException {
    final Path totalFile = dir.resolve("ipCountPerUser" + tableFormat.getExtension());
    final Path detailFile = dir.resolve("ipsPerUser" + tableFormat.getExtension());
    try (OutputStream totalOut = tableFormat.getOutputStream(totalFile);
        OutputStream detailOut = tableFormat.getOutputStream(detailFile);
        CSVPrinter totalPrinter = new CSVPrinter(new OutputStreamWriter(totalOut), tableFormat.getCsvFormat());
        CSVPrinter detailPrinter = new CSVPrinter(new OutputStreamWriter(detailOut), tableFormat.getCsvFormat())) {
      for (final Long user : userIps.keySet()) {
        final Histogram<String> ips = userIps.get(user);
        totalPrinter.printRecord(user, ips.size());
        for (final String ip : ips.keySet()) {
          detailPrinter.printRecord(user, ip, ips.get(ip));
        }
      }
    }
  }

  @Override
  public String getDescription() {
    return "Generate request statistics for a data set";
  }

}
