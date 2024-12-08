package problems.SOLID.LibraryManagement;

import problems.SOLID.LibraryManagement.book_manager.BookManager;
import problems.SOLID.LibraryManagement.book_manager.SimpleBookManager;
import problems.SOLID.LibraryManagement.bookfilter.BookFilter;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterByTitle;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.bookfilter.CompositeFilter;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.factories.fileservice.FileServiceFactory;
import problems.SOLID.LibraryManagement.factories.fileservice.SimpleFileServiceFactory;
import problems.SOLID.LibraryManagement.persistence.FilePersistence;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.repositories.SimpleBookRepository;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.serializer.impl.SerializeBookCSV;
import problems.SOLID.LibraryManagement.service.*;
import problems.SOLID.LibraryManagement.service.impl.SimpleBookService;
import problems.SOLID.LibraryManagement.service.impl.SimpleFileManager;
import problems.SOLID.LibraryManagement.utilities.FileReader;
import problems.SOLID.LibraryManagement.utilities.FileWriter;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleFileReader;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleFileWriter;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleStringUtils;

import java.io.File;
import java.io.IOException;

public class LibraryManagement {
	public static void  setUpFileDb(FilePersistence persistence) throws IOException {
		persistence.clearAll();;
	}
	public static void setupBookFilters(){
		BookFilterFactory.registerBookFilter(FilterKey.TITLE,new BookFilterByTitle());
		BookFilterFactory.registerBookFilter(FilterKey.COMPOSITE,new CompositeFilter());
	}
	public static void printBooks(Book[] books){
		for(Book book:books){
			System.out.println(book);
		}
	}
	public static void main(String[] args) throws IOException {
		FileManager fileManager = new SimpleFileManager();
		Serializer<Book> bookSerializer = new SerializeBookCSV(new SimpleStringUtils());
		File file = fileManager.createFile("books.txt");
		FileWriter writer =  new SimpleFileWriter(file);
		FileReader reader = new SimpleFileReader(file);
		FilePersistence filePersistence = new FilePersistence(writer,reader);
		BookRepository bookRepository = new SimpleBookRepository(filePersistence,bookSerializer);
		BookService bookService = new SimpleBookService(bookRepository);
		BookManager bookManager = new SimpleBookManager(bookService);

		// setup
		setUpFileDb(filePersistence);
		setupBookFilters();

		bookManager.addBook("Transformers","MartinBay","12321B1231BB");
		Book[] book= bookManager.findBooksByTitle("Transformers");
		printBooks(book);
		bookManager.addBook("Transformers2","MartinBay","12321B1231BB");
		bookManager.addBook("Transformers3","MartinBay","12321B1231BB");

		book= bookManager.findBooksByTitle("Transformers2");
		printBooks(book);
	}
}
