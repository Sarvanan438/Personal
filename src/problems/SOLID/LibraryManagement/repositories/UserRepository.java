package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.entities.User;

public interface UserRepository extends Repository<User> {
	User getUserByName(String name);
}
