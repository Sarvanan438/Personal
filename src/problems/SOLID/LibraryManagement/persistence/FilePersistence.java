package problems.SOLID.LibraryManagement.persistence;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.service.FileManager;
import problems.SOLID.LibraryManagement.service.FileService;
import problems.SOLID.LibraryManagement.utilities.FileReader;
import problems.SOLID.LibraryManagement.utilities.FileWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Think of ways to improve cohesiveness may be extract management from
 * true file based service ?
 *
 * SOLID
 * SRP :
 *  Iteration one contains code for file management and file persistence using file service
 *      The fileservice makes sense as the file persistence is meant to persist the data
 *      So iteration one violates it
 *      1. file management: This should be seperate and can be done while creating the file persistence
 *      2. data persistence
 *      3. serialize and deserialize to entities : this is responsbility of repsitory
 */
public class FilePersistence implements Persistence {


    private FileWriter writer;
    private  FileReader reader;


    public FilePersistence(FileWriter writer, FileReader reader) {
        this.writer=writer;
        this.reader=reader;

    }

    /** Iteration 1
    private  final String file;
    private FileManager manager;
    private Serializer<T> serializer;
     move serialize and deserialize to repository as its responsibility to handle the conversion
     the persistence layer is only responsible to handle data persitence and api to access the data without having to call
     low level persistence apis but a wrapper

    public FilePersistence(String file, FileManager manager, Serializer<T> serializer) throws IOException {

        this.file=file;
        // may be make manager take a file name as input like set file name
        this.manager = manager;
        this.fileService = this.manager.createFile(this.file);
        this.createFile();
        this.serializer=serializer;
    }
     **/



//    private void createFile() throws IOException {
//        this.fileService = this.manager.createFile(file);
//    }
//    @Override
//    public void insert(T item) throws IOException {
//        this.fileService.write(serializer.serialize(item));
//    }

    @Override
    public void insert(String item) throws IOException {
       this.writer.write(item);

    }

    @Override
    public String[] findAll() throws FileNotFoundException {
        ArrayList<String> entities = new ArrayList<>();
        this.reader.open();
        while(this.reader.hasLine()){
            String line = this.reader.readLine();
            entities.add(line);
        }
        this.reader.close();
        return entities.toArray(new String[]{});
    }

    @Override
    public void clearAll() throws IOException {
        this.writer.clearFileContent();
    }
}
