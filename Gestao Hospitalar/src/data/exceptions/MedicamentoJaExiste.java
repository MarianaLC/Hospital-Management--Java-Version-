package data.exceptions;

public class MedicamentoJaExiste extends Exception {
    public MedicamentoJaExiste() {
        super();
    }

    public MedicamentoJaExiste(String message) {
        super(message);
    }

    public MedicamentoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicamentoJaExiste(Throwable cause) {
        super(cause);
    }

    protected MedicamentoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
