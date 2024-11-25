package problems.SOLID.LibraryManagement;

/**
 * will handle things related to service
 */
public interface BookService {
    // we will use Book object as input as the service will only add book i.e persist
    void add(Book book);

    // find a book
    Book findBy(FilterKey key);
}
