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




    @Override
    public Availability getBooksAvailability(String title) throws Exception {
     return this.availabilityService.createAvailability(title);
    }

    @Override
    public Book[] getAvailableBookByTitle(String title) {
        try {
            return this.getBooksAvailability(title).getAvailableBooks();
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Book[]{};
    }



}
