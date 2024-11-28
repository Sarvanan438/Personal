package problems.SOLID.LibraryManagement.service;

import java.io.IOException;

public interface FileService {
    void write(String content) throws IOException;
    String readLine();
    boolean hasLine();

}
