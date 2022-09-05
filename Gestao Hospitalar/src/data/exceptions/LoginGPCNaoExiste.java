package data.exceptions;

public class LoginGPCNaoExiste extends Exception{
    public LoginGPCNaoExiste() {
        super();
    }

    public LoginGPCNaoExiste(String message) {
        super(message);
    }

    public LoginGPCNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginGPCNaoExiste(Throwable cause) {
        super(cause);
    }

    protected LoginGPCNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
