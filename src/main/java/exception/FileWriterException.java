package exception;

public class FileWriterException extends RuntimeException {

    public FileWriterException() {
        super();
    }

    public FileWriterException(String message) {
        super(message);
    }

    public FileWriterException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileWriterException(Throwable cause) {
        super(cause);
    }

    protected FileWriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
