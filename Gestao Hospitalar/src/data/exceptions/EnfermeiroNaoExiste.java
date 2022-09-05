package data.exceptions;

public class EnfermeiroNaoExiste extends Exception{

    public EnfermeiroNaoExiste() {
    }

    public EnfermeiroNaoExiste(String message) {
        super(message);
    }

    public EnfermeiroNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public EnfermeiroNaoExiste(Throwable cause) {
        super(cause);
    }

    public EnfermeiroNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
