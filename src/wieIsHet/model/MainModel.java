package wieIsHet.model;

import wieIsHet.Log;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;


/**
 * De klasse MainModel is de belangrijkste modelklasse die de
 * spelintelligentie bevat.
 * Alle gekozen personages, alle beschikbare personages, spelers naam,
 * score en de huidige turn en de soort spel (PvP or PvC) wordt hier opgeslagen.
 * Hier wordt ook beslist wanneer het spel gedaan is en of er gewonnen werd.
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
        turnSpeler1 = true;
        isPVP = false;
    }

    /**
     * Getter voor de game type.
     * @returns isPvP (true OR false)
     * @author LeventHAN
     */
    public boolean isPVP() {
        return isPVP;
    }

    /**
     * Setter voor de game type. Als true dan is de gametype Speler vs Speler
     * anders is het speltype computer vs speler.
     * @param PVP Een boolean true/false
     * @author LeventHAN
     */
    public void setPVP(boolean PVP) {
        isPVP = PVP;
    }

    /**
     * Getter voor de Personages (een List<Personage>).
     * Deze wordt gebruikt voor speler 1
     * @return allPersonagesSpeler1
     * @author LeventHAN
     */
    public Personages getAllPersonagesSpeler1() {
        return allPersonagesSpeler1;
    }

    /**
     * Getter voor de Vragen (een List<Vraag>).
     * Deze wordt gebruikt voor speler 1
     * @return alleVragenSpeler1
     * @author LeventHAN
     */
    public Vragen getAlleVragenSpeler1() {
        return alleVragenSpeler1;
    }

    /**
     * Getter voor de Vragen (een List<Vraag>).
     * Deze wordt gebruikt voor speler 2
     * @return alleVragenSpeler2
     * @author LeventHAN
     */
    public Vragen getAlleVragenSpeler2() {
        return alleVragenSpeler2;
    }

    /**
     * Getter voor de Personages (een List<Personage>).
     * Deze wordt gebruikt voor speler 2
     * @return allPersonagesSpeler2
     * @author LeventHAN
     */
    public Personages getAllPersonagesSpeler2() {
        return allPersonagesSpeler2;
    }


    /**
     * Getter voor de aantal personages/karakters (een getSize() methode van List<Personage>).
     * Deze wordt gebruikt voor speler 1
     * @return allPersonagesSpeler1.getSize()
     * @author LeventHAN
     */
    public int getSizePersonages1() {
        return allPersonagesSpeler1.getSize();
    }

    /**
     * Getter voor de aantal personages/karakters (een getSize() methode van List<Personage>).
     * Deze wordt gebruikt voor speler 2
     * @return allPersonagesSpeler2.getSize()
     * @author LeventHAN
     */
    public int getSizePersonages2() {
        return allPersonagesSpeler2.getSize();
    }

    /**
     * Setter voor gekozen Personage.
     * Deze wordt gebruikt voor speler 1 en speler 2 (of de computer)
     * moet deze personage proberen te vinden/gokken.
     * @param personage Een Personage object.
     * @author LeventHAN
     */
    public void setGekozenPersoonSpeler1(Personage personage) {
        this.gekozenPersoonSpeler1 = personage;
    }

    /**
     * Setter voor gekozen Personage.
     * Deze wordt gebruikt voor speler 2 en speler 1
     * moet deze personage proberen te vinden/gokken.
     * De computer gebruikt automatisch deze.
     * @param personage Een Personage object.
     * @author LeventHAN
     */
    public void setGekozenPersoonSpeler2(Personage personage) {
        this.gekozenPersoonSpeler2 = personage;
    }

    /**
     * Getter voor de gekozen personages/karakters (een Personage object).
     * Deze wordt gebruikt voor speler 1
     * @return gekozenPersoonSpeler1 Een Personage Object
     * @author LeventHAN
     */
    public Personage getGekozenPersoonSpeler1() {
        return gekozenPersoonSpeler1;
    }

    /**
     * Getter voor de gekozen personages/karakters (een Personage object).
     * Deze wordt gebruikt voor speler 2
     * @return gekozenPersoonSpeler1 Een Personage Object
     * @author LeventHAN
     */
    public Personage getGekozenPersoonSpeler2() {
        return gekozenPersoonSpeler2;
    }

    /**
     * Setter voor speler 1, Speler object.
     * Deze wordt gebruikt voor speler 1.
     * @param spelerNaam Een String
     * @param score Een Integer
     * @author LeventHAN
     */
    public void setSpeler1(String spelerNaam, int score){
        speler1.setNaam(spelerNaam);
        speler1.setScore(score);
    }

    /**
     * Setter voor speler 2, Speler object.
     * Deze wordt gebruikt voor speler 2.
     * @param spelerNaam Een String
     * @param score Een Integer
     * @author LeventHAN
     */
    public void setSpeler2(String spelerNaam, int score){
        speler2.setNaam(spelerNaam);
        speler2.setScore(score);
    }

    /**
     * Getter voor de turn waarde (om te weten wanneer het aan speler 1 is).
     * Deze wordt gebruikt voor te bepalen wanneer de tweede speler moet en of vs
     * @author LeventHAN
     */
    public boolean isTurnSpeler1() {
        return turnSpeler1;
    }

    /**
     * Setter voor de turn waarde (om te weten wanneer het aan speler 1 is).
     * Deze wordt gebruikt voor te bepalen wanneer de tweede speler moet en of vs
     * @param turnSpeler1 Een boolean
     * @author LeventHAN
     */
    public void setTurnSpeler1(boolean turnSpeler1) {
        this.turnSpeler1 = turnSpeler1;
    }


    public Settings getSettings() {
        return settings;
    }


    /**
     * Bewaar het spel naar een binair bestand om later verder te kunnen spelen
     * @throws WieIsHetException als het bewaren mislukt (IO probleem)
     */
    public void saveGame() throws WieIsHetException {
        WieIsHetSaver saver = new WieIsHetSaver(this);
        try {
            saver.save();
        } catch (IOException e) {
            Log.error(e.getMessage()); // TODO: save to logfile
            throw new WieIsHetException(e);
        }
    }

    /**
     * Laad het spel van een bestand.
     * @throws WieIsHetException als het bestand niet gevonden wordt.
     */
    public void loadGame() throws WieIsHetException {
        WieIsHetSaver saver = new WieIsHetSaver(this);
        try {
            saver.load();
        } catch (IOException e) {
            Log.error(e.getMessage());//you could save to logfile
            throw new WieIsHetException(e);
        }
    }

    /**
     * Als de personage gevonden is of het aantal personages te verwijderen leeg is.
     *
     */
    public boolean gameFinished() {
        return foundItSpeler1 || getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages()==0 || wrongGokSpeler1;
    }

    /**
     * Als het aantal personages te verwijderen leeg is en de personage niet gevonden
     *
     */
    public boolean playerLost(){
        return (!foundItSpeler1 &&getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages()==0)||(!foundItSpeler1 && wrongGokSpeler1);
    }

    /**
     * Computer heeft juist gegokt.
     * @return foundItSpeler2 boolean
     */
    public boolean playerLostComputerGok(){
        return foundItSpeler2;
    }

    /**
     * Getter voor de aantal personages/karakters dat al reeds verwijderd zijn.
     * Deze wordt gebruikt voor speler 1
     * @return allPersonagesSpeler1.getSize()
     * @author LeventHAN
     */
    public int getSizeDeletedPersonagesSpeler1() {
        return allPersonagesSpeler1.getAantalOvergeblevenActivePersonages();
    }

    /**
     * Getter voor de aantal personages/karakters dat al reeds verwijderd zijn.
     * Deze wordt gebruikt voor speler 2 of computer
     * @return allPersonagesSpeler1.getSize()
     * @author LeventHAN
     */
    public int getSizeDeletedPersonagesSpeler2() {
        return allPersonagesSpeler2.getAantalOvergeblevenActivePersonages();
    }

    public boolean checkVraagSpeler1(Vraag vraag){
        switch (vraag.getVraag()){
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

    public boolean checkVraagSpeler2(Vraag vraag){
        switch (vraag.getVraag()){
            case "Is het een vrouw?":
                if(getGekozenPersoonSpeler1().getTypeGeslacht().equals(Personage.geslachtType.VROUW)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getTypeGeslacht().equals(Personage.geslachtType.VROUW)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getTypeGeslacht().equals(Personage.geslachtType.VROUW)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getTypeGeslacht().equals(Personage.geslachtType.VROUW);
            case "Draagt de persoon een bril?":
                if(getGekozenPersoonSpeler1().isHeeftBril()){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.isHeeftBril()){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.isHeeftBril()){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftBril();
            case "Heeft hij een snor?":
                if(getGekozenPersoonSpeler1().isHeeftSnor()){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.isHeeftSnor()){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.isHeeftSnor()){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftSnor();
            case "Heeft je persoon iets op zijn hoofd?":
                if(getGekozenPersoonSpeler1().isHeeftHoofddeksel()){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.isHeeftHoofddeksel()){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.isHeeftHoofddeksel()){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftHoofddeksel();
            case "Is je persoon kaal?":
                if(getGekozenPersoonSpeler1().isKaal()){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.isKaal()){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.isKaal()){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isKaal();
            case "Heeft je persoon blond haar?":
                if(getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BLOND)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getHaarKleur().equals(Personage.kleurHaar.BLOND)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getHaarKleur().equals(Personage.kleurHaar.BLOND)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BLOND);
            case "Heeft je persoon zwart haar?":
                if(getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.ZWART)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getHaarKleur().equals(Personage.kleurHaar.ZWART)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getHaarKleur().equals(Personage.kleurHaar.ZWART)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.ZWART);
            case "Heeft je persoon bruin haar?":
                if(getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BRUIN)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getHaarKleur().equals(Personage.kleurHaar.BRUIN)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getHaarKleur().equals(Personage.kleurHaar.BRUIN)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getHaarKleur().equals(Personage.kleurHaar.BRUIN);
            case "Heeft hij een baard?":
                if(getGekozenPersoonSpeler1().isHeeftBaard()){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.isHeeftBaard()){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.isHeeftBaard()){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().isHeeftBaard();
            case "Heeft je persoon blauwe ogen?":
                if(getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BLAUW)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getOogKleur().equals(Personage.kleurOog.BLAUW)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getOogKleur().equals(Personage.kleurOog.BLAUW)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BLAUW);
            case "Heeft je persoon bruine ogen?":
                if(getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BRUIN)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getOogKleur().equals(Personage.kleurOog.BRUIN)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getOogKleur().equals(Personage.kleurOog.BRUIN)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.BRUIN);
            case "Heeft je persoon grijze ogen?":
                if(getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.GRIJS)){
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(!personage.getOogKleur().equals(Personage.kleurOog.GRIJS)){
                            personage.setActive(false);
                        }
                    });
                } else {
                    getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                        if(!personage.isActive()) return;
                        if(personage.getOogKleur().equals(Personage.kleurOog.GRIJS)){
                            personage.setActive(false);
                        }
                    });
                }
                return getGekozenPersoonSpeler1().getOogKleur().equals(Personage.kleurOog.GRIJS);
        }
        return false;
    }

    public void setFoundItSpeler1(boolean foundIt) {
        this.foundItSpeler1 = foundIt;
    }

    public void setWrongGokSpeler1(boolean wrongGok) {
        this.wrongGokSpeler1 = wrongGok;
    }

    public void setFoundItSpeler2(boolean foundIt) {
        this.foundItSpeler2 = foundIt;
    }

    public void setWrongGokSpeler2(boolean wrongGok) {
        this.wrongGokSpeler2 = wrongGok;
    }

    public Vraag getRandomVraagComputer(){
        Random random = new Random();
        return getAlleVragenSpeler2().getVragen().get(random.nextInt(getAlleVragenSpeler2().getOvergeblevenVragen()));
    }

    public String getRandomPersonageComputer(){
        AtomicReference<String> pers = new AtomicReference<>("");
        if(getAllPersonagesSpeler2().getAantalOvergeblevenActivePersonages() == 1){
            getAllPersonagesSpeler2().getPersonages().forEach(persoon -> {
                if(persoon.isActive()){
                    pers.set(persoon.getNaam());
                }
            });
        };
        return pers.get();
    }

    public boolean gunstigOmTeGokken(){
        System.out.println("================== DEBUG VRAGEN: "+getAlleVragenSpeler2().getSize()+" ==================");
        getAlleVragenSpeler2().getVragen().forEach(vraag -> {
            if(!vraag.isGevraagd()){
                System.out.println(vraag);
            }
        });
        System.out.println("================== DEBUG PERSONAGES: "+getAllPersonagesSpeler2().getAantalOvergeblevenActivePersonages()+" ==================");

        getAllPersonagesSpeler2().getPersonages().forEach(persoon -> {
            if(persoon.isActive()){
                System.out.println(persoon);
            }
        });
        if(getAllPersonagesSpeler2().getAantalOvergeblevenActivePersonages() <= 2 || getAlleVragenSpeler2().getSize() < 3){
            return true;
        }
        return false;
    }

}