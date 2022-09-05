package data.exceptions;

public class UtenteNaoExiste extends Exception{
    public UtenteNaoExiste() {
    }

    public UtenteNaoExiste(String message) {
        super(message);
    }

    public UtenteNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public UtenteNaoExiste(Throwable cause) {
        super(cause);
    }

    public UtenteNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
