package problems.SOLID.LibraryManagement;

import java.io.IOException;
import java.util.ArrayList;

public class FilePersistence implements Persistence<Book>{
    private static final String file="books.txt";
    private FileService fileService;
    FilePersistence(FileManager manager) throws IOException {
        this.fileService = manager.createFile(file);
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
}
