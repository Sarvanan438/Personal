package problems.usersignup;

public interface UserService {
   void saveUser(User user);
   void sendWelcomeEmail(User user);
}
