package problems.SOLID.LibraryManagement.book_manager;

import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * SOLID
 * S: book manager should be responsible for managing books
 *     what is part of managing books ?
 *     1. CRUD on books
 *     2. manage state of books like wheter they are borrowed or returned , lost etc
 *     3. track who borrowed the books etc , because we need to store the details of how and where the books where taken
 * O: OCP
 *    The book manager implementation should be extensible for changes but not open for changes directly
 *    The book managers crud operation should be easily extensible
 * L : Listkov substitution
 *     The BM should have a interface abstraction that communicates the contract well
 *     The naming should follow cc and should have no sideeffects in any implementation
 * I : should use interface
 * D : dependency inversion
 *   The major operation here is done on the book entity
 *   and the dependency inversion should be about how the book entity is used for managing and maintaing state
 *   here the book and user are the abstractions which both the book manager and service should be depending
 *   Like how the book state changes and who changes it
 */
public interface BookManager {
	Book addBook(String title,String author, String ISBN) throws IOException;
	Book[] findBooksByTitle(String title) throws FileNotFoundException;
	Availability getBookAvailabilityByTitle(String title);
	Borrow borrowBook(User user ,Book book) throws Exception;
	Borrow returnBook(Book book) throws Exception;
	Book[] getAvailableBooksByTitle(String title);
}
