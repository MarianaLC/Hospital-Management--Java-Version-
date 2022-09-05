package data.exceptions;

public class AtoMedicoNaoExiste extends Exception{
    public AtoMedicoNaoExiste() {
        super();
    }

    public AtoMedicoNaoExiste(String message) {
        super(message);
    }

    public AtoMedicoNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public AtoMedicoNaoExiste(Throwable cause) {
        super(cause);
    }

    protected AtoMedicoNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
