package problems.usersignup;

public class SimpleUserService implements UserService{

    private Validator validator;
    private Sanitzer sanitzer;

    public SimpleUserService(Validator validator, Sanitzer sanitzer) {
        this.validator = validator;
        this.sanitzer = sanitzer;
    }
    // improve with Chain of resposibility principle
    public void validateUser(User user){
        if(this.validator.validateEmail(user.getEmail()) && this.validator.validatePassword(user.getPassword()))
            return;
        throw new IllegalArgumentException();
    }
    public void sanitizeUser(User user){
        user.setEmail(this.sanitzer.SantizeString(user.getEmail()));
        user.setPassword(this.sanitzer.SantizeString(user.getPassword()));
    }
    @Override
    public void saveUser(User user) {
        this.validateUser(user);
        this.sanitizeUser(user);
        user.save();
    }

    @Override
    public void sendWelcomeEmail(User user) {
        Email email=EmailCreator.createEmail(STR."Welcome \{user.getEmail()} , please refer below for details.",user.getEmail(),"Facebood");
        email.send();
    }
}
