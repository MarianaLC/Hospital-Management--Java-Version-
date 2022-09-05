package data.exceptions;

public class AtoEnfermagemNaoExiste extends Exception{
    public AtoEnfermagemNaoExiste() {
        super();
    }

    public AtoEnfermagemNaoExiste(String message) {
        super(message);
    }

    public AtoEnfermagemNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoEnfermagemNaoExiste(Throwable cause) {
        super(cause);
    }

    protected AtoEnfermagemNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
