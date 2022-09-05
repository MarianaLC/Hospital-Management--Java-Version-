package data.exceptions;

public class LoginUtenteJaExiste extends Exception{
    public LoginUtenteJaExiste() {
        super();
    }

    public LoginUtenteJaExiste(String message) {
        super(message);
    }

    public LoginUtenteJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginUtenteJaExiste(Throwable cause) {
        super(cause);
    }

    protected LoginUtenteJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
