package data.exceptions;

public class AtoEnfermagemJaExiste extends Exception {
    public AtoEnfermagemJaExiste() {
        super();
    }

    public AtoEnfermagemJaExiste(String message) {
        super(message);
    }

    public AtoEnfermagemJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoEnfermagemJaExiste(Throwable cause) {
        super(cause);
    }

    protected AtoEnfermagemJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
