import wieIsHet.*;

import java.sql.SQLOutput;
import java.util.*;

public class Spel {
    public static void main(String[] args) {
        String baard;
        String bril;
        String hoofddeksel;
        String snor;
        String kaal;

        boolean rondeComputer = false;

        String fixGeslacht = "";


        int lengteBeschikbaarPersonen = 0;

        boolean checkNaam = true;

        ArrayList<String> deletedPersonagesSpeler = new ArrayList<>();
        ArrayList<String> deletedPersonagesSpelerComputer = new ArrayList<>();

        boolean laatstePersoon = false;

        Personage gekozenPersonageObj = null;
        Personage gekozenCompPersonageObj = null;

        boolean spelActief = true;

        int aantalAskedQuestionSpeler = 0;
        int aantalAskedQuestionComputer = 0;

        int gekozenVraagSpeler = 0;
        int gekozenVraagComputer = 0;

        String gekozenPersonage = "";
        String gekozenPersonageComp = "";

        ArrayList<String> gevraagdeVragenSpeler = new ArrayList<>();
        ArrayList<String> gevraagdeVragenComputer = new ArrayList<>();


        ArrayList<String> vragenSpeler = new ArrayList<>();
        vragenSpeler.add("Is het een vrouw?");
        vragenSpeler.add("Draagt de persoon een bril?");
        vragenSpeler.add("Heeft je persoon blauwe ogen?");
        vragenSpeler.add("Heeft je persoon bruine ogen?");
        vragenSpeler.add("Heeft je persoon grijze ogen?");
        vragenSpeler.add("Heeft hij een baard?");
        vragenSpeler.add("Heeft hij een snor?");
        vragenSpeler.add("Is je persoon kaal?");
        vragenSpeler.add("Heeft je persoon blond haar?");
        vragenSpeler.add("Heeft je persoon zwart haar?");
        vragenSpeler.add("Heeft je persoon bruin haar?");
        vragenSpeler.add("Heeft je persoon iets op zijn hoofd?");

        ArrayList<String> vragenComputer = new ArrayList<>();
        vragenComputer.add("Is het een vrouw?");
        vragenComputer.add("Draagt de persoon een bril?");
        vragenComputer.add("Heeft je persoon blauwe ogen?");
        vragenComputer.add("Heeft je persoon bruine ogen?");
        vragenComputer.add("Heeft je persoon grijze ogen?");
        vragenComputer.add("Heeft hij een baard?");
        vragenComputer.add("Heeft hij een snor?");
        vragenComputer.add("Is je persoon kaal?");
        vragenComputer.add("Heeft je persoon blond haar?");
        vragenComputer.add("Heeft je persoon zwart haar?");
        vragenComputer.add("Heeft je persoon bruin haar?");
        vragenComputer.add("Heeft je persoon iets op zijn hoofd?");

        // Er moeten 20 personages zijn. Momenteel voor de console hebben we maar 12/ (Anders zijn er veel personages en op console versie is dat echt niet mooi.)
        // Maar de code is uitbereidbaar zonder moeite.
        Personage[][] spelRooster = new Personage[3][4];
        spelRooster[0][0] = new Personage("Levent", true, Personage.kleurOog.GRIJS, true, true, Personage.geslachtType.MAN, false, true, Personage.kleurHaar.ZWART);
        spelRooster[0][1] = new Personage("Liam", true, Personage.kleurOog.BLAUW, true, false, Personage.geslachtType.MAN, true, false, Personage.kleurHaar.BRUIN);
        spelRooster[0][2] = new Personage("Jan", false, Personage.kleurOog.BLAUW, false, false, Personage.geslachtType.MAN, true, true, Personage.kleurHaar.BLOND);
        spelRooster[0][3] = new Personage("Peter", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][0] = new Personage("Lise", false, Personage.kleurOog.BLAUW, true, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][1] = new Personage("Kathleen", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.BRUIN);
        spelRooster[1][2] = new Personage("Sara", false, Personage.kleurOog.GRIJS, false, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.BLOND);
        spelRooster[1][3] = new Personage("Julie", false, Personage.kleurOog.BLAUW, true, false, Personage.geslachtType.VROUW, false, true, Personage.kleurHaar.ZWART);
        spelRooster[2][0] = new Personage("Michealle", false, Personage.kleurOog.BRUIN, false, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.BLOND);
        spelRooster[2][1] = new Personage("Joshua", true, Personage.kleurOog.GRIJS, false, true, Personage.geslachtType.MAN, false, true, Personage.kleurHaar.ZWART);
        spelRooster[2][2] = new Personage("Roy", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.MAN, true, true, Personage.kleurHaar.BLOND);
        spelRooster[2][3] = new Personage("Mathias", true, Personage.kleurOog.GRIJS, true, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);

        System.out.printf("%27s \n", "Welkom aan onze spel!");
        System.out.println("----~~~~~ Wie is het?  ~~~~----");
        // Declaratie van input en daarna naam vragen van de speler.
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Voer je naam in: ");
        String spelerNaam = keyboard.nextLine();
        Speler nieuweSpeler = new Speler(spelerNaam,0);
        System.out.println("/---------------------------------------------------/");
        // Print elk personage met bijhorende eigenschappen.
        for (Personage[] personages : spelRooster) {
            for (Personage pers : personages) {
                baard = "Heeft geen baard.";
                bril = "Heeft geen bril.";
                hoofddeksel = "Heeft geen hoofddeksel.";
                snor = "Heeft geen snor.";
                kaal = "Is niet kaal.";
                if (pers.isHeeftBaard()) {
                    baard = "Heeft wél een baard.";
                }
                if (pers.isHeeftBril()) {
                    bril = "Heeft wél een bril.";
                }
                if (pers.isHeeftHoofddeksel()) {
                    hoofddeksel = "Heeft wél een hoofddeksel.";
                }
                if (pers.isHeeftSnor()) {
                    snor = "Heeft wél een snor.";
                }
                if (pers.isKaal()) {
                    kaal = "Is wél kaal.";
                }
                System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
            }
        }


        // Kies een personage en valideer dat deze personage effectief in onze Rooster zit.

        System.out.print("Kies een personage via naam: ");
        gekozenPersonage = keyboard.nextLine();

        // de aantal personages in de spelrooster.
        for (Personage[] personages : spelRooster) {
            lengteBeschikbaarPersonen += personages.length;
        }

        while (checkNaam) {
            for (Personage[] personages : spelRooster) {

                for (Personage pers : personages) {
                    if (pers.getNaam().toLowerCase().equals(gekozenPersonage.toLowerCase())) {
                        gekozenPersonageObj = pers;
                        System.out.println("De naam is correct");
                        checkNaam = false;
                    }
                }
            }
            if (checkNaam) {
                System.out.print("De naam bestaat niet, kies een personage via naam: ");
                gekozenPersonage = keyboard.nextLine();
            }
        }


        /* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
         * ~~~~~~~~~~~ COMPUTER ~~~~~~~~~~~ //
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ //
         * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
        // Computer kiest een random personage.
        Random random = new Random();
        int rij = random.nextInt(3);
        int kolom = random.nextInt(4);
        gekozenCompPersonageObj = spelRooster[rij][kolom];
        gekozenPersonageComp = gekozenCompPersonageObj.getNaam();
        // System.out.println(gekozenPersonageComp);

        while (spelActief) {
            for (Personage[] personages : spelRooster) {
                for (Personage pers : personages) {
                    if (deletedPersonagesSpelerComputer.size() >= (lengteBeschikbaarPersonen - 1)) {
                        for (int i = 0; i < deletedPersonagesSpelerComputer.size(); i++) {
                            if (!deletedPersonagesSpelerComputer.get(i).equals(pers.getNaam())) {
                                laatstePersoon = true;
                                break;
                            }
                        }
                        if (laatstePersoon) {

                            // Hier moet men eerst de laatste personage vinden.
                            // daarna deze gebruiken voor te vergelijken.
                            boolean controleVerlies = false;
                            for (Personage[] personages1 : spelRooster) {

                                for (Personage pers1 : personages) {
                                    for (String element : deletedPersonagesSpelerComputer) {
                                        if(gekozenPersonageObj.getNaam() != element){
                                            controleVerlies = true;
                                            break;
                                        }
                                    }
                                }
                            }

                            if (controleVerlies) {
                                System.out.println("U heeft verloren, de computer heeft het goed gegokt!");
                            } else {
                                System.out.println("U heeft gewonnen, de computer heeft het fout gegokt!");
                                nieuweSpeler.setScore((nieuweSpeler.getScore()+1));
                            }
                            // Hier wilt em niet leaven
                            spelActief = false;
                            System.out.println("Spel is beindigt!");
                            // dus een fail-safe
                            if (!spelActief) {
                                System.exit(0);
                            }
                        }
                    }
                }
            }

            if (!rondeComputer) {
                for (Personage[] personages : spelRooster) {
                    for (Personage pers : personages) {
                        if (deletedPersonagesSpeler.size() == (lengteBeschikbaarPersonen - 1)) {
                            System.out.println("U hebt maar 1 persoon over, u bent geforceerd om te gokken! De enige overgebleven persoon in bezit is: ");
                            for (int i = 0; i < deletedPersonagesSpeler.size(); i++) {
                                if (!deletedPersonagesSpeler.get(i).equals(pers.getNaam())) {
                                    System.out.println(pers.getNaam());
                                    laatstePersoon = true;
                                    break;
                                }
                            }
                            if (laatstePersoon) {
                                System.out.println("Laten we zien of het de correcte persoon is....");
                                System.out.println("De persoon dat computer gekozen heeft is: " + gekozenCompPersonageObj.getNaam());
                                System.out.println("De persoon dat u over had is: " + personages[personages.length - 1].getNaam());
                                if (gekozenCompPersonageObj.getNaam() == personages[personages.length - 1].getNaam()) {
                                    System.out.println("U heeft gewonnen!");
                                    nieuweSpeler.setScore((nieuweSpeler.getScore()+1));
                                } else {
                                    System.out.println("U heeft verloren");
                                }
                                // Hier wilt em niet leaven
                                spelActief = false;
                                System.out.println("Spel is beindigt!");
                                // dus een fail-safe
                                if (!spelActief) {
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }

            if (rondeComputer) {
                gekozenVraagComputer = random.nextInt(vragenComputer.size());
                // We zetten de gevraagde vraag in een arrayList
                gevraagdeVragenComputer.add(vragenComputer.get(gekozenVraagComputer));
                boolean antwoordCheck;

                if (fixGeslacht == "VROUW") {
                    switch (vragenComputer.get(gekozenVraagComputer)) {
                        case "Heeft hij een baard?":
                        case "Heeft hij een snor?":
                            gevraagdeVragenComputer.add(vragenComputer.get(gekozenVraagComputer));
                            gekozenVraagComputer = random.nextInt(vragenComputer.size());
                            break;
                        default:
                            break;
                    }
                }

                switch (vragenComputer.get(gekozenVraagComputer)) {
                    case "Is het een vrouw?":
                        System.out.println("Computer vraagt: Is het een vrouw? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                                    fixGeslacht = "VROUW";
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    fixGeslacht = "MAN";
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }
                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if (pers.getTypeGeslacht() != gekozenPersonageObj.getTypeGeslacht()) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Draagt de persoon een bril?":
                        System.out.println("Computer vraagt: Draagt de persoon een bril? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.isHeeftBril()) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.isHeeftBril()) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }
                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if (pers.isHeeftBril() != gekozenPersonageObj.isHeeftBril()) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Heeft je persoon blauwe ogen?":
                        System.out.println("Computer vraagt: Heeft je persoon balauwe ogen? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if ((gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.BLAUW)) && (pers.getOogKleur() != gekozenPersonageObj.getOogKleur())) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }
                        break;
                    case "Heeft je persoon bruine ogen?":
                        System.out.println("Computer vraagt: Heeft je persoon bruine ogen? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }


                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if ((gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.BRUIN)) && (pers.getOogKleur() != gekozenPersonageObj.getOogKleur())) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Heeft je persoon grijze ogen?":
                        System.out.println("Computer vraagt: Heeft je persoon grijze ogen? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }


                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if ((gekozenPersonageObj.getOogKleur().equals(Personage.kleurOog.GRIJS)) && (pers.getOogKleur() != gekozenPersonageObj.getOogKleur())) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Heeft hij een baard?":
                        System.out.println("Computer vraagt: Heeft hij een baard? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.isHeeftBaard()) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.isHeeftBaard()) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if (pers.isHeeftBaard() != gekozenPersonageObj.isHeeftBaard()) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Heeft hij een snor?":
                        System.out.println("Computer vraagt: Heeft hij een snor? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.isHeeftSnor()) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.isHeeftSnor()) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if (pers.isHeeftSnor() != gekozenPersonageObj.isHeeftSnor()) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Is je persoon kaal?":
                        System.out.println("Computer vraagt: Is je persoon kaal? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.isKaal()) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.isKaal()) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if (pers.isKaal() != gekozenPersonageObj.isKaal()) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }


                        break;
                    case "Heeft je persoon blond haar?":

                        System.out.println("Computer vraagt: Heeft je persoon blond haar? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }
                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if ((gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BLOND)) && (pers.getHaarKleur() != gekozenPersonageObj.getHaarKleur())) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }

                        break;
                    case "Heeft je persoon zwart haar?":

                        System.out.println("Computer vraagt: Heeft je persoon zwart haar? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if ((gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.ZWART)) && (pers.getHaarKleur() != gekozenPersonageObj.getHaarKleur())) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }


                        break;
                    case "Heeft je persoon bruin haar?":

                        System.out.println("Computer vraagt: Heeft je persoon bruin haar? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if ((gekozenPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) && (pers.getHaarKleur() != gekozenPersonageObj.getHaarKleur())) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }


                        break;
                    case "Heeft je persoon iets op zijn hoofd?":

                        System.out.println("Computer vraagt: Heeft je persoon iets op zijn hoofd? (JA - NEE)");
                        antwoordCheck = true;
                        while (antwoordCheck) {
                            String antwoord = keyboard.next();
                            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                if (gekozenPersonageObj.isHeeftHoofddeksel()) {
                                    antwoordCheck = false;
                                } else {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                }
                            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                if (gekozenPersonageObj.isHeeftHoofddeksel()) {
                                    System.out.print("Probeer nog eens lijkt dat het verkeerd is!: ");
                                } else {
                                    antwoordCheck = false;
                                }
                            } else {
                                System.out.print("Input is niet correct probeer het nogmaals: ");
                            }
                        }

                        for (Personage[] personages : spelRooster) {
                            for (Personage pers : personages) {
                                if (pers.isHeeftHoofddeksel() != gekozenPersonageObj.isHeeftHoofddeksel()) {
                                    isAlreadyDeleted(deletedPersonagesSpelerComputer, pers);
                                }
                            }
                        }


                        break;
                    default:
                        System.out.println("Er is een fout. Spel wordt beindigdt!");
                        System.exit(0);
                }
                aantalAskedQuestionComputer++;
                vragenComputer.remove(vragenComputer.get(gekozenVraagComputer));

            } else {

                // Print alle vragen dat beschikbaar zijn.
                for (int i = 0; i < vragenSpeler.size(); i++) {
                    System.out.println(i + " " + vragenSpeler.get(i));
                }

                // Controleer of de input een nummer is en of de nummer niet kleiner of groter dan
                // de grootte is van de vragen beschikbaar.
                do {
                    System.out.print("Kies een vraag uit de vragenlijst door op de nummer te typen: ");
                    while (!keyboard.hasNextInt()) {
                        System.out.print("Dit is geen nummer! Vul een nummer in aub! ");
                        keyboard.next();
                    }
                    gekozenVraagSpeler = keyboard.nextInt();
                } while (!validatieVraagNummer(gekozenVraagSpeler, vragenSpeler.size()));

                // We zetten de gevraagde vraag in een arrayList
                gevraagdeVragenSpeler.add(vragenSpeler.get(gekozenVraagSpeler));

                aantalAskedQuestionSpeler++;

                // We checken wat de computer zal zeggen.
                switch (vragenSpeler.get(gekozenVraagSpeler)) {
                    case "Is het een vrouw?":
                        if (gekozenCompPersonageObj.getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                            System.out.println("Computer: JA, mijn personage is een VROUW.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage is een MAN.");
                        }
                        break;
                    case "Draagt de persoon een bril?":
                        if (gekozenCompPersonageObj.isHeeftBril()) {
                            System.out.println("Computer: JA, mijn personage heeft een bril.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen bril.");
                        }
                        break;
                    case "Heeft je persoon blauwe ogen?":
                        if (gekozenCompPersonageObj.getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                            System.out.println("Computer: JA, mijn personage heeft blauwe ogen.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen blauwe ogen.");
                        }
                        break;
                    case "Heeft je persoon bruine ogen?":
                        if (gekozenCompPersonageObj.getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                            System.out.println("Computer: JA, mijn personage heeft bruine ogen.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen bruine ogen.");
                        }
                        break;
                    case "Heeft je persoon grijze ogen?":
                        if (gekozenCompPersonageObj.getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                            System.out.println("Computer: JA, mijn personage heeft grijze ogen.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen grijze ogen.");
                        }
                        break;
                    case "Heeft hij een baard?":
                        if (gekozenCompPersonageObj.isHeeftBaard()) {
                            System.out.println("Computer: JA, mijn personage heeft een baard.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen baard.");
                        }
                        break;
                    case "Heeft hij een snor?":
                        if (gekozenCompPersonageObj.isHeeftSnor()) {
                            System.out.println("Computer: JA, mijn personage heeft een snor.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen snor.");
                        }
                        break;
                    case "Is je persoon kaal?":
                        if (gekozenCompPersonageObj.isKaal()) {
                            System.out.println("Computer: JA, mijn personage is kaal.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage is niet kaal.");
                        }
                        break;
                    case "Heeft je persoon blond haar?":
                        if (gekozenCompPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                            System.out.println("Computer: JA, mijn personage heeft blond haar.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen blond haar");
                        }
                        break;
                    case "Heeft je persoon zwart haar?":
                        if (gekozenCompPersonageObj.getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                            System.out.println("Computer: JA, mijn personage heeft zwart haar.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen zwart haar.");
                        }
                        break;
                    case "Heeft je persoon bruin haar?":
                        if (gekozenCompPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                            System.out.println("Computer: JA, mijn personage heeft bruin haar.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft geen bruin haar.");
                        }
                        break;
                    case "Heeft je persoon iets op zijn hoofd?":
                        if (gekozenCompPersonageObj.isHeeftHoofddeksel()) {
                            System.out.println("Computer: JA, mijn personage heeft iets op zijn hoofd.");
                        } else {
                            System.out.println("Computer: NEEN, mijn personage heeft niets op zijn hoofd");
                        }
                        break;
                    default:
                        System.out.println("Er is een fout. Spel wordt beindigdt!");
                        System.exit(0);
                }

                boolean verwijderPersSpeler = true;
                boolean invalidInput = true;
                System.out.println("Wil je iemand verwijderen uit je lijst? (JA - NEE)");
                while (invalidInput) {
                    String antwoord = keyboard.next();
                    if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                        System.out.println("Personen worden opgeladen...");
                        invalidInput = false;
                    } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                        verwijderPersSpeler = false;
                        invalidInput = false;
                    } else {
                        System.out.print("Input is niet correct probeer het nogmaals: ");
                    }
                }
                // De persoon wilt iemand verwijderen, laten we de personages printen zonder de personages dat al verwijdered waren.
                while (verwijderPersSpeler) {
                    System.out.println("/---------------------------------------------------/");
                    // Print elk personage met bijhorende eigenschappen.
                    for (Personage[] personages : spelRooster) {
                        for (Personage pers : personages) {
                            baard = "Heeft geen baard.";
                            bril = "Heeft geen bril.";
                            hoofddeksel = "Heeft geen hoofddeksel.";
                            snor = "Heeft geen snor.";
                            kaal = "Is niet kaal.";
                            if (pers.isHeeftBaard()) {
                                baard = "Heeft wél een baard.";
                            }
                            if (pers.isHeeftBril()) {
                                bril = "Heeft wél een bril.";
                            }
                            if (pers.isHeeftHoofddeksel()) {
                                hoofddeksel = "Heeft wél een hoofddeksel.";
                            }
                            if (pers.isHeeftSnor()) {
                                snor = "Heeft wél een snor.";
                            }
                            if (pers.isKaal()) {
                                kaal = "Is wél kaal.";
                            }
                            if (deletedPersonagesSpeler.size() == 0) {
                                System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                                verwijderPersSpeler = isVerwijderPersSpeler(deletedPersonagesSpeler, keyboard, verwijderPersSpeler, pers);
                            } else {
                                boolean persoonIsReedsVerwijderd = false;
                                for (int i = 0; i < deletedPersonagesSpeler.size(); i++) {
                                    if (pers.getNaam().equals(deletedPersonagesSpeler.get(i))) {
                                        persoonIsReedsVerwijderd = true;
                                    }
                                }
                                if (!persoonIsReedsVerwijderd) {
                                    System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                                    verwijderPersSpeler = isVerwijderPersSpeler(deletedPersonagesSpeler, keyboard, verwijderPersSpeler, pers);
                                }
                            }
                        }
                    }
                }
                vragenSpeler.remove(vragenSpeler.get(gekozenVraagSpeler));

                System.out.println("Wil je een gok maken? (JA - NEE)");
                invalidInput = true;
                boolean skip = false;
                while (invalidInput) {
                    String antwoord = keyboard.next();
                    if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {

                        invalidInput = false;
                    } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                        skip = true;
                        invalidInput = false;
                    } else {
                        System.out.print("Input is niet correct probeer het nogmaals: ");
                    }
                }
                int gekozenPersonageSpeler = 0;
                if (!skip) {
                    boolean kiesPersoon = false;
                    System.out.println("U mag nu iemand kiezen, type JA als u dat persoon wilt gokken. ");
                    for (Personage[] personages : spelRooster) {
                        for (Personage pers : personages) {
                            baard = "Heeft geen baard.";
                            bril = "Heeft geen bril.";
                            hoofddeksel = "Heeft geen hoofddeksel.";
                            snor = "Heeft geen snor.";
                            kaal = "Is niet kaal.";
                            if (pers.isHeeftBaard()) {
                                baard = "Heeft wél een baard.";
                            }
                            if (pers.isHeeftBril()) {
                                bril = "Heeft wél een bril.";
                            }
                            if (pers.isHeeftHoofddeksel()) {
                                hoofddeksel = "Heeft wél een hoofddeksel.";
                            }
                            if (pers.isHeeftSnor()) {
                                snor = "Heeft wél een snor.";
                            }
                            if (pers.isKaal()) {
                                kaal = "Is wél kaal.";
                            }
                            if (deletedPersonagesSpeler.size() == 0) {
                                System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                                boolean verkeerdeInput = true;
                                while (verkeerdeInput) {
                                    String antwoord = keyboard.next();
                                    if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                        verkeerdeInput = false;
                                        kiesPersoon = true;
                                    } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                        verkeerdeInput = false;
                                    } else {
                                        System.out.print("Input is niet correct probeer het nogmaals: ");
                                    }
                                }
                            } else {
                                boolean persoonIsReedsVerwijderd = false;
                                for (int i = 0; i < deletedPersonagesSpeler.size(); i++) {
                                    if (pers.getNaam().equals(deletedPersonagesSpeler.get(i))) {
                                        persoonIsReedsVerwijderd = true;
                                    }
                                }
                                if (!persoonIsReedsVerwijderd) {
                                    System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                                    System.out.println("Gok je deze persoon? (JA - NEE)");
                                    boolean verkeerdeInput = true;
                                    while (verkeerdeInput) {
                                        String antwoord = keyboard.next();
                                        if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                                            verkeerdeInput = false;
                                            kiesPersoon = true;
                                        } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                                            verkeerdeInput = false;
                                        } else {
                                            System.out.print("Input is niet correct probeer het nogmaals: ");
                                        }
                                    }
                                }
                            }
                            if (kiesPersoon) {
                                String gokSpeler = pers.getNaam();
                                if (gekozenPersonageComp.equals(gokSpeler)) {
                                    System.out.println("SUPER GOED GERADEN! U HEEFT GEWONNEN!");
                                    nieuweSpeler.setScore((nieuweSpeler.getScore()+1));
                                } else {
                                    System.out.println("Helaas verkeerd geraden! U heeft verloren!");
                                }
                                System.exit(0);
                            }
                        }
                    }

                }
            }


            if (rondeComputer) {
                rondeComputer = false;
            } else {
                rondeComputer = true;
            }
        }
    }

    private static void isAlreadyDeleted(ArrayList<String> deletedPersonagesSpelerComputer, Personage pers) {
        boolean alreadyDeleted = false;
        for (int i = 0; i < deletedPersonagesSpelerComputer.size(); i++) {
            if (pers.getNaam().equals(deletedPersonagesSpelerComputer.get(i))) {
                alreadyDeleted = true;
            }
        }
        if (!alreadyDeleted) {
            deletedPersonagesSpelerComputer.add(pers.getNaam());
        }
    }

    private static boolean isVerwijderPersSpeler(ArrayList<String> deletedPersonagesSpeler, Scanner keyboard, boolean verwijderPersSpeler, Personage pers) {
        System.out.println("Wil je deze persoon verwijderen? (JA - NEE)");
        boolean verkeerdeInput = true;
        boolean verwijderPers = false;
        while (verkeerdeInput) {
            String antwoord = keyboard.next();
            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                System.out.println("Personen worden opgeladen...");
                verkeerdeInput = false;
                verwijderPers = true;
            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                verwijderPersSpeler = false;
                verkeerdeInput = false;
            } else {
                System.out.print("Input is niet correct probeer het nogmaals: ");
            }
        }
        if (verwijderPers) {
            deletedPersonagesSpeler.add(pers.getNaam());
            verwijderPersSpeler = false;
        }
        return verwijderPersSpeler;
    }

    // Method voor keuze vraagen voor speler.
    private static boolean validatieVraagNummer(int choice, int sizeSpelVragen) {
        if (choice < 0 || choice >= sizeSpelVragen) {
            System.out.println("Deze vraag bestaat precies niet.");
            return false;
        }
        return true;
    }
}
