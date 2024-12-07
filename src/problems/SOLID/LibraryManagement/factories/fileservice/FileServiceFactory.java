package problems.SOLID.LibraryManagement.factories.fileservice;

import problems.SOLID.LibraryManagement.service.FileService;

import java.io.IOException;

public interface FileServiceFactory {
    FileService createFileService(String file) throws IOException;
}
