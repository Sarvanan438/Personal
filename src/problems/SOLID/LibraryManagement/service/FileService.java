package problems.SOLID.LibraryManagement.service;

import java.io.IOException;

/**
 * may be break the interface into two difference cohesive/encapsulated file service
 * 1. reader file abstraction , is responsible for file read operation
 * 2. write , for write operation
 * 3. generic that are not part of both
 *  we can make fileservice extend both read and write and have specialised class for each and then a wrapper encapsulating both
 *  This way we can have changes only effecting the implementations specializing in one thing
 *
 */

/**
 * This is bloated so using a small interface and cohesive classes for write and read respectively
 */
public interface FileService {
    void write(String content) throws IOException;
    String readLine();
    boolean hasLine();
    void clearAll() throws IOException;
}
