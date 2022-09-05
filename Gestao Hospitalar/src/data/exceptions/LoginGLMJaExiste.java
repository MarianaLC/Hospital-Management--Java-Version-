package data.exceptions;

public class LoginGLMJaExiste extends Exception{
    public LoginGLMJaExiste() {
        super();
    }

    public LoginGLMJaExiste(String message) {
        super(message);
    }

    public LoginGLMJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginGLMJaExiste(Throwable cause) {
        super(cause);
    }

    protected LoginGLMJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
