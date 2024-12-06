package problems.SOLID.LibraryManagement.persistence;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.service.FileManager;
import problems.SOLID.LibraryManagement.service.FileService;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * Think of ways to improve cohesiveness may be extract management from
 * true file based service ?
 */
public class FilePersistence implements Persistence<Book> {


    private  final String file;
    private FileService fileService;
    private FileManager manager;
    public FilePersistence(String file,FileService fileService, FileManager manager) throws IOException {
        this.fileService = fileService;
        this.file=file;
        // may be make manager take a file name as input like set file name
        this.manager = manager;
        this.createFile();
    }

    private void createFile() throws IOException {
        this.fileService = this.manager.createFile(file);
    }
    @Override
    public void insert(Book item) throws IOException {
        this.fileService.write(item.toString());
    }

    @Override
    public Book[] findAll() {
        ArrayList<Book> books = new ArrayList<>();
        while(this.fileService.hasLine()){
            String line = this.fileService.readLine();
            books.add(Book.createBookFromString(line));
        }
        return books.toArray(new Book[]{});
    }

    @Override
    public void clearAll() throws IOException {
        this.manager.delete(file);
        this.createFile();
    }
}
