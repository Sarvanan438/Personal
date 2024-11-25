package problems.SOLID.LibraryManagement;

import java.io.IOException;

public interface Persistence<T> {
    void insert(T  item) throws IOException;
    T[] findAll();
}
