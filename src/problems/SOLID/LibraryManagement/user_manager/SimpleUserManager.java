package problems.SOLID.LibraryManagement.user_manager;

import problems.SOLID.LibraryManagement.dto.UserDTO;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.user.UserFactory;
import problems.SOLID.LibraryManagement.service.UserService;

import java.io.IOException;


public class SimpleUserManager implements UserManager{

	private UserService userService;

	public SimpleUserManager(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User createUser(String name) throws IOException {
		UserDTO userDTO = UserFactory.createDTO(name);
		return this.userService.createUser(userDTO);
	}

	@Override
	public User getUserById(String id) {
		return this.userService.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		return this.userService.getUserByName(name);
	}
}
