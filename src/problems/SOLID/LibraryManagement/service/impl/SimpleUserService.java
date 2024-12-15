package problems.SOLID.LibraryManagement.service.impl;

import problems.SOLID.LibraryManagement.dto.UserDTO;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.factories.id.IdFactory;
import problems.SOLID.LibraryManagement.factories.user.UserFactory;
import problems.SOLID.LibraryManagement.repositories.UserRepository;
import problems.SOLID.LibraryManagement.service.UserService;

import java.io.IOException;

public class SimpleUserService implements UserService {

	private UserRepository userRepository;
	private IdFactory idFactory;
	public SimpleUserService(UserRepository userRepository, IdFactory idFactory) {
		this.userRepository = userRepository;
		this.idFactory=idFactory;
	}

	@Override
	public User createUser(UserDTO userDTO) throws IOException {
		User user = UserFactory.createUserFromDTO(userDTO);
		return this.userRepository.add(user);

	}

	@Override
	public User getUserById(String id) {
		return this.userRepository.findById(idFactory.generateIdFromString(id));
	}

	@Override
	public User getUserByName(String name) {
		return this.userRepository.getUserByName(name);
	}


}
