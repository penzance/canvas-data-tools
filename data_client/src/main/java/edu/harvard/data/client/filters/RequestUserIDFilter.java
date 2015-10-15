package edu.harvard.data.client.filters;

import edu.harvard.data.client.canvas.tables.Requests;

public class RequestUserIDFilter<T extends Requests> implements FilterCriteria<T> {

  private final Long matchingId;
  private final boolean requireMatch;

  public RequestUserIDFilter(final Long matchingId, final boolean requireMatch) {
    this.matchingId = matchingId;
    this.requireMatch = requireMatch;
  }

  @Override
  public boolean matches(final T value) {
    final Long id = value.getUserId();
    final boolean match = (id != null) && id.equals(matchingId);
    return match == requireMatch;
  }

}
