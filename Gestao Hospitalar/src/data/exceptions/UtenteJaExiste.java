package data.exceptions;

public class UtenteJaExiste extends Exception{

    public UtenteJaExiste() {
    }

    public UtenteJaExiste(String message) {
        super(message);
    }

    public UtenteJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public UtenteJaExiste(Throwable cause) {
        super(cause);
    }

    public UtenteJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
