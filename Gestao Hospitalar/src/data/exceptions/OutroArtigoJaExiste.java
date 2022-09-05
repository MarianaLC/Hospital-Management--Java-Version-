package data.exceptions;

public class OutroArtigoJaExiste extends Exception{
    public OutroArtigoJaExiste() {
        super();
    }

    public OutroArtigoJaExiste(String message) {
        super(message);
    }

    public OutroArtigoJaExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public OutroArtigoJaExiste(Throwable cause) {
        super(cause);
    }

    protected OutroArtigoJaExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
