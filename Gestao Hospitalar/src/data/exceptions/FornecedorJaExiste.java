package data.exceptions;

public class FornecedorJaExiste extends Exception{
    public FornecedorJaExiste() {
        super();
    }

    public FornecedorJaExiste(String message) {
        super(message);
    }

    public FornecedorJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public FornecedorJaExiste(Throwable cause) {
        super(cause);
    }

    protected FornecedorJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
