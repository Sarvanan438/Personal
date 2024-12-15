package problems.SOLID.LibraryManagement.serializer.impl;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.factories.id.IdFactory;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.utilities.StringUtils;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.util.Arrays;

public class SerializeBookCSV implements Serializer<Book> {

    private StringUtils stringUtils;

    public SerializeBookCSV(StringUtils stringUtils) {
        this.stringUtils = stringUtils;
    }

    @Override
    public String serialize(Book book) {
        return book.toString();
    }

    @Override
    public Book deserialize(String serializedEntity) {
         String[] properties = Arrays.stream(serializedEntity.split(",")).map(entry->stringUtils.getValueFromKeyValueString(entry,"=")).toList().toArray(new String[0]);
        return new Book(UUIDUtils.generateUUIDFromString(properties[0]),properties[1],properties[2],properties[3]);
    }
}
