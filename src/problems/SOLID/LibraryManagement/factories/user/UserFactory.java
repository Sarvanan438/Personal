package problems.SOLID.LibraryManagement.factories.user;

import problems.SOLID.LibraryManagement.dto.UserDTO;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.time.LocalDate;
import java.util.Date;

public class UserFactory {

	public static User createUserFromDTO(UserDTO user){
		return new User(UUIDUtils.generateUUID(),user.name, LocalDate.now());
	}

	public static UserDTO createDTO(String name){
		return new UserDTO(name);
	}


}
