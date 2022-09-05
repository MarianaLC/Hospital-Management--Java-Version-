package data.exceptions;

public class MedicamentoNaoExiste extends Exception {

    public MedicamentoNaoExiste() {
    }

    public MedicamentoNaoExiste(String message) {
        super(message);
    }

    public MedicamentoNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public MedicamentoNaoExiste(Throwable cause) {
        super(cause);
    }

    public MedicamentoNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
