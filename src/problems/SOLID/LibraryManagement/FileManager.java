package problems.SOLID.LibraryManagement;

import java.io.IOException;

public interface FileManager {
    FileService createFile(String file) throws IOException;

}
