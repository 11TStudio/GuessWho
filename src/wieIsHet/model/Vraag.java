package wieIsHet.model;

/**
 * De klasse maakt een object Vraag waar het de vraag zelf en zijn status geconstructeerd worden.
 * Elk attribuut heeft een getter en een setter zodat we het aan kunnen passen van andere package.
 *
 * @version 1.0
 * @author LeventHAN
 */
public class Vraag {

    private String vraag;
    private boolean isGevraagd;

    public Vraag(String vraag, boolean isGevraagd) {
        this.vraag = vraag;
        this.isGevraagd = isGevraagd;
    }

    /**
     * Getter voor de vraag
     *
     * @return vraag
     */
    public String getVraag() {
        return vraag;
    }

    /**
     * Setter voor de vraag
     *
     * @param vraag een string met de vraag
     */
    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    /**
     * Getter voor de vraag status
     *
     * @return een boolean true als het gevraagd is
     */
    public boolean isGevraagd() {
        return isGevraagd;
    }

    /**
     * Setter voor de status van de vraag
     *
     * @param gevraagd een boolean met de status van de vraag
     */
    public void setGevraagd(boolean gevraagd) {
        isGevraagd = gevraagd;
    }

    /**
     * toString() methode voor logging doelen
     *
     * @return den vraag;status als string
     */
    @Override
    public String toString() {
        return vraag + ';' + isGevraagd;
    }
}
