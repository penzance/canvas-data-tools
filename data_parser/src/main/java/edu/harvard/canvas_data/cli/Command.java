package edu.harvard.canvas_data.cli;

import java.io.IOException;
import java.io.PrintStream;

import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;
import edu.harvard.data.client.canvas.api.UnexpectedApiResponseException;

public interface Command {

  String getDescription();

  ReturnStatus execute(Configuration config, PrintStream out) throws IOException, DataConfigurationException, UnexpectedApiResponseException;

}
