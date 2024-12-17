package problems.SOLID.LibraryManagement.repositories;

import problems.SOLID.LibraryManagement.entities.Id;
import problems.SOLID.LibraryManagement.entities.User;
import problems.SOLID.LibraryManagement.persistence.Persistence;
import problems.SOLID.LibraryManagement.serializer.Serializer;
import problems.SOLID.LibraryManagement.utilities.impl.UUIDUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SimpleUserRepository implements UserRepository{
	Persistence<User> filePersistence ;
	Serializer<User> userSerializer;

	public SimpleUserRepository(Persistence<User> filePersistence, Serializer<User> userSerializer) {
		this.filePersistence = filePersistence;
		this.userSerializer = userSerializer;
	}

	private String serializeUser(User user){
		return this.userSerializer.serialize(user);
	}
	private User deserializeUser(String user){
		return this.userSerializer.deserialize(user);
	}
	public User[] getAllUsers() throws FileNotFoundException {
		String[] users =this.filePersistence.findAll();
		return Arrays.stream(users).map(this::deserializeUser).toList().toArray(new User[]{});
	}
	@Override
	public User add(User item) throws IOException {
		this.filePersistence.insert(this.serializeUser(item));
		return item;
	}

		@Override
		public User findById(Id id) {
			try{
				return (User)UUIDUtils.findIdMatch(List.of(this.getAllUsers()),id);
			}catch (Exception e){
				System.out.println("No user found for id: "+id.getId());
			}
			return null;
		}

	@Override
	public User getUserByName(String name) {
		try{
			User[] users = this.getAllUsers();

			for(User user:users){
				if(user.getName().contains(name))
					return user;
			}

		}catch (Exception e){
			System.out.println("No user found for name: "+name);
			e.printStackTrace();
		}
		return null;
	}
}
