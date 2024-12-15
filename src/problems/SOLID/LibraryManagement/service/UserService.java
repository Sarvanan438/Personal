package problems.SOLID.LibraryManagement.service;

import problems.SOLID.LibraryManagement.dto.UserDTO;
import problems.SOLID.LibraryManagement.entities.User;

import java.io.IOException;

public interface UserService {
	User createUser(UserDTO user) throws IOException;
	User getUserById(String id);
	User getUserByName(String name);
}
