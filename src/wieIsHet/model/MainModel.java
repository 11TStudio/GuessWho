package wieIsHet.model;

import wieIsHet.Log;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;


/**
 * De klasse MainModel is de belangrijkste modelklasse die de
 * spelintelligentie bevat.
 * <p>
 * Alle gekozen personages, alle beschikbare personages, spelers naam,
 * score en de huidige turn en de soort spel (PvP or PvC) wordt hier opgeslagen.
 * <p>
 * Hier wordt ook beslist wanneer het spel gedaan is en of er gewonnen werd.
 * <p>
 * Deze spel is momenteel v1.0.0 en alle methoden voor v2.0.0 zijn bedoelt voor de release in de vakantie op
 * mijn github account: <a href="https://github.com/11TStudio">LeventHAN's GitHub account</a>. Met andere woorden alles dat
 * begint met <code>@since 2.0</code> is bedoelt als extra.
 *
 * @author LeventHAN
 * @version 1.0
 */
public class MainModel {
    private Personage gekozenPersoonSpeler1 = null;
    private Personage gekozenPersoonSpeler2 = null;
    private Personages allPersonagesSpeler1 = new Personages();
    private Personages allPersonagesSpeler2 = new Personages();
    private Vragen alleVragenSpeler1 = new Vragen();
    private Vragen alleVragenSpeler2 = new Vragen();
    private Speler speler1 = new Speler();
    private Speler speler2 = new Speler();
    private boolean foundItSpeler1;
    private boolean foundItSpeler2;
    private boolean isPVP = false;
    private boolean turnSpeler1 = true;


    private boolean wrongGokSpeler1 = false;
    private boolean wrongGokSpeler2 = false;

    private Settings settings;


    public MainModel() {
        settings = new Settings();
        restart();
    }

    /**
     * Herstart het spel. De settings blijven behouden. Een nieuwe opgave wordt gegenereerd.
     * Alle attributen worden naar de default waarden terug gezet.
     */
    public void restart() {
        foundItSpeler1 = false;
        gekozenPersoonSpeler1 = null;
        gekozenPersoonSpeler2 = null;
        allPersonagesSpeler1 = new Personages();
        allPersonagesSpeler2 = new Personages();
        alleVragenSpeler1 = new Vragen();
        alleVragenSpeler2 = new Vragen();
        speler1 = new Speler();
        speler2 = new Speler();
        wrongGokSpeler1 = false;
        wrongGokSpeler2 = false;
        turnSpeler1 = true;
        isPVP = false;
    }

    /**
     * Getter voor de game type.
     * Deze zal gebruikt worden in de WieIsHet v2.
     *
     * @return isPvP true als de spel tegen een andere speler gespeeld wordt
     * @author LeventHAN
     * @since 2.0
     */
    public boolean isPVP() {
        return isPVP;
    }

    /**
     * Setter voor de game type. Als true dan is de gametype Speler vs Speler
     * anders is het speltype computer vs speler.
     *
     * @param PVP Een boolean true/false dat de spel type declareert
     * @author LeventHAN
     * @since 2.0
     */
    public void setPVP(boolean PVP) {
        isPVP = PVP;
    }

    /**
     * Getter voor de Personages (extends Object).
     * Deze wordt gebruikt voor speler 1
     *
     * @return allPersonagesSpeler1 een object van new Personages()
     * @author LeventHAN
     */
    public Personages getAllPersonagesSpeler1() {
        return allPersonagesSpeler1;
    }

    /**
     * Getter voor de Vragen (extends Object).
     * Deze wordt gebruikt voor speler 1
     *
     * @return alleVragenSpeler1 een object van new Vragen()
     * @author LeventHAN
     */
    public Vragen getAlleVragenSpeler1() {
        return alleVragenSpeler1;
    }

    /**
     * Getter voor de Vragen (extends Object).
     * Deze wordt gebruikt voor speler 2
     *
     * @return alleVragenSpeler2 een Vragen object
     * @author LeventHAN
     */
    public Vragen getAlleVragenSpeler2() {
        return alleVragenSpeler2;
    }

    /**
     * Getter voor de Personages (extends Object).
     * Deze wordt gebruikt voor speler 2
     *
     * @return allPersonagesSpeler2 een Vragen object
     * @author LeventHAN
     */
    public Personages getAllPersonagesSpeler2() {
        return allPersonagesSpeler2;
    }

    /**
     * Setter voor de gekozen Personage (extends Object).
     * Deze wordt gebruikt voor speler 1 en vervolgens moet speler 2 (of de computer) deze personage proberen te raden.
     *
     * @param personage Een Personage object dat speler 1 kiest.
     * @author LeventHAN
     */
    public void setGekozenPersoonSpeler1(Personage personage) {
        this.gekozenPersoonSpeler1 = personage;
    }

    /**
     * Setter voor de gekozen personage, Personage (extends Object).
     * Deze wordt gebruikt voor speler 2 (of de computer) en vervolgens moet speler 1 deze personage proberen te raden.
     *
     * @param personage Een Personage object dat speler 1 kiest.
     * @author LeventHAN
     */
    public void setGekozenPersoonSpeler2(Personage personage) {
        this.gekozenPersoonSpeler2 = personage;
    }

    /**
     * Getter voor de gekozen personage, Persoange (extends Object) van speler 1.
     * Deze wordt gebruikt om de personage van speler 1 te krijgen.
     *
     * @return gekozenPersoonSpeler1 Een Personage Object dat speler 1 gekozen heeft
     * @author LeventHAN
     */
    public Personage getGekozenPersoonSpeler1() {
        return gekozenPersoonSpeler1;
    }

    /**
     * Getter voor de gekozen personage, Persoange (extends Object) van speler 2.
     * Deze wordt gebruikt om de personage van speler 2 te krijgen.
     *
     * @return gekozenPersoonSpeler2 Een Personage Object dat speler 2 gekozen heeft
     * @author LeventHAN
     */
    public Personage getGekozenPersoonSpeler2() {
        return gekozenPersoonSpeler2;
    }

    /**
     * Setter voor speler 1 zijn naam, Speler object.
     * Deze wordt gebruikt voor speler 1.
     *
     * @param spelerNaam De naam van speler 1
     * @author LeventHAN
     * @since 2.0
     */
    public void setSpeler1(String spelerNaam) {
        speler1.setNaam(spelerNaam);
    }

    /**
     * Setter voor speler 2, Speler object (extends Object).
     * Deze wordt gebruikt voor speler 1.
     *
     * @param spelerNaam De naam van de speler 2
     * @author LeventHAN
     * @since 2.0
     */
    public void setSpeler2(String spelerNaam) {
        speler2.setNaam(spelerNaam);
    }

    /**
     * Setter voor speler 1, Speler object.
     * Deze wordt gebruikt voor speler 1.
     *
     * @param score De score van speler 1
     * @author LeventHAN
     * @since 2.0
     */
    public void setScoreSpeler1(int score) {
        speler1.setScore(score);
    }

    /**
     * Setter voor speler 2, Speler object (extends Object).
     * Deze wordt gebruikt voor speler 1.
     *
     * @param score De score van speler 2
     * @author LeventHAN
     * @since 2.0
     */
    public void setScoreSpeler2(int score) {
        speler2.setScore(score);
    }

    /**
     * Getter voor de turn waarde.
     * Deze wordt gebruikt voor te bepalen wanneer de tweede speler moet en of vs
     *
     * @return turnSpeler1 boolean dat heeft aan of het aan speler 1 is of vs
     * @author LeventHAN
     * @since 2.0
     */
    public boolean isTurnSpeler1() {
        return turnSpeler1;
    }

    /**
     * Setter voor de turn waarde
     * Deze wordt gebruikt voor te setten dat het aan speler 1 is of false als het aan speler 2 is
     *
     * @param turnSpeler1 Een boolean
     * @author LeventHAN
     * @since 2.0
     */
    public void setTurnSpeler1(boolean turnSpeler1) {
        this.turnSpeler1 = turnSpeler1;
    }


    /**
     * Getter voor de settings object (extends Object)
     *
     * @return settings een object settings
     * @author LeventHAN
     */
    public Settings getSettings() {
        return settings;
    }


    /**
     * Bewaar het spel naar bestand om later verder te kunnen spelen
     *
     * @throws WieIsHetException als het bewaren mislukt (IO probleem)
     * @author LeventHAN
     * @since 2.0
     */
    public void saveGame() throws WieIsHetException {
        WieIsHetSaver saver = new WieIsHetSaver(this);
        try {
            saver.save();
        } catch (IOException e) {
            Log.error(e.getMessage());
            throw new WieIsHetException(e);
        }
    }

    /**
     * Laad het spel van een bestand na een save.
     *
     * @throws WieIsHetException als het bestand niet gevonden wordt.
     * @author LeventHAN
     * @since 2.0
     */
    public void loadGame() throws WieIsHetException {
        WieIsHetSaver saver = new WieIsHetSaver(this);
        try {
            saver.load();
        } catch (IOException e) {
            Log.error(e.getMessage());
            throw new WieIsHetException(e);
        }
    }

    /**
     * Als de personage gevonden is of het aantal personages te verwijderen leeg is.
     *
     * @return foutItSpeler check voor of speler 1 het goed gegokt heeft of
     * wrongGokSpeler1 check voor of speler 1 verkeerd gegokt heeft of
     * getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages()==0 Check voor active personages over gelijk aan 0
     * @author LeventHAN
     */
    public boolean gameFinished() {
        return foundItSpeler1 || getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages() == 0 || wrongGokSpeler1;
    }

    /**
     * Als het aantal personages te verwijderen leeg is en de personage niet gevonden
     *
     * @return !foutItSpeler check voor of speler 1 het goed verkeerd gegokt heeft en
     * getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages()==0 Check voor active personages over gelijk aan 0 of
     * of
     * !foutItSpeler check voor of speler 1 het goed verkeerd gegokt heeft en
     * wrongGokSpeler1 check voor of speler 1 verkeerd gegokt heeft
     * @author LeventHAN
     */
    public boolean playerLost() {
        return (!foundItSpeler1 && getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages() == 0) || (!foundItSpeler1 && wrongGokSpeler1);
    }

    /**
     * Check om te zien of de computer goed gegokt heeft.
     *
     * @return foundItSpeler2 als speler 2 het goed heeft gegokt
     * @author LeventHAN
     */
    public boolean playerLostComputerGok() {
        return foundItSpeler2;
    }

    /**
     * Checkt naar de vraag dat speler 1 vraagt en stuurt onmiddelijk de antwoord voor dat vraag
     * aan de hand van speler 2 zijn personage.
     *
     * @param vraag de vraag dat gecheckt moet worden
     * @return boolean antwoord aan de vraag true voor 'ja' en false voor 'nee'
     * @author LeventHAN
     */
    public boolean checkVraagSpeler1(Vraag vraag) {
        switch (vraag.getVraag()) {
            case "Is het een vrouw?":
                return getGekozenPersoonSpeler2().getTypeGeslacht().equals(Personage.geslachtType.VROUW);
            case "Draagt de persoon een bril?":
                return getGekozenPersoonSpeler2().isHeeftBril();
            case "Heeft hij een snor?":
                return getGekozenPersoonSpeler2().isHeeftSnor();
            case "Heeft je persoon iets op zijn hoofd?":
                return getGekozenPersoonSpeler2().isHeeftHoofddeksel();
            case "Is je persoon kaal?":
                return getGekozenPersoonSpeler2().isKaal();
            case "Heeft je persoon blond haar?":
                return getGekozenPersoonSpeler2().getHaarKleur().equals(Personage.kleurHaar.BLOND);
            case "Heeft je persoon zwart haar?":
                return getGekozenPersoonSpeler2().getHaarKleur().equals(Personage.kleurHaar.ZWART);
            case "Heeft je persoon bruin haar?":
                return getGekozenPersoonSpeler2().getHaarKleur().equals(Personage.kleurHaar.BRUIN);
            case "Heeft hij een baard?":
                return getGekozenPersoonSpeler2().isHeeftBaard();
            case "Heeft je persoon blauwe ogen?":
                return getGekozenPersoonSpeler2().getOogKleur().equals(Personage.kleurOog.BLAUW);
            case "Heeft je persoon bruine ogen?":
                return getGekozenPersoonSpeler2().getOogKleur().equals(Personage.kleurOog.BRUIN);
            case "Heeft je persoon grijze ogen?":
                return getGekozenPersoonSpeler2().getOogKleur().equals(Personage.kleurOog.GRIJS);
        }
        return false;
    }

    /**
     * Zal onmiddelijk de personages dat niet in aanmerking komen op inactive zetten in de lijst van speler 2.
     * Gebruikt voor de computer logica.
     * <p>
     * In v2.0 zal er een algoritme geschreven worden dat het computer meer laat functioneren als een echte mens zou doen.
     * Met andere woorden een AI dat aanleert van zijn vorige fouten of moves. (No promise, ik zal het doen als een hobby)
     *
     * @param vraag de vraag dat moet gecheckt worden
     * @return boolean antwoord aan de vraag true voor 'ja' en false voor 'nee'
     * @author LeventHAN
     */
    public boolean checkVraagSpeler2(Vraag vraag) {
        switch (vraag.getVraag()) {
            case "Is het een vrouw?":
                if (getGekozenPersoonSpeler1().getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getTypeGeslacht().equals(Personage.geslachtType.VROUW);
            case "Draagt de persoon een bril?":
                if (getGekozenPersoonSpeler1().isHeeftBril()) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.isHeeftBril()) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.isHeeftBril()) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftBril();
            case "Heeft hij een snor?":
                if (getGekozenPersoonSpeler1().isHeeftSnor()) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.isHeeftSnor()) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.isHeeftSnor()) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftSnor();
            case "Heeft je persoon iets op zijn hoofd?":
                if (getGekozenPersoonSpeler1().isHeeftHoofddeksel()) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.isHeeftHoofddeksel()) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.isHeeftHoofddeksel()) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftHoofddeksel();
            case "Is je persoon kaal?":
                if (getGekozenPersoonSpeler1().isKaal()) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.isKaal()) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.isKaal()) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isKaal();
            case "Heeft je persoon blond haar?":
                if (getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BLOND);
            case "Heeft je persoon zwart haar?":
                if (getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.ZWART);
            case "Heeft je persoon bruin haar?":
                if (getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BRUIN);
            case "Heeft hij een baard?":
                if (getGekozenPersoonSpeler1().isHeeftBaard()) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.isHeeftBaard()) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.isHeeftBaard()) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftBaard();
            case "Heeft je persoon blauwe ogen?":
                if (getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BLAUW);
            case "Heeft je persoon bruine ogen?":
                if (getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BRUIN);
            case "Heeft je persoon grijze ogen?":
                if (getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (!personage.getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if (!personage.isActive()) return;
                        if (personage.getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.GRIJS);
        }
        return false;
    }

    /**
     * Setter voor foundItSpeler1
     * Deze wordt gebruikt voor te setten of speler 1 jusit gegokt heeft
     *
     * @param foundIt boolean waarde dat aangeeft of de gok goed is (true) voor speler 1
     * @author LeventHAN
     */
    public void setFoundItSpeler1(boolean foundIt) {
        this.foundItSpeler1 = foundIt;
    }

    /**
     * Setter voor wrongGokSpeler1
     * Deze wordt gebruikt voor te setten of speler 1 jusit gegokt heeft
     *
     * @param wrongGok boolean waarde dat aangeeft of de gok slecht is (true) voor speler 1
     * @author LeventHAN
     */
    public void setWrongGokSpeler1(boolean wrongGok) {
        this.wrongGokSpeler1 = wrongGok;
    }

    /**
     * Setter voor foundItSpeler2
     * Deze wordt gebruikt voor te setten of speler 2 jusit gegokt heeft
     *
     * @param foundIt boolean waarde dat aangeeft of de gok goed is (true) voor speler 2
     * @author LeventHAN
     */
    public void setFoundItSpeler2(boolean foundIt) {
        this.foundItSpeler2 = foundIt;
    }

    /**
     * Setter voor wrongGokSpeler2
     * Deze wordt gebruikt voor te setten of speler 2 jusit gegokt heeft
     *
     * @param wrongGok boolean waarde dat aangeeft of de gok slecht is (true) voor speler 2
     * @author LeventHAN
     */
    public void setWrongGokSpeler2(boolean wrongGok) {
        this.wrongGokSpeler2 = wrongGok;
    }

    /**
     * Getter voor een random vraag, een object Vraag (extends Object) voor speler 2 aan de hand van de vragen van speler 2.
     * Een methode om random, via Random een random vraag te bepalen.
     * Bound is een integer van 0 tot en met de overgebleven vragen size (exclusive)
     * <p>
     * Example; random.nextInt(4) zal een waarde kunnen krijgen van 0 (inclusive) tot en met 4(exclusive),
     * dus 0, 1, 2, 3
     *
     * @return Vraag een vraag dat random bepaald is aan de hand van overgebleven vragen van speler 2
     * @author LeventHAN
     * @see Vraag
     * @see Random
     */
    public Vraag getRandomVraagComputer() {
        Random random = new Random();
        return getAlleVragenSpeler2().getVragen().get(random.nextInt(getAlleVragenSpeler2().getOvergeblevenVragen()));
    }

    /**
     * Modified since v1.0
     * Deze methode wordt geroepen enkel wanneer de computer maar 2 of minder personages over heeft.
     * Vorige versie is verandert met deze. Sinds deze veel minder reken werkt vraagt en heel
     * veel simpelder is en ook een kans heeft aan de slechte speler om toch te kunnen winnen.
     * Deze versie is dommer tegen over de eerste versie dat hard coded was.
     * (modificatie datum: 26/03/2021)
     * <p>
     * In v2.0 zal er een algoritme geschreven worden dat het computer meer laat functioneren als een echte mens zou doen.
     * Met andere woorden een AI dat aanleert van zijn vorige fouten of moves. (No promise, ik zal het doen als een hobby)
     *
     * @return Vraag een vraag dat random bepaald is aan de hand van overgebleven vragen van speler 2
     * @author LeventHAN
     */
    public String getRandomPersonageComputer() {
        AtomicReference<String> pers = new AtomicReference<>("");
        if (getAllPersonagesSpeler2().getAantalOvergeblevenActivePersonages() == 1) {
            getAllPersonagesSpeler2().getPersonages().forEach(persoon -> {
                if (persoon.isActive()) {
                    pers.set(persoon.getNaam());
                }
            });
        }
        ;
        return pers.get();
    }

    /**
     * Modified since v1.0
     * Deze versie is dommer tegen over de eerste versie dat hard coded was met percentages en
     * het altijd goed gokte en dus hard maakte om slechte speler te laten winnen.
     * (modificatie datum: 26/03/2021)
     * <p>
     * Getter om te zien of het gunstig is om te gokken voor de computer.
     * Zeer simpele methode dat checkt of de overgebleven personages minder of gelijk aan 2 is.
     * En checkt of de vragen lengte kleiner is dan 4 of gelijk aan.
     * <p>
     * In v2.0 zal er een algoritme geschreven worden dat het computer meer laat functioneren als een echte mens zou doen.
     * Met andere woorden een AI dat aanleert van zijn vorige fouten of moves. (No promise, ik zal het doen als een hobby)
     *
     * @return boolean dat aangeeft of het gunstig is om te gokken
     * @author LeventHAN
     */
    public boolean gunstigOmTeGokken() {

        if (getAllPersonagesSpeler2().getAantalOvergeblevenActivePersonages() <= 2 || getAlleVragenSpeler2().getVragen().size() <= 4) {
            return true;
        }
        return false;
    }

}