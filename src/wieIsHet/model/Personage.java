package wieIsHet.model;


// Onze classe Persoange
// Comparable implementeert altijd de klasse waar het implements.

public class Personage  {

    private String naam;
    private String heeftBaard;
    private String oogKleur;
    private String heeftBril;
    private String heeftSnor;
    private String typeGeslacht;
    private String isKaal;
    private String heeftHoofddeksel;
    private String haarKleur;
    private String isActive;

    public Personage(String naam, String heeftBaard, String oogKleur, String heeftBril, String heeftSnor, String typeGeslacht, String isKaal, String heeftHoofddeksel, String haarKleur, String status) {
        this.naam = naam;
        this.heeftBaard = heeftBaard;
        this.oogKleur = oogKleur;
        this.heeftBril = heeftBril;
        this.heeftSnor = heeftSnor;
        this.typeGeslacht = typeGeslacht;
        this.isKaal = isKaal;
        this.heeftHoofddeksel = heeftHoofddeksel;
        this.haarKleur = haarKleur;
        this.isActive = status;
    }

    public String getNaam() {
        return naam;
    }

    public String isHeeftBaard() {
        return heeftBaard;
    }

    public String getOogKleur() {
        return oogKleur;
    }

    public String isHeeftBril() {
        return heeftBril;
    }

    public String isHeeftSnor() {
        return heeftSnor;
    }

    public String getTypeGeslacht() {
        return typeGeslacht;
    }

    public String isKaal() {
        return isKaal;
    }

    public String isHeeftHoofddeksel() {
        return heeftHoofddeksel;
    }

    public String getHaarKleur() {
        return haarKleur;
    }

    public String isActive() {
        return isActive;
    }

    public void setInActive(boolean status) {
        if(status) { isActive = "NEE"; return;}
        isActive = "JA";
    }

    @Override
    public String toString() {
        return naam + ';' + heeftBaard + ';' + oogKleur + ';' + heeftBril + ';' + heeftSnor + ';' + typeGeslacht + ';' + isKaal + ';' + heeftHoofddeksel + ';' + haarKleur + ';' + isActive;
    }
}
