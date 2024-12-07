package problems.SOLID.LibraryManagement.book_manager;

import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterByTitle;
import problems.SOLID.LibraryManagement.bookfilter.BookFilterFactory;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.bookfilter.SimpleFilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.factories.book.BookCreatorFactory;
import problems.SOLID.LibraryManagement.persistence.FilePersistence;
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

    public SimpleBookManager(BookService bookService) {
        this.bookService = bookService;
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
        FilterCriteriaBuilder  filterCriteriaBuilder=new SimpleFilterCriteriaBuilder()
                .caseSensitive()
                .addFilterByTitle(title);
        return this.bookService.filterBy(filterCriteriaBuilder.getFilterCriteria());

    }


}
