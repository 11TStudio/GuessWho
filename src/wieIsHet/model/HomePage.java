package wieIsHet.model;

public class HomePage {
    private String tekst;

    public HomePage() {
    }
    public void leesVoor() {
        tekst = "We zijn goed bezig";
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }
}
