package problems.usersignup;

/**
 * Requirements :
 * sign up user and send welcome email
 * we need to validate and sanitze user input , save user
 * on successful save , create welcome email and send it
 */
/**
 * validate user
 * only validate user input
 */
/**
 * sanitize the input
 * sanitize the input
 */

/**
 * Saving user
 * save the user and return saved clean_code.User
 */

/**
 * send welcome email
 */

/**
 * here main is the entry point and the UserService will have function to handle user signup
 * the user signup service function will handle both user save and notify
 * 1. as signup businness logic includes saving user and sending welcome email
 *      because in the future if we decide to change the sign up to include send message this would be mean all even endpoint
 *      i.e controller to change
 * 2. So having a single business logic endpoint will be better , let name it handleUserSingup : this is not clean_code.User service
 * but will use both user service and email service
 */

/**
 * clean_code.User service will have functionality related to user implementation . This will be a object
 * As it will only expose abstractions related to user , like transform ,save , get etc . Basically have user accessors and
 * functionality like send welcome email for a user
 * functions
 * save user
 * send welcome email
 */
/**
 * Validation utils
 * validate email
 * validate password
 */
/**
 * Sanitizer
 * santize strings
 */

/**
 * clean_code.User like a active record has navigational methods like save etc
 * The save will use user repository to save , the actual save and find will be handled by this repository
 */

/**
 * Email repository
 * send email
 */

public class UserSignUp {

    public static void main(String[] args) {
        RegisterationService service = new RegisterationService(new SimpleUserService(new SimpleValidator(),new SimpleSanitizer()));

        service.handleUserSignup("hunter@gmail.com","strong");
    }
}
