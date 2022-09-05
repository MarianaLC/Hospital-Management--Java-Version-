package data.exceptions;

public class MedicoJaExiste extends Throwable {
    public MedicoJaExiste() {
    }

    public MedicoJaExiste(String message) {
        super(message);
    }

    public MedicoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicoJaExiste(Throwable cause) {
        super(cause);
    }

    public MedicoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

