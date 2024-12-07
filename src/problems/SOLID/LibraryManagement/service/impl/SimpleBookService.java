package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.dto.BookDTO;
import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.bookfilter.FilterCriteria;
import problems.SOLID.LibraryManagement.factories.book.BookCreatorFactory;
import problems.SOLID.LibraryManagement.repositories.BookRepository;
import problems.SOLID.LibraryManagement.service.BookService;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SimpleBookService implements BookService {
    private BookRepository bookRepository;

    public SimpleBookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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

}
