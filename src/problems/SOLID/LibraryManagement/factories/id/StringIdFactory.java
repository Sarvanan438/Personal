package problems.SOLID.LibraryManagement.factories.id;

import problems.SOLID.LibraryManagement.entities.Id;
import problems.SOLID.LibraryManagement.entities.StringId;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.util.UUID;

public class StringIdFactory implements IdFactory{
	@Override
	public Id generateId() {
		return new StringId(UUID.randomUUID().toString());
	}

	@Override
	public Id generateIdFromString(String id) {
		return new StringId(id);
	}
}
