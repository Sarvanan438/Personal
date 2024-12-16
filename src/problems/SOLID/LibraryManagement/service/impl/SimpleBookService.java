package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.FilterKey;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteriaBuilder;
import problems.SOLID.LibraryManagement.dto.Availability;
import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.book.BookCreatorFactory;
import problems.SOLID.LibraryManagement.factories.borrow.BorrowFactory;
import problems.SOLID.LibraryManagement.factories.id.IdFactory;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.repositories.BorrowRepository;
import problems.SOLID.LibraryManagement.service.AvailabilityService;
import problems.SOLID.LibraryManagement.service.BookService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleBookService implements BookService {
    private final IdFactory idFactory;
    private BookRepository bookRepository;
    private  FilterCriteriaBuilder filterCriteriaBuilder;
    private BorrowRepository borrowRepository;
    private AvailabilityService availabilityService;
    public SimpleBookService(BookRepository bookRepository, FilterCriteriaBuilder filterCriteriaBuilder, BorrowRepository borrowRepository, IdFactory idFactory, AvailabilityService availabilityService) {
        this.bookRepository = bookRepository;
        this.filterCriteriaBuilder=filterCriteriaBuilder;
        this.borrowRepository= borrowRepository;
        this.idFactory = idFactory;
        this.availabilityService=availabilityService;
    }

    @Override
    public Book add(BookDTO bookDTO) throws IOException {
        Book book=BookCreatorFactory.createBookFromDTO(bookDTO);
        this.bookRepository.add(book);
        return book;
    }

    @Override
    public Book[] filterBy(FilterCriteria filterCriteria) throws FileNotFoundException {
        return this.bookRepository.findBy(filterCriteria);
    }

    @Override
    public Book getBookById(String id) {
        return this.bookRepository.findById(this.idFactory.generateIdFromString(id));
    }

    private FilterCriteria getTitleEqualFilterCriteria(String title){
        return filterCriteriaBuilder.addFilter(FilterKey.TITLE_EQUALS,title)
                .caseInsensitive()
                .getFilterCriteria();
    }

    public Book[] findBookCopiesByTitle(String title) throws  FileNotFoundException{
        FilterCriteria filterCriteria= this.getTitleEqualFilterCriteria(title);
        Book[] books = this.bookRepository.findBy(filterCriteria);
        return books;
    }
    @Override
    public Availability getBooksAvailability(String title) throws FileNotFoundException {
     return this.availabilityService.createAvailability(List.of(this.findBookCopiesByTitle(title)));
    }

    public Book[] getAvailableCopiesByTitle(String title) throws FileNotFoundException {
        Book[] books  =  this.findBookCopiesByTitle(title);
        List<Book> availableBookCopies = new ArrayList<>();
        for(Book book:books)
        {
            if(!book.isBorrowed())
                availableBookCopies.add(book);
        }
        return availableBookCopies.toArray(new Book[]{});
    }
    @Override
    public Book[] getAvailableBookByTitle(String title) {
        Book[] availableBooks=new Book[]{};
	    try {
		    return this.getAvailableCopiesByTitle(title);
	    } catch (FileNotFoundException e) {
            e.printStackTrace();

	    }
return availableBooks;
    }

    public Book getAvailableBook(String title) throws FileNotFoundException {
        Book[] books  =  this.findBookCopiesByTitle(title);
        for(Book book:books){
            if(this.borrowRepository.findActiveBorrowByBook(book)==null)
                return book;
        }
        return null;
    }
    public Borrow borrowBook(User user, String title) throws Exception {
        Book availableCopy = this.getAvailableBook(title);
        if(availableCopy==null) throw new Exception("No copies available");
        return this.borrowRepository.add(BorrowFactory.createBorrow(user,availableCopy,15));
    }

    public Borrow returnBook(User user , Book book) throws IllegalAccessException, IOException {
        Borrow borrow=this.borrowRepository.findActiveBorrowByBook(book);
        borrow.returnBook();
        this.borrowRepository.update(borrow);
        return borrow;
    }
}
