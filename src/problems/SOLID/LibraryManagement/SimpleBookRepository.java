package problems.SOLID.LibraryManagement;

import java.util.Arrays;

/**
 * The respository is responsible for working with the persistence layer to
 * transform or query information
 */
public class SimpleBookRepository implements BookRepository{
    Persistence<Book> filePersistence ;
    SimpleBookRepository(Persistence<Book> filePersistence){
        this.filePersistence=filePersistence;
    }

    @Override
    public Book findBy(FilterKey key) {
        Book[] books =this.filePersistence.findAll();
        // implemm
        Arrays.stream(books).filter(book -> )
    }

    @Override
    public void add(Book book) {

    }
}
