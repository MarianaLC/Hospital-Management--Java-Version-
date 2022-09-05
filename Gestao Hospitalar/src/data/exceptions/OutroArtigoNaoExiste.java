package data.exceptions;

public class OutroArtigoNaoExiste extends Exception{

    public OutroArtigoNaoExiste() {
        super();
    }

    public OutroArtigoNaoExiste(String message) {
        super(message);
    }

    public OutroArtigoNaoExiste(String message, Throwable cause) {
        super(message, cause);
    }

    public OutroArtigoNaoExiste(Throwable cause) {
        super(cause);
    }

    protected OutroArtigoNaoExiste(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
