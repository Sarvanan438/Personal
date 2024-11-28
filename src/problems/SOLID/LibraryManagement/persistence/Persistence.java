package problems.SOLID.LibraryManagement.persistence;

import java.io.IOException;

public interface Persistence<T> {
    void insert(T  item) throws IOException;
    T[] findAll();
    void clearAll() throws IOException;
}
