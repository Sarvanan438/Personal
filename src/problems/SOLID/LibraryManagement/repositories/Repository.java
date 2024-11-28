package problems.SOLID.LibraryManagement.repositories;

import java.io.IOException;

public interface Repository <T>{

    void add(T item) throws IOException;

}
