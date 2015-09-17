package edu.harvard.canvas_data.client.api;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.harvard.canvas_data.client.CanvasDataConfigurationException;

public class ApiClient {

  private final RestUtils rest;

  public ApiClient(final String host, final String key, final String secret) {
    this.rest = new RestUtils(host, key, secret);
  }

  public List<CanvasDataDump> getDumps()
      throws CanvasDataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/dump", 200);
    final List<CanvasDataDump> dumps = response.getEntity(new GenericType<List<CanvasDataDump>>(){});
    for(final CanvasDataDump dump : dumps) {
      dump.setRestUtils(rest);
    }
    return dumps;
  }

  public CanvasDataDump getLatestDump()
      throws CanvasDataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/latest", 200);
    final CanvasDataDump dump = response.getEntity(CanvasDataDump.class);
    dump.setRestUtils(rest);
    return dump;
  }

  public CanvasDataDump getDump(final String id)
      throws CanvasDataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/byDump/" + id, 200);
    final CanvasDataDump dump = response.getEntity(CanvasDataDump.class);
    dump.setRestUtils(rest);
    return dump;
  }

}
