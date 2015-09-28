package edu.harvard.data.client;

import java.io.IOException;
import java.nio.file.Path;

public interface TableFactory {

  TableReader<? extends DataTable> getDelimitedTableReader(String table, TableFormat format, Path file) throws IOException;

  TableWriter<? extends DataTable> getDelimitedTableWriter(String table, TableFormat format, Path resolve) throws IOException;

}
