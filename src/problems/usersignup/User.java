package problems.usersignup;

public class User {
    private String email,password;
    private Repository<User> userRepository;
    User(Repository<User> userRepository){
        this.userRepository=userRepository;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void save(){
        this.userRepository.save(this);
    }
}
