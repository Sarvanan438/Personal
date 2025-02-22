package problems.SOLID.LibraryManagement.utilities.impl;

import problems.SOLID.LibraryManagement.entities.Id;
import problems.SOLID.LibraryManagement.entities.StringId;
import problems.SOLID.LibraryManagement.factories.id.IdFactory;

import java.util.List;
import java.util.UUID;

public class UUIDUtils {
	private static IdFactory idFactory;
	public static Id generateUUID(){
		return idFactory.generateId();
	}

	public static Id generateUUIDFromString(String id){
		return idFactory.generateIdFromString(id);
	}

	public static void setIdFactory(IdFactory idFactory){
		UUIDUtils.idFactory=idFactory;
	}

	public static Id findIdMatch(List<Id> ids,Id matchId){
		return ids.stream().filter(id->id.isEqual(matchId)).findFirst().get();
	}
}
