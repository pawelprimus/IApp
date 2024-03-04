package pl.prim.iapp.exception.ex;

public class ForbiddenEx extends Throwable{
    public ForbiddenEx() {
    }

    public ForbiddenEx(String message) {
        super(message);
    }

    public ForbiddenEx(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenEx(Throwable cause) {
        super(cause);
    }

    public ForbiddenEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
