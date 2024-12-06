package problems.SOLID.LibraryManagement.repositories;

import java.io.IOException;

/**
 * Here we are assuming T is serializable , for now this consideratoin is fine as we can stringify the data for the persisitence layer
 * The persistence layer will depend on this serilizable to persist the data
 * The Dependency inversion here is the T being serializable
 * @param <T>
 */
public interface Repository <T>{

    void add(T item) throws IOException;

}
