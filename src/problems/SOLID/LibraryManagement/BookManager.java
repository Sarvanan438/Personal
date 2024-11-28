package problems.SOLID.LibraryManagement;

import problems.SOLID.LibraryManagement.bookfilter.BookFilterByTitle;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.persistence.FilePersistence;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.repositories.SimpleBookRepository;
import problems.SOLID.LibraryManagement.service.BookService;
import problems.SOLID.LibraryManagement.service.FileManager;
import problems.SOLID.LibraryManagement.service.SimpleBookService;
import problems.SOLID.LibraryManagement.service.SimpleFileManager;

import java.io.*;
import java.util.Scanner;


public class BookManager {
    private BookService bookService ;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    void saveBook(String title, String author, String ISBN) throws IOException{
        Book book = BookCreatorFactory.create(title,author,ISBN);
        this.bookService.add(book);;

    }

    Book[] findBook(String title) throws FileNotFoundException {
       return this.bookService.findBy(FilterKey.TITLE,title);
    }

    public static void  setUpFileDb(FilePersistence persistence) throws IOException {
        persistence.clearAll();;
    }
    public static void setupBookFilters(){
        BookFilterFactory.registerBookFilter(FilterKey.TITLE,new BookFilterByTitle());
    }
    public static void printBooks(Book[] books){
        for(Book book:books){
            System.out.println(book);
        }
    }
    public static void main(String[] args) throws IOException,FileNotFoundException {
        FileManager fileManagermanager = new SimpleFileManager();
        FilePersistence filePersistence = new FilePersistence(fileManagermanager);
        BookRepository bookRepository = new SimpleBookRepository(filePersistence);
        BookService bookService = new SimpleBookService(bookRepository);
        BookManager bookManager = new BookManager(bookService);

        // setup
        setUpFileDb(filePersistence);
        setupBookFilters();

        bookManager.saveBook("Transformers","MartinBay","12321B1231BB");
        Book[] book= bookManager.findBook("Transformers");
        printBooks(book);
        bookManager.saveBook("Transformers2","MartinBay","12321B1231BB");
        bookManager.saveBook("Transformers3","MartinBay","12321B1231BB");

        book= bookManager.findBook("Transformers2");
        printBooks(book);
    }
}
