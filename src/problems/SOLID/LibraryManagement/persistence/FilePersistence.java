package problems.SOLID.LibraryManagement.persistence;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.service.FileManager;
import problems.SOLID.LibraryManagement.service.FileService;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Think of ways to improve cohesiveness may be extract management from
 * true file based service ?
 */
public class FilePersistence<T> implements Persistence<T> {


    private  final String file;
    private FileService fileService;
    private FileManager manager;
    private Serializer<T> serializer;
    // move serialize and deserialize to repository as its responsibility to handle the conversion
    // the persistence layer is only responsible to handle data persitence and api to access the data without having to call
    // low level persistence apis but a wrapper
    public FilePersistence(String file, FileManager manager, Serializer<T> serializer) throws IOException {

        this.file=file;
        // may be make manager take a file name as input like set file name
        this.manager = manager;
        this.fileService = this.manager.createFile(this.file);
        this.createFile();
        this.serializer=serializer;
    }

    private void createFile() throws IOException {
        this.fileService = this.manager.createFile(file);
    }
    @Override
    public void insert(T item) throws IOException {
        this.fileService.write(serializer.serialize(item));
    }

    @Override
    public T[] findAll() {
        ArrayList<T> entities = new ArrayList<>();
        while(this.fileService.hasLine()){
            String line = this.fileService.readLine();
            entities.add(serializer.deserialize(line));
        }
        return (T[])entities.toArray();
    }

    @Override
    public void clearAll() throws IOException {
        this.manager.delete(file);
        this.createFile();
    }
}
