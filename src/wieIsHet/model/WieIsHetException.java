package wieIsHet.model;

/**
 * Standaard exception voor het spel.
 */
public class WieIsHetException extends RuntimeException {
    public WieIsHetException(String s) {
        super(s);
    }

    public WieIsHetException(Throwable cause) {
        super(cause);
    }
}
