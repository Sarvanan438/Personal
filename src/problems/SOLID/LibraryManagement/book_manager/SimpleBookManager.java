package problems.SOLID.LibraryManagement.book_manager;

import problems.SOLID.LibraryManagement.bookfilter.FilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.bookfilter.SimpleFilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.factories.book.BookCreatorFactory;
import problems.SOLID.LibraryManagement.service.*;

import java.io.*;



/**
 * SOLID on iteration 1
 * S:
 *  1. The book manager handles CRUD and  book state management using the book service
 *  2. it sets up the initial configuration and object creation process as its is currently used as entrypoint or controller for app
 */
public class SimpleBookManager implements  BookManager{
    private BookService bookService ;
    private BorrowService borrowService;
    public SimpleBookManager(BookService bookService,BorrowService borrowService) {
        this.bookService = bookService;
        this.borrowService=borrowService;
    }

    public Book addBook(String title, String author, String ISBN) throws IOException{
        BookDTO bookDTO = BookCreatorFactory.createDTO(title,author,ISBN);
        return this.bookService.add(bookDTO);

    }

//    Book[] findBook(String title) throws FileNotFoundException {
//        // this line makes the book manager be aware of filter key instead expose functionality from
//        // book service like findBookByTitle as this will hide the implementation in the future if the process of filtering uses complex
//        // filter criteria like filter by title withCase sensitive . This makes the findBook to change
//        // Also based on Clean code functions with less params is better and books ervice is responsible for service related to book
//       // return this.bookService.findBy(FilterKey.TITLE,title);
//    }

    public Book[] findBooksByTitle(String title) throws FileNotFoundException {
        // the manager shouldn't be aware of how to build the filterCriteria
        // it should be dumb and let the bussiness logic like the service layer to handle building this filter
        FilterCriteriaBuilder  filterCriteriaBuilder=new SimpleFilterCriteriaBuilder()
                .caseSensitive()
                .addFilterByTitle(title);
        return this.bookService.filterBy(filterCriteriaBuilder.getFilterCriteria());

    }

    @Override
    public Availability getBookAvailabilityByTitle(String title) {
	    try {
		    Availability availability = this.bookService.getBooksAvailability(title);
            return availability;
	    } catch (FileNotFoundException e) {
            e.printStackTrace();
	    }
        return null;
    }

    @Override
    public Borrow borrowBook(String userId, String  bookId) throws Exception {
        // replace with ids as the user and book object creation becomes job of manager
        // also let the service layer handle this fetch as it can fetch updated entries
        // the manger is basically a orchestrator at high level so should not know how the serviec layaer works
        // having the Book and user object directly tightly couples and limit the evolvability of the service layer
        // having ids is better as it is simple , light weight and let service layer handle the fetch logic
        // this also lets each layer evolve independently on thier own , instead of tightly coupling
        // this bloats the manager with responsiblity of validation ,checks etc and abstraction leak
        return this.borrowService.borrowBook(userId,bookId);
    }

    @Override
    public Borrow returnBook(String bookId) throws Exception {
        return this.borrowService.returnBook(bookId);
    }

    @Override
    public Book[] getAvailableBooksByTitle(String title) {
        return this.bookService.getAvailableBookByTitle(title);
    }


}
