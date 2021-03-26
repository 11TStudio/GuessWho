package wieIsHet.model;


// Onze classe Persoange
// Comparable implementeert altijd de klasse waar het implements.

import java.util.List;

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
        BLOND, ZWART, BRUIN, GEEN
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
    private boolean isActive;

    // Constructor for the Personage


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


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public boolean isHeeftBaard() {
        return heeftBaard;
    }

    public void setHeeftBaard(boolean heeftBaard) {
        this.heeftBaard = heeftBaard;
    }

    public kleurOog getOogKleur() {
        return oogKleur;
    }

    public void setOogKleur(kleurOog oogKleur) {
        this.oogKleur = oogKleur;
    }

    public boolean isHeeftBril() {
        return heeftBril;
    }

    public void setHeeftBril(boolean heeftBril) {
        this.heeftBril = heeftBril;
    }

    public boolean isHeeftSnor() {
        return heeftSnor;
    }

    public void setHeeftSnor(boolean heeftSnor) {
        this.heeftSnor = heeftSnor;
    }

    public geslachtType getTypeGeslacht() {
        return typeGeslacht;
    }

    public void setTypeGeslacht(geslachtType typeGeslacht) {
        this.typeGeslacht = typeGeslacht;
    }

    public boolean isKaal() {
        return isKaal;
    }

    public void setKaal(boolean kaal) {
        isKaal = kaal;
    }

    public boolean isHeeftHoofddeksel() {
        return heeftHoofddeksel;
    }

    public void setHeeftHoofddeksel(boolean heeftHoofddeksel) {
        this.heeftHoofddeksel = heeftHoofddeksel;
    }

    public kleurHaar getHaarKleur() {
        return haarKleur;
    }

    public void setHaarKleur(kleurHaar haarKleur) {
        this.haarKleur = haarKleur;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    @Override
    public String toString() {
        return naam + ';' + heeftBaard + ';' + oogKleur + ';' + heeftBril + ';' + heeftSnor + ';' + typeGeslacht + ';' + isKaal + ';' + heeftHoofddeksel + ';' + haarKleur + ';' + isActive;
    }
}
