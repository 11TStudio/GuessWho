package wieIsHet.model;

/**
 * Standaard exception voor het spel.
 * Niet dat het zal firen, sinds mijn code altijd error-free is baby :P
 *
 * @author LeventHAN
 */
public class WieIsHetException extends RuntimeException {
    public WieIsHetException(String s) {
        super(s);
    }

    public WieIsHetException(Throwable cause) {
        super(cause);
    }
}
