package problems.SOLID.LibraryManagement.serializer.impl;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.id.IdFactory;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.utilities.StringUtils;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class SerializeUserCSV implements Serializer<User> {
	private StringUtils stringUtils;
	private IdFactory idFactory;

	public SerializeUserCSV(StringUtils stringUtils,IdFactory idFactory) {
		this.stringUtils = stringUtils;
		this.idFactory=idFactory;
	}

	@Override
	public String serialize(User user) {

		return STR."id=\{user.getId()}, name=\{user.getName()}, registeredOn=\{user.getRegisteredOn().toString()}\n";
	}

	@Override
	public User deserialize(String serializedEntity) {
		String[] properties = Arrays.stream(serializedEntity.split(",")).map(entry->stringUtils.getValueFromKeyValueString(entry,"=")).toList().toArray(new String[0]);

		return new User(idFactory.generateIdFromString(properties[0]),properties[1], LocalDate.parse(properties[2]));
	}
}
