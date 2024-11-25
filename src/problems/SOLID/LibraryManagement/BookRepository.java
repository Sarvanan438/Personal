package problems.SOLID.LibraryManagement;

public interface BookRepository extends Repository<Book>{

    Book findBy(FilterKey key);
}
