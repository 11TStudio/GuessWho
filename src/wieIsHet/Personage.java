package wieIsHet;


// Onze classe Persoange
// Comparable implementeert altijd de klasse waar het implements.
public class Personage  {

    // ENUMS maken we en gebruikgen we in de classe zelf
    // en maken de mogelijkheden beperkt zo zoals we zelf willen
    // ENUM voor geslacht enkel te kiezen uit MAN of VROUW
    public enum geslachtType {
        MAN, VROUW
    }

    // ENUM voor oog kleur enkel te kiezen uit onderstaande waarden
    public enum kleurOog {
        BLAUW, BRUIN, GRIJS
    }

    // ENUM voor haar kleur enkel te kiezen uit onderstaande waarden
    public enum kleurHaar {
        BLOND, ZWART, BRUIN
    }

    // Define the attirbutes
    private String naam;
    private boolean heeftBaard;
    private kleurOog oogKleur;
    private boolean heeftBril;
    private boolean heeftSnor;
    private geslachtType typeGeslacht;
    private boolean isKaal;
    private boolean heeftHoofddeksel;
    private kleurHaar haarKleur;

    // Constructor for the Personage
    public Personage(String naam, boolean heeftBaard, kleurOog oogKleur, boolean heeftBril, boolean heeftSnor, geslachtType typeGeslacht, boolean isKaal, boolean heeftHoofddeksel, kleurHaar haarKleur) {
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

    public boolean isHeeftBaard() {
        return heeftBaard;
    }

    public kleurOog getOogKleur() {
        return oogKleur;
    }

    public boolean isHeeftBril() {
        return heeftBril;
    }

    public boolean isHeeftSnor() {
        return heeftSnor;
    }

    public geslachtType getTypeGeslacht() {
        return typeGeslacht;
    }

    public boolean isKaal() {
        return isKaal;
    }

    public boolean isHeeftHoofddeksel() {
        return heeftHoofddeksel;
    }

    public kleurHaar getHaarKleur() {
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
