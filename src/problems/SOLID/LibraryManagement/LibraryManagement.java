package problems.SOLID.LibraryManagement;

import problems.SOLID.LibraryManagement.book_manager.BookManager;
import problems.SOLID.LibraryManagement.book_manager.SimpleBookManager;
import problems.SOLID.LibraryManagement.bookfilter.*;
import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.id.StringIdFactory;
import problems.SOLID.LibraryManagement.persistence.FilePersistence;
import problems.SOLID.LibraryManagement.repositories.*;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.serializer.impl.SerializeBookCSV;
import problems.SOLID.LibraryManagement.serializer.impl.SerializeBorrowCSV;
import problems.SOLID.LibraryManagement.serializer.impl.SerializeUserCSV;
import problems.SOLID.LibraryManagement.service.*;
import problems.SOLID.LibraryManagement.service.impl.*;
import problems.SOLID.LibraryManagement.user_manager.SimpleUserManager;
import problems.SOLID.LibraryManagement.user_manager.UserManager;
import problems.SOLID.LibraryManagement.utilities.FileReader;
import problems.SOLID.LibraryManagement.utilities.FileWriter;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleFileReader;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleFileWriter;
import problems.SOLID.LibraryManagement.utilities.impl.SimpleStringUtils;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.io.File;
import java.io.IOException;


public class LibraryManagement {
	public static void  setUpFileDb(FilePersistence persistence) throws IOException {
		persistence.clearAll();;
	}
	public static void setupBookFilters(){
		BookFilterFactory.registerBookFilter(FilterKey.TITLE,new BookFilterByTitle(FilterKey.TITLE,Conditions.CONTAINS));
		BookFilterFactory.registerBookFilter(FilterKey.COMPOSITE,new CompositeFilter());
		BookFilterFactory.registerBookFilter(FilterKey.TITLE_EQUALS, new BookFilterByTitle(FilterKey.TITLE_EQUALS,Conditions.EQUAL));
	}
	public static void printBooks(Book[] books){
		for(Book book:books){
			System.out.println(book);
		}
	}
	public static void setupUtils(){
		UUIDUtils.setIdFactory(new StringIdFactory());
	}

	public static FilePersistence generatePersistence(String filename) throws IOException {
		FileManager fileManager = new SimpleFileManager();
		File file = fileManager.createFile(filename);
		FileWriter writer =  new SimpleFileWriter(file);
		FileReader reader = new SimpleFileReader(file);
		FilePersistence filePersistence = new FilePersistence(writer,reader);
		return filePersistence;
	}
	public static void setupUsers(UserManager manager) throws IOException {
		manager.createUser("John");
		manager.createUser("John Doe");
		manager.createUser("Terminator");

	}
	public static void printUser(User user){
		System.out.println(user.toString());
	}
	public static void main(String[] args) throws Exception {

		Serializer<Book> bookSerializer = new SerializeBookCSV(new SimpleStringUtils());
		SerializeBorrowCSV borrowSerializer = new SerializeBorrowCSV(new SimpleStringUtils(),new StringIdFactory());
		FilePersistence borrowPersistence = generatePersistence("borrow.txt");
		BorrowRepository borrowRepository = new SimpleBorrowRepository(borrowPersistence,borrowSerializer);
		FilePersistence bookFilePersistence = generatePersistence("books.txt");
		BookRepository bookRepository = new SimpleBookRepository(bookFilePersistence,bookSerializer,borrowRepository);
		BookService bookService = new SimpleBookService(bookRepository,new SimpleFilterCriteriaBuilder(),borrowRepository,new StringIdFactory(),new SimpleAvailabilityService());

		Serializer<User> userSerializer = new SerializeUserCSV(new SimpleStringUtils(),new StringIdFactory());
		FilePersistence userFilePersistence =generatePersistence("users.txt");
		UserRepository userRepository = new SimpleUserRepository(userFilePersistence,userSerializer);
		UserService userService = new SimpleUserService(userRepository,new StringIdFactory());
		UserManager userManager =  new SimpleUserManager(userService);
		BorrowService borrowService = new SimpleBorrowService(borrowRepository,bookService,userService);
		BookManager bookManager = new SimpleBookManager(bookService,borrowService);
		// setup
		setupUtils();
		setUpFileDb(bookFilePersistence);
		setUpFileDb(userFilePersistence);
		setupBookFilters();
		setupUsers(userManager);
		bookManager.addBook("Transformers","MartinBay","12321B1231BB");
		bookManager.addBook("Transformers","MartinBay","12321B1231BB");
		Book[] book= bookManager.findBooksByTitle("Transformers");
		printBooks(book);
		bookManager.addBook("Transformers2","MartinBay","12321B1231BB");
		bookManager.addBook("Transformers3","MartinBay","12321B1231BB");

		book= bookManager.findBooksByTitle("Transformers2");
		printBooks(book);
		printUser(userManager.getUserByName("John"));
		Availability availability=bookManager.getBookAvailabilityByTitle("Transformers");

		System.out.println(STR."\{availability.getBook()} \{availability.getAvailableCopies()}");
		User john  =  userManager.getUserByName("John");
		Book[] availableBooksByTitle=bookManager.getAvailableBooksByTitle("Transformers");
		Book borrowingBook = availableBooksByTitle[0];
		Borrow borrow=bookManager.borrowBook(john.getId(),borrowingBook.getId());

		System.out.println(borrow);
		borrow=borrowService.getActiveBorrowByBook(availableBooksByTitle[0].getId());
		System.out.println("Getting active borrow "+borrow);
		availableBooksByTitle = bookManager.getAvailableBooksByTitle("Transformers");
		printBooks(availableBooksByTitle);
		Borrow[] borrows = borrowService.getActiveBorrowByUser(john.getId());
		System.out.println("Active borrows for user " +borrows[0]);
		borrow = bookManager.returnBook(borrowingBook.getId());
		System.out.println("Returned book "+borrow);
		borrow=borrowService.getActiveBorrowByBook(availableBooksByTitle[0].getId());
		System.out.println("Getting active borrow "+borrow);
		availableBooksByTitle = bookManager.getAvailableBooksByTitle("Transformers");
		printBooks(availableBooksByTitle);
		borrows = borrowService.getActiveBorrowByUser(john.getId());
		System.out.println("Active borrows for user " +borrows.length);


	}
}
