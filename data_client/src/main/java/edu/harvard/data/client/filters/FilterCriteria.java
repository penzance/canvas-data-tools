package edu.harvard.data.client.filters;

import edu.harvard.data.client.DataTable;

public interface FilterCriteria<T extends DataTable> {

  boolean matches(T value);

}
