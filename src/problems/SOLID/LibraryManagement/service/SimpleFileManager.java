package problems.SOLID.LibraryManagement.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SimpleFileManager implements FileManager {
    @Override
    public FileService createFile(String filename) throws IOException {
        File file = new File(filename);
        if(!file.exists())
        {
            if(!file.createNewFile()) throw new FileNotFoundException();
        }
        return new SimpleFileService(file);
    }

    @Override
    public void delete(String filename) throws IOException {
        File file =  new File(filename);
        if(!file.delete()) throw new FileNotFoundException();
    }
}
