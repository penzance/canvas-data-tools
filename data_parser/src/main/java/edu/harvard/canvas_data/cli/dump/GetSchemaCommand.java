package edu.harvard.canvas_data.cli.dump;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;

import org.kohsuke.args4j.Argument;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.harvard.canvas_data.cli.Command;
import edu.harvard.canvas_data.cli.ReturnStatus;
import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataClient;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.CanvasApiClient;
import edu.harvard.data.client.canvas.api.CanvasDataSchema;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public class GetSchemaCommand implements Command {

  @Argument(index = 0, usage = "Schema version, or LATEST. This argument is required", metaVar = "1.0.0", required = true)
  private String version;

  @Override
  public ReturnStatus execute(final Configuration config, final PrintStream out)
      throws DataConfigurationException, IOException, UnexpectedApiResponseException {
    final CanvasApiClient api = new DataClient().getCanvasApiClient(config.getCanvasDataHost(),
        config.getCanvasApiKey(), config.getCanvasApiSecret());
    final CanvasDataSchema schema = api.getSchema(version);
    final ObjectMapper mapper = new ObjectMapper();
    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"));
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.setSerializationInclusion(Include.NON_NULL);
    System.out.println(mapper.writeValueAsString(schema));
    return ReturnStatus.OK;
  }

  @Override
  public String getDescription() {
    return "Output a specific version of the data schema to standard out.";
  }

}