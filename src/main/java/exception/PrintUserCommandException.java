package exception;

public class PrintUserCommandException extends Exception {
    public PrintUserCommandException() {
        super();
    }

    public PrintUserCommandException(String message) {
        super(message);
    }

    public PrintUserCommandException(String message, Throwable cause) {
        super(message, cause);
    }

    public PrintUserCommandException(Throwable cause) {
        super(cause);
    }

    protected PrintUserCommandException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
