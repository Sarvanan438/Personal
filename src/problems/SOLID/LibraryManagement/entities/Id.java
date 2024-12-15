package problems.SOLID.LibraryManagement.entities;

public interface Id {

	String getId();
	void setId(String id);
	boolean isEqual(Id id);
}
