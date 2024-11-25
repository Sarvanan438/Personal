package problems.SOLID.LibraryManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SimpleFileCreator implements FileManager{
    @Override
    public FileService createFile(String filename) throws IOException {
        File file = new File(filename);
        if(!file.exists())
        {
            if(!file.createNewFile()) throw new FileNotFoundException();
        }
        return new SimpleFileService(file);
    }
}
