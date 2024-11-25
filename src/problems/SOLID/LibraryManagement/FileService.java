package problems.SOLID.LibraryManagement;

import java.io.File;
import java.io.IOException;

public interface FileService {
    void write(String content) throws IOException;
    String readLine();
    boolean hasLine();

}
