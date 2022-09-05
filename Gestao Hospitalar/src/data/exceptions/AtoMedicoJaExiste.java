package data.exceptions;

public class AtoMedicoJaExiste extends Exception {
    public AtoMedicoJaExiste() {
        super();
    }

    public AtoMedicoJaExiste(String message) {
        super(message);
    }

    public AtoMedicoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoMedicoJaExiste(Throwable cause) {
        super(cause);
    }

    protected AtoMedicoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
