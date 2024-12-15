package problems.SOLID.LibraryManagement.factories.id;

import problems.SOLID.LibraryManagement.entities.Id;

public interface IdFactory {
	 Id generateId();
	 Id generateIdFromString(String id);
}
