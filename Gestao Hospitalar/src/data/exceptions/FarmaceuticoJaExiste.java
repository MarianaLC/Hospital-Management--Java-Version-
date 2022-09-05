package data.exceptions;

public class FarmaceuticoJaExiste extends Exception {
    public FarmaceuticoJaExiste() {
    }

    public FarmaceuticoJaExiste(String message) {
        super(message);
    }

    public FarmaceuticoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public FarmaceuticoJaExiste(Throwable cause) {
        super(cause);
    }

    public FarmaceuticoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
