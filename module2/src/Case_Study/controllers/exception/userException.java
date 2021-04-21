package Case_Study.controllers.exception;

public class userException extends Exception {
    public userException(String message) {
        super(message);
    }

    public userException(String message, Throwable cause) {
        super(message, cause);
    }
}
