package problems.SOLID.LibraryManagement.user_manager;

import problems.SOLID.LibraryManagement.entities.User;

import java.io.IOException;

public interface UserManager {
	User createUser(String name) throws IOException;
	User getUserById(String id);
	User getUserByName(String name);
}
