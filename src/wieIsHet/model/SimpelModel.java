package wieIsHet.model;

public class SimpelModel {
    // CHEATSHEET
    // public static final constanten

    // private attributenpublic ApplicatieNaamModel() {
            // Constructor
    // }

    // implementatie logica van de
    // applicatie ahv methods

    // implementatie van de nodige Getters

    // implementatie van de nodige Setters

    private String tekst;

    public SimpelModel() {
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
