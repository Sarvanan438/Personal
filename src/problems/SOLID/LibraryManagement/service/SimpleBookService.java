package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.Book;
import problems.SOLID.LibraryManagement.FilterKey;
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
    public Book[] findBy(FilterKey key,String pattern) {
        return this.bookRepository.findBy(key,pattern);
    }
}
