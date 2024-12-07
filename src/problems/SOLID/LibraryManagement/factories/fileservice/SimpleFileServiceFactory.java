package problems.SOLID.LibraryManagement.factories.fileservice;

import problems.SOLID.LibraryManagement.service.FileManager;
import problems.SOLID.LibraryManagement.service.FileService;
import problems.SOLID.LibraryManagement.service.impl.SimpleFileService;

import java.io.File;
import java.io.IOException;

public class SimpleFileServiceFactory implements FileServiceFactory{

    private FileManager fileManager;

    public SimpleFileServiceFactory(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public FileService createFileService(String filePath) throws IOException{
        File file = this.fileManager.createFile(filePath);
        return new  SimpleFileService(file);
    }
}
