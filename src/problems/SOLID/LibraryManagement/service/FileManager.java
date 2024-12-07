package problems.SOLID.LibraryManagement.service;

import java.io.File;
import java.io.IOException;

/**
 * SOLID
 * S: works on managing file and here file service is returned
 * O : OCP is followed and we just need to handle extensibiliy we should be possible with current ipmlementation
 * L : any and all implementation should pass this as the impl should return a file object or throw IOException
 *     The implementation only should create file and not throw error when file exists
 * I: Interface is followed
 * D: Here the dependency inversion is on the file path , every thing works on provided file path
 * the caller uses the file path to invoke CRUD while the Filemanager works on the file path
 */

/**
 * Here the createFile should return file not file service
 * because file service works on the file like helping with file read write ops
 * File should be an object that gives info about file
 * changed from returning fileservice to file
 *
 */
public interface FileManager {
    File createFile(String file) throws IOException;
    void delete(String file) throws IOException;
}
