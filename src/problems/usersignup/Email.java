package problems.usersignup;

public class Email {
    final String content,to,from;
    private EmailService emailService;
    public Email(String content, String to, String from,EmailService emailService) {
        this.content = content;
        this.to = to;
        this.from = from;
        this.emailService=emailService;
    }

    public String getContent() {
        return content;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void send(){
        this.emailService.sendEmail(this);
    }
}
