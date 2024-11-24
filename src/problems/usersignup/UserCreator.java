package problems.usersignup;

public class UserCreator {

    static User createUser(String email,String password){
        User user= new User(new UserRepository(new MemoryStorage<User>()));
        user.setPassword(password);
        user.setEmail(email);
        return user;
    }
}
