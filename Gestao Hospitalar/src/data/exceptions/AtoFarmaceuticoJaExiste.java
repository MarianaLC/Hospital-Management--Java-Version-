package data.exceptions;

public class AtoFarmaceuticoJaExiste extends Exception{
    public AtoFarmaceuticoJaExiste() {
        super();
    }

    public AtoFarmaceuticoJaExiste(String message) {
        super(message);
    }

    public AtoFarmaceuticoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoFarmaceuticoJaExiste(Throwable cause) {
        super(cause);
    }

    protected AtoFarmaceuticoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
