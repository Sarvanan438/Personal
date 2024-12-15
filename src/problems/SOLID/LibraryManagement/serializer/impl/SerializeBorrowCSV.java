package problems.SOLID.LibraryManagement.serializer.impl;

import problems.SOLID.LibraryManagement.entities.Book;
import problems.SOLID.LibraryManagement.entities.Borrow;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.id.IdFactory;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.service.BookService;
import problems.SOLID.LibraryManagement.service.UserService;
import problems.SOLID.LibraryManagement.utilities.StringUtils;

import java.time.LocalDate;
import java.util.Arrays;

public class SerializeBorrowCSV implements Serializer<Borrow> {

	StringUtils stringUtils;
	private IdFactory idFactory;

	public SerializeBorrowCSV(StringUtils stringUtils, IdFactory idFactory) {
		this.stringUtils = stringUtils;
		this.idFactory = idFactory;

	}

	@Override
	public String serialize(Borrow entity) {
		return STR."id=\{entity.getId()}, userId=\{entity.getUserId().getId()}, bookId=\{entity.getBookId().getId()}, borrowedDate=\{entity.getBorrowedDate()}, noOfDueDays=\{entity.getNoOfDaysToDue()}, returnedDate=\{entity.getReturnedDate()}";
	}

	@Override
	public Borrow deserialize(String serializedEntity) {
		String[] properties = Arrays.stream(serializedEntity.split(",")).map(entry->stringUtils.getValueFromKeyValueString(entry,"=")).toList().toArray(new String[0]);

		Borrow borrow = new Borrow(idFactory.generateIdFromString(properties[0]),idFactory.generateIdFromString(properties[1]),idFactory.generateIdFromString(properties[2]), LocalDate.parse(properties[3]),Integer.parseInt(properties[4]));
		if(!properties[5].equals("null")) borrow.setReturnedDate(LocalDate.parse(properties[5]));
		return borrow;
	}

}
