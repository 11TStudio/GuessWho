package wieIsHet.model;


// Onze classe Persoange
// Comparable implementeert altijd de klasse waar het implements.
public class Personage  {


//
//    // ENUMS maken we en gebruikgen we in de classe zelf
//    // en maken de mogelijkheden beperkt zo zoals we zelf willen
//    // ENUM voor geslacht enkel te kiezen uit MAN of VROUW
//    public enum geslachtType {
//        MAN, VROUW
//    }
//
//    // ENUM voor oog kleur enkel te kiezen uit onderstaande waarden
//    public enum kleurOog {
//        BLAUW, BRUIN, GRIJS
//    }
//
//    // ENUM voor haar kleur enkel te kiezen uit onderstaande waarden
//    public enum kleurHaar {
//        BLOND, ZWART, BRUIN
//    }

    // Define the attirbutes
    private String naam;
    private String heeftBaard;
    private String oogKleur;
    private String heeftBril;
    private String heeftSnor;
    private String typeGeslacht;
    private String isKaal;
    private String heeftHoofddeksel;
    private String haarKleur;

    // Constructor for the Personage
    public Personage(String naam, String heeftBaard, String oogKleur, String heeftBril, String heeftSnor, String typeGeslacht, String isKaal, String heeftHoofddeksel, String haarKleur) {
        this.naam = naam;
        this.heeftBaard = heeftBaard;
        this.oogKleur = oogKleur;
        this.heeftBril = heeftBril;
        this.heeftSnor = heeftSnor;
        this.typeGeslacht = typeGeslacht;
        this.isKaal = isKaal;
        this.heeftHoofddeksel = heeftHoofddeksel;
        this.haarKleur = haarKleur;
    }

    // GET METHODS voor alle attributen
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



    // TO STING METHODE voor Personage
    @Override
    public String toString() {
        return "Personage{" +
                "naam='" + naam + '\'' +
                ", heeftBaard=" + heeftBaard +
                ", oogKleur=" + oogKleur +
                ", heeftBril=" + heeftBril +
                ", heeftSnor=" + heeftSnor +
                ", typeGeslacht=" + typeGeslacht +
                ", isKaal=" + isKaal +
                ", heeftHoofddeksel=" + heeftHoofddeksel +
                ", haarKleur=" + haarKleur +
                '}';
    }
}
