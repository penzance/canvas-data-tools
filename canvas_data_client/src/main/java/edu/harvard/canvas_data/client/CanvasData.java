package edu.harvard.canvas_data.client;

import edu.harvard.canvas_data.client.api.ApiClient;
import edu.harvard.canvas_data.client.tables.TableClient;

public class CanvasData {

  private ApiClient apiClient;
  private final TableClient tables;

  public CanvasData() {
    this.tables = new TableClient();
  }

  public ApiClient getApiClient(final String host, final String key, final String secret) {
    if (apiClient == null) {
      apiClient = new ApiClient(host, key, secret);
    }
    return apiClient;
  }

  public TableClient getTableClient() {
    return tables;
  }
}
