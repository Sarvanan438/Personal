package problems.SOLID.LibraryManagement.persistence;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.service.FileManager;
import problems.SOLID.LibraryManagement.service.FileService;

import java.io.IOException;
import java.util.ArrayList;

public class FilePersistence implements Persistence<Book> {
    private static final String file="books.txt";
    private FileService fileService;
    private FileManager manager;
    public FilePersistence(FileManager manager) throws IOException {

        this.manager=manager;
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
