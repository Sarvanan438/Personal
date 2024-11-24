package problems.usersignup;

public class RegisterationService {
    UserService service;
    RegisterationService(UserService service){
        this.service=service;
    }
    public void handleUserSignup(String email,String password){
         User user = UserCreator.createUser(email,password);
         this.service.saveUser(user);
         this.service.sendWelcomeEmail(user);
    }

}
