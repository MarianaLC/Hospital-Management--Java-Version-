package data.exceptions;

public class LoginUtenteNaoExiste extends Exception{
    public LoginUtenteNaoExiste() {
        super();
    }

    public LoginUtenteNaoExiste(String message) {
        super(message);
    }

    public LoginUtenteNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginUtenteNaoExiste(Throwable cause) {
        super(cause);
    }

    protected LoginUtenteNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
