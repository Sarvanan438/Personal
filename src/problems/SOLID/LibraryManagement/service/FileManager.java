package problems.SOLID.LibraryManagement.service;

import java.io.IOException;

public interface FileManager {
    FileService createFile(String file) throws IOException;
    void delete(String file) throws IOException;
}
