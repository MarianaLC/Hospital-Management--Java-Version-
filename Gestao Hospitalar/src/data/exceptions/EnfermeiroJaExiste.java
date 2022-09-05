package data.exceptions;

public class EnfermeiroJaExiste extends Exception{

    public EnfermeiroJaExiste() {
    }

    public EnfermeiroJaExiste(String message) {
        super(message);
    }

    public EnfermeiroJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public EnfermeiroJaExiste(Throwable cause) {
        super(cause);
    }

    public EnfermeiroJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
