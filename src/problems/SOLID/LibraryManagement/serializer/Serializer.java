package problems.SOLID.LibraryManagement.serializer;

public interface Serializer<T> {
    String serialize(T entity);
    T deserialize(String serializedEntity);
}
