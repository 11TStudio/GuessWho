package wieIsHet.model;


// Onze classe Persoange
// Comparable implementeert altijd de klasse waar het implements.

public class Vraag {

    private String vraag;
    private boolean isGevraagd;

    public Vraag(String vraag, boolean isGevraagd) {
        this.vraag = vraag;
        this.isGevraagd = isGevraagd;
    }

    public String getVraag() {
        return vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public boolean isGevraagd() {
        return isGevraagd;
    }

    public void setGevraagd(boolean gevraagd) {
        isGevraagd = gevraagd;
    }


    @Override
    public String toString() {
        return vraag + ';' + isGevraagd;
    }
}
