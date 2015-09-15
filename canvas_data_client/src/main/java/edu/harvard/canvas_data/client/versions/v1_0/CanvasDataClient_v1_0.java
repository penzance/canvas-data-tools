package edu.harvard.canvas_data.client.versions.v1_0;

import java.util.List;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;

import edu.harvard.canvas_data.client.CanvasDataClient;
import edu.harvard.canvas_data.client.CanvasDataConfigurationException;
import edu.harvard.canvas_data.client.CanvasDataDump;
import edu.harvard.canvas_data.client.RestUtils;
import edu.harvard.canvas_data.client.UnexpectedApiResponseException;

public class CanvasDataClient_v1_0 implements CanvasDataClient {

  private final RestUtils rest;

  public CanvasDataClient_v1_0(final String host, final String key, final String secret) {
    this.rest = new RestUtils(host, key, secret);
  }

  @Override
  public List<CanvasDataDump> getDumps()
      throws CanvasDataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/dump", 200);
    final List<CanvasDataDump> dumps = response.getEntity(new GenericType<List<CanvasDataDump>>(){});
    for(final CanvasDataDump dump : dumps) {
      ((CanvasDataDump_v1_0) dump).setRestUtils(rest);
    }
    return dumps;
  }

  @Override
  public CanvasDataDump_v1_0 getLatestDump()
      throws CanvasDataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/latest", 200);
    final CanvasDataDump_v1_0 dump = response.getEntity(CanvasDataDump_v1_0.class);
    dump.setRestUtils(rest);
    return dump;
  }

  @Override
  public CanvasDataDump_v1_0 getDump(final int id)
      throws CanvasDataConfigurationException, UnexpectedApiResponseException {
    final ClientResponse response = rest.makeApiCall("/api/account/self/file/byDump/" + id, 200);
    final CanvasDataDump_v1_0 dump = response.getEntity(CanvasDataDump_v1_0.class);
    dump.setRestUtils(rest);
    return dump;
  }
}
