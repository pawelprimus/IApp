package pl.prim.iapp.exception.ex;

public class BadRequestEx extends Throwable {
    public BadRequestEx() {
    }

    public BadRequestEx(String message) {
        super(message);
    }

    public BadRequestEx(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestEx(Throwable cause) {
        super(cause);
    }

    public BadRequestEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
