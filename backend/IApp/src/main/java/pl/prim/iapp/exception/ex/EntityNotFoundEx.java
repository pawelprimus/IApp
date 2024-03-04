package pl.prim.iapp.exception.ex;

public class EntityNotFoundEx extends Throwable{
    public EntityNotFoundEx() {
    }

    public EntityNotFoundEx(String message) {
        super(message);
    }

    public EntityNotFoundEx(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityNotFoundEx(Throwable cause) {
        super(cause);
    }

    public EntityNotFoundEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
