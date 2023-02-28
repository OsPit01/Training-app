package exception;

public class LoginCommandException extends Exception {
    public LoginCommandException() {
    }

    public LoginCommandException(String message) {
        super(message);
    }

    public LoginCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginCommandException(Throwable cause) {
        super(cause);
    }

    public LoginCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
