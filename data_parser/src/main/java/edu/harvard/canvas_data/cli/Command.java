package edu.harvard.canvas_data.cli;

import java.io.IOException;

import edu.harvard.canvas_data.parser.Configuration;
import edu.harvard.data.client.DataConfigurationException;

public interface Command {

  void execute(Configuration config) throws DataConfigurationException, IOException;

  String getDescription();

}
