package wieIsHet.model;


/**
 * Deze klasse maakt een object aan voor de personage.
 * Extends Object
 *
 * @author LeventHAN
 * @version 1.0
 * @see Object
 */
public class Personage {

    public enum geslachtType {
        MAN, VROUW
    }

    public enum kleurOog {
        BLAUW, BRUIN, GRIJS
    }

    public enum kleurHaar {
        BLOND, ZWART, BRUIN, GEEN
    }

    private String naam;
    private boolean heeftBaard;
    private kleurOog oogKleur;
    private boolean heeftBril;
    private boolean heeftSnor;
    private geslachtType typeGeslacht;
    private boolean isKaal;
    private boolean heeftHoofddeksel;
    private kleurHaar haarKleur;
    private boolean isActive;


    /**
     * Constructor voor de object Personage met bijhorende kenmerken;
     *
     * @param naam             String
     * @param heeftBaard       boolean
     * @param oogKleur         enum
     * @param heeftBril        boolean
     * @param heeftSnor        boolean
     * @param typeGeslacht     enum
     * @param isKaal           boolean
     * @param heeftHoofddeksel boolean
     * @param haarKleur        enum
     * @param isActive         boolean
     * @author LeventHAN
     * @author LeventHAN
     */
    public Personage(String naam, boolean heeftBaard, kleurOog oogKleur, boolean heeftBril, boolean heeftSnor, geslachtType typeGeslacht, boolean isKaal, boolean heeftHoofddeksel, kleurHaar haarKleur, boolean isActive) {
        this.naam = naam;
        this.heeftBaard = heeftBaard;
        this.oogKleur = oogKleur;
        this.heeftBril = heeftBril;
        this.heeftSnor = heeftSnor;
        this.typeGeslacht = typeGeslacht;
        this.isKaal = isKaal;
        this.heeftHoofddeksel = heeftHoofddeksel;
        this.haarKleur = haarKleur;
        this.isActive = isActive;
    }


    /**
     * Getter voor de naam van de personage
     *
     * @return de naam van de personage
     * @author LeventHAN
     * @author LeventHAN
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Getter voor de kenmerk heeftBaard
     *
     * @return boolean waarde true voor als de personage een baard heeft
     * @author LeventHAN
     */
    public boolean isHeeftBaard() {
        return heeftBaard;
    }

    /**
     * Getter voor de kenmerk geslachtType
     *
     * @return kleurOog enum van de personage
     * @author LeventHAN
     */
    public kleurOog getOogKleur() {
        return oogKleur;
    }

    /**
     * Getter voor de kenmerk heeftBril
     *
     * @return boolean waarde true voor als de personage een bril heeft
     * @author LeventHAN
     */
    public boolean isHeeftBril() {
        return heeftBril;
    }

    /**
     * Getter voor de kenmerk heeftSnor
     *
     * @return boolean waarde true voor als de personage een snor heeft
     * @author LeventHAN
     */
    public boolean isHeeftSnor() {
        return heeftSnor;
    }

    /**
     * Getter voor de kenmerk geslachtType
     *
     * @return geslachtType enum van de personage
     * @author LeventHAN
     */
    public geslachtType getTypeGeslacht() {
        return typeGeslacht;
    }

    /**
     * Getter voor de kenmerk isKaal
     *
     * @return boolean waarde true voor als de personage kaal is
     * @author LeventHAN
     */
    public boolean isKaal() {
        return isKaal;
    }

    /**
     * Getter voor de kenmerk heefthoofddeksel
     *
     * @return boolean waarde true voor als de personage iets heeft op zijn kop en vs
     * @author LeventHAN
     */
    public boolean isHeeftHoofddeksel() {
        return heeftHoofddeksel;
    }

    /**
     * Getter voor de kenmerk haarKleur
     *
     * @return kleurHaar enum van de personage
     * @author LeventHAN
     */
    public kleurHaar getHaarKleur() {
        return haarKleur;
    }

    /**
     * Getter voor de status van een personage
     *
     * @return boolean waarde true voor is active en vs
     * @author LeventHAN
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Setter voor de status isActive
     *
     * @param active als de personage in gebruik is true
     * @author LeventHAN
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Een toString methode om te helpen debuggen en werd effectief gebruikt bij de log systeem.
     *
     * @return een string met alle kenmerken van een personage voor de log class
     * @author LeventHAN
     */
    @Override
    public String toString() {
        return naam + ';' + heeftBaard + ';' + oogKleur + ';' + heeftBril + ';' + heeftSnor + ';' + typeGeslacht + ';' + isKaal + ';' + heeftHoofddeksel + ';' + haarKleur + ';' + isActive;
    }
}
