package edu.harvard.data.client.filters;

import edu.harvard.data.client.canvas.tables.Requests;

public class RequestIPFilter<T extends Requests> implements FilterCriteria<T> {

  private final String matchingIp;
  private final boolean requireMatch;

  public RequestIPFilter(final String matchingIp, final boolean requireMatch) {
    this.matchingIp = matchingIp;
    this.requireMatch = requireMatch;
  }

  @Override
  public boolean matches(final T value) {
    final String ip = value.getRemoteIp();
    final boolean match = (ip != null) && ip.equals(matchingIp);
    return match == requireMatch;
  }

}
