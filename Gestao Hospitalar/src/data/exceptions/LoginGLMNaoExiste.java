package data.exceptions;

public class LoginGLMNaoExiste extends Exception{
    public LoginGLMNaoExiste() {
        super();
    }

    public LoginGLMNaoExiste(String message) {
        super(message);
    }

    public LoginGLMNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginGLMNaoExiste(Throwable cause) {
        super(cause);
    }

    protected LoginGLMNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
