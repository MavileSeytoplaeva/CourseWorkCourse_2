package pro.sky.courseworkcouse_2.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;

public class StorageIsEmptyException extends RuntimeException {
    public StorageIsEmptyException() {
        super();
    }

    public StorageIsEmptyException(String message) {
        super(message);
    }

    public StorageIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageIsEmptyException(Throwable cause) {
        super(cause);
    }

    protected StorageIsEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
