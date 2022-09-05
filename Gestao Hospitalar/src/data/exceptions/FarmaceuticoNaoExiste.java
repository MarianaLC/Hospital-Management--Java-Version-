package data.exceptions;

public class FarmaceuticoNaoExiste extends Exception {

    public FarmaceuticoNaoExiste() {
    }

    public FarmaceuticoNaoExiste(String message) {
        super(message);
    }

    public FarmaceuticoNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public FarmaceuticoNaoExiste(Throwable cause) {
        super(cause);
    }

    public FarmaceuticoNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
