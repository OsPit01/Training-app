package exception;

import java.io.FileNotFoundException;

public class FileReaderException extends RuntimeException {

    public FileReaderException() {
        super();
    }

    public FileReaderException(String s) {
        super(s);
    }
}
