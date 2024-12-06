package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.repositories.BookRepository;

import java.io.IOException;

public class SimpleBookService implements BookService{
    private BookRepository bookRepository;

    public SimpleBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void add(Book book) throws IOException {
        this.bookRepository.add(book);
    }

    @Override
    public Book[] filterBy(FilterCriteria filterCriteria) {
        return this.bookRepository.findBy(filterCriteria);
    }

}
