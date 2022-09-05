package data.exceptions;

public class FornecedorNaoExiste extends Exception{
    public FornecedorNaoExiste() {
        super();
    }

    public FornecedorNaoExiste(String message) {
        super(message);
    }

    public FornecedorNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public FornecedorNaoExiste(Throwable cause) {
        super(cause);
    }

    protected FornecedorNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
