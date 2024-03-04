package pl.prim.iapp.exception.ex;

public class EntityAlreadyExistsEx extends Throwable {
    public EntityAlreadyExistsEx() {
    }

    public EntityAlreadyExistsEx(String message) {
        super(message);
    }

    public EntityAlreadyExistsEx(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityAlreadyExistsEx(Throwable cause) {
        super(cause);
    }

    public EntityAlreadyExistsEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
