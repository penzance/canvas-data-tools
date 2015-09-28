package edu.harvard.data.client.canvas.api;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.harvard.data.client.DataConfigurationException;

public class CanvasApiClient {

  private final RestUtils rest;

  public CanvasApiClient(final String host, final String key, final String secret) {
    this.rest = new RestUtils(host, key, secret);
  }

  public List<CanvasDataDump> getDumps()
      throws DataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/dump", 200);
    final List<CanvasDataDump> dumps = response.getEntity(new GenericType<List<CanvasDataDump>>(){});
    for(final CanvasDataDump dump : dumps) {
      dump.setRestUtils(rest);
    }
    return dumps;
  }

  public CanvasDataDump getLatestDump()
      throws DataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/latest", 200);
    final CanvasDataDump dump = response.getEntity(CanvasDataDump.class);
    dump.setRestUtils(rest);
    return dump;
  }

  public CanvasDataDump getDump(final String id)
      throws DataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/byDump/" + id, 200);
    final CanvasDataDump dump = response.getEntity(CanvasDataDump.class);
    dump.setRestUtils(rest);
    return dump;
  }

  public CanvasDataTableHistory getTableHistory(final String table)
      throws DataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/byTable/" + table, 200);
    final CanvasDataTableHistory history = response.getEntity(CanvasDataTableHistory.class);
    history.setRestUtils(rest);
    return history;
  }
}
