package data.exceptions;

public class AtoFarmaceuticoNaoExiste extends Exception{
    public AtoFarmaceuticoNaoExiste() {
        super();
    }

    public AtoFarmaceuticoNaoExiste(String message) {
        super(message);
    }

    public AtoFarmaceuticoNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoFarmaceuticoNaoExiste(Throwable cause) {
        super(cause);
    }

    protected AtoFarmaceuticoNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
