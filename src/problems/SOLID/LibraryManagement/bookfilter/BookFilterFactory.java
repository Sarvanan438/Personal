package problems.SOLID.LibraryManagement.bookfilter;

import problems.SOLID.LibraryManagement.FilterKey;

import java.util.HashMap;

public class BookFilterFactory {
    public static HashMap<FilterKey, BookFilter> filter=new HashMap<>();
    public static void registerBookFilter(FilterKey key,BookFilter filter){
        BookFilterFactory.filter.put(key,filter);
    }
    public static BookFilter createBookFilter(FilterKey key){
        return BookFilterFactory.filter.get(key);
    }
}
