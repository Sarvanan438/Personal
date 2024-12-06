package problems.SOLID.LibraryManagement;

import problems.SOLID.LibraryManagement.bookfilter.BookFilterByTitle;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.bookfilter.SimpleFilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.persistence.FilePersistence;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.repositories.SimpleBookRepository;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.serializer.impl.SerializeBookCSV;
import problems.SOLID.LibraryManagement.service.*;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleStringUtils;

import java.io.*;


public class BookManager {
    private BookService bookService ;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    void saveBook(String title, String author, String ISBN) throws IOException{
        Book book = BookCreatorFactory.create(title,author,ISBN);
        this.bookService.add(book);;

    }

//    Book[] findBook(String title) throws FileNotFoundException {
//        // this line makes the book manager be aware of filter key instead expose functionality from
//        // book service like findBookByTitle as this will hide the implementation in the future if the process of filtering uses complex
//        // filter criteria like filter by title withCase sensitive . This makes the findBook to change
//        // Also based on Clean code functions with less params is better and books ervice is responsible for service related to book
//       // return this.bookService.findBy(FilterKey.TITLE,title);
//    }

    Book[] findBookByTitle(String title){
        FilterCriteriaBuilder  filterCriteriaBuilder=new SimpleFilterCriteriaBuilder()
                .caseSensitive()
                .addFilterByTitle(title);
        return this.bookService.filterBy(filterCriteriaBuilder.getFilterCriteria());

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
        Serializer<Book> bookSerializer = new SerializeBookCSV(new SimpleStringUtils());
        FileService fileService = fileManagermanager.createFile("books.txt");
        FilePersistence filePersistence = new FilePersistence(fileService);
        BookRepository bookRepository = new SimpleBookRepository(filePersistence,bookSerializer);
        BookService bookService = new SimpleBookService(bookRepository);
        BookManager bookManager = new BookManager(bookService);

        // setup
        setUpFileDb(filePersistence);
        setupBookFilters();

        bookManager.saveBook("Transformers","MartinBay","12321B1231BB");
        Book[] book= bookManager.findBookByTitle("Transformers");
        printBooks(book);
        bookManager.saveBook("Transformers2","MartinBay","12321B1231BB");
        bookManager.saveBook("Transformers3","MartinBay","12321B1231BB");

        book= bookManager.findBookByTitle("Transformers2");
        printBooks(book);
    }
}
