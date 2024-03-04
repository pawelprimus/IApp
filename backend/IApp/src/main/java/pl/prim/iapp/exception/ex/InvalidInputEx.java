package pl.prim.iapp.exception.ex;

public class InvalidInputEx extends Throwable{
    public InvalidInputEx() {
    }

    public InvalidInputEx(String message) {
        super(message);
    }

    public InvalidInputEx(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputEx(Throwable cause) {
        super(cause);
    }

    public InvalidInputEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
