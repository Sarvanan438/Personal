package problems.usersignup;

public class EmailCreator {

    static Email createEmail(String content,String to,String from){
        return new Email(content,to,from,new MockEmailService());
    }
}
