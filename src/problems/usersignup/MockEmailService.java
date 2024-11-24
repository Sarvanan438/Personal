package problems.usersignup;

public class MockEmailService implements EmailService{
    @Override
    public void sendEmail(Email email) {
        System.out.println(STR."Sending email success to \{email.getTo()}");
    }
}
