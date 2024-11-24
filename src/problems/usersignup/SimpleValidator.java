package problems.usersignup;

public class SimpleValidator implements Validator{
    @Override
    public boolean validateEmail(String s) {
        return s.contains(".com");
    }

    @Override
    public boolean validatePassword(String s) {
        return s.length()>7;
    }
}
