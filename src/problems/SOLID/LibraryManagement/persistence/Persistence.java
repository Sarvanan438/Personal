package problems.SOLID.LibraryManagement.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Persistence<T> {
    void insert(String  item) throws IOException;
    String[] findAll() throws FileNotFoundException;
    void clearAll() throws IOException;
}
