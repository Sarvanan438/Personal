package problems.usersignup;

public class SimpleSanitizer implements  Sanitzer{

    @Override
    public String SantizeString(String s) {
        return s.replace("//","");
    }
}
