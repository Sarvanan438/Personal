package problems.SOLID.LibraryManagement.persistence;

import java.io.IOException;

public interface Persistence<T> {
    void insert(String  item) throws IOException;
    String[] findAll();
    void clearAll() throws IOException;
}
