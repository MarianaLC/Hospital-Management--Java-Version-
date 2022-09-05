package data.exceptions;

public class MedicoNaoExiste extends Throwable {
    public MedicoNaoExiste() {
    }

    public MedicoNaoExiste(String message) {
        super(message);
    }

    public MedicoNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicoNaoExiste(Throwable cause) {
        super(cause);
    }

    public MedicoNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
