import wieIsHet.*;

import java.sql.SQLOutput;
import java.util.*;

public class Spel {
    public static void main(String[] args) {
        String baard = "Heeft geen baard.";
        String bril = "Heeft geen bril.";
        String hoofddeksel = "Heeft geen hoofddeksel.";
        String snor = "Heeft geen snor.";
        String kaal = "Kaal.";

        int lengteBeschikbaarPersonen = 0;

        boolean checkNaam = true;

        ArrayList<String> deletedPersonages = new ArrayList<String>();

        boolean laatstePersoon = false;

        Personage gekozenPersonageObj = null;

        Personage gekozenCompPersonageObj = null;

        boolean spelActief = true;

        int aantalAskedQuestion = 0;

        int gekozenVraagSpeler = 0;

        String gekozenPersonage = "";

        ArrayList<String> gevraagdeVragenSpeler = new ArrayList<String>();


        ArrayList<String> vragenSpeler = new ArrayList<String>();
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

        ArrayList<String> vragenComputer = vragenSpeler;

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
        spelRooster[2][1] = new Personage("Joshua", true, Personage.kleurOog.GRIJS, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[2][2] = new Personage("Roy", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.MAN, true, true, Personage.kleurHaar.BLOND);
        spelRooster[2][3] = new Personage("Mathias", true, Personage.kleurOog.GRIJS, true, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);

        System.out.printf("%27s \n", "Welkom aan onze spel!");
        System.out.println("----~~~~~ Wie is het?  ~~~~----");
        // Declaratie van input en daarna naam vragen van de speler.
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Voer je naam in: ");
        String spelerNaam = keyboard.nextLine();
        System.out.println("/---------------------------------------------------/");
        // Print elk personage met bijhorende eigenschappen.
        for (Personage[] personages : spelRooster) {
            for (Personage pers : personages) {
                baard = "Heeft geen baard.";
                bril = "Heeft geen bril.";
                hoofddeksel = "Heeft geen hoofddeksel.";
                snor = "Heeft geen snor.";
                kaal = "Kaal.";
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
        while (checkNaam) {
            for (Personage[] personages : spelRooster) {
                lengteBeschikbaarPersonen += personages.length;
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

        // Random een personage kiezen voro computer
        Random random = new Random();
        int rij = random.nextInt(3);
        int kolom = random.nextInt(4);
        gekozenCompPersonageObj = spelRooster[rij][kolom];
        // System.out.println(gekozenCompPersonage);

        while (spelActief) {
            System.out.println("DEBUG --------->");
            System.out.println("Verwijderde personen aantal: "+deletedPersonages.size());
            System.out.println("Lengte Beschikbaar Persoon: "+lengteBeschikbaarPersonen);
            System.out.println("Lengte Beschikbaar Persoon -1: "+(lengteBeschikbaarPersonen-1));
            System.out.println("DEBUG --------->");
            for (Personage[] personages : spelRooster) {
                for (Personage pers : personages) {
                    if (deletedPersonages.size() == (lengteBeschikbaarPersonen - 1)) {
                        System.out.println("De enige overgebleven persoon is: ");
                        for (int i = 0; i < deletedPersonages.size(); i++) {
                            if (!deletedPersonages.get(i).equals(pers.getNaam())) {
                                System.out.println(pers.getNaam());
                                laatstePersoon = true;
                                break;
                            }
                        }
                        if (laatstePersoon) {
                            System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                            System.out.println("Laten we zien of het de correcte persoon is....");

                            System.out.println("De persoon dat computer gekozen heeft is: " + gekozenCompPersonageObj.getNaam());
                            System.out.println("De persoon dat u over had is: " + personages[personages.length - 1].getNaam());

                            spelActief = false;
                            System.exit(0);
                        }
                    }
                }
            }

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

            System.out.println("===================================================================");
            System.out.println(gevraagdeVragenSpeler);
            System.out.println("===================================================================");
            aantalAskedQuestion++;
            System.out.println("===================================================================");
            System.out.println("[DEBUG] - > aantal gevraagde vrage: " + aantalAskedQuestion);
            System.out.println("===================================================================");
            System.out.println(gekozenPersonageObj);
            System.out.println("===================================================================");
            System.out.println("< - [DEBUG]");
            System.out.println("===================================================================");
            System.out.println("[DEBUG] - >");
            System.out.println("===================================================================");
            System.out.println(gekozenCompPersonageObj);
            System.out.println("===================================================================");
            System.out.println("< - [DEBUG]");


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
                    if (gekozenCompPersonageObj.isHeeftSnor()) {
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






            boolean verwijderPers = true;
            boolean invalidInput = true;
            System.out.println("Wil je iemand verwijderen uit je lijst? (JA - NEE)");

            while (invalidInput) {
                String antwoord = keyboard.next();
                if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                    System.out.println("Personen worden opgeladen...");
                    invalidInput = false;
                } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                    verwijderPers = false;
                    invalidInput = false;
                } else {
                    System.out.print("Input is niet correct probeer het nogmaals: ");
                }
            }

            // De persoon wilt iemand verwijderen, laten we de personages printen zonder de personages dat al verwijdered waren.
            while (verwijderPers) {
                System.out.println("/---------------------------------------------------/");
                // Print elk personage met bijhorende eigenschappen.
                for (Personage[] personages : spelRooster) {
                    for (Personage pers : personages) {
                        baard = "Heeft geen baard.";
                        bril = "Heeft geen bril.";
                        hoofddeksel = "Heeft geen hoofddeksel.";
                        snor = "Heeft geen snor.";
                        kaal = "Kaal.";
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
                        if (deletedPersonages.size() == 0) {
                            System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                            verwijderPers = isVerwijderPers(deletedPersonages, keyboard, verwijderPers, pers);
                        } else {
                            boolean persoonIsReedsVerwijderd = false;
                            for (int i = 0; i < deletedPersonages.size(); i++) {
                                if (pers.getNaam().equals(deletedPersonages.get(i))) {
                                    persoonIsReedsVerwijderd = true;
                                }
                            }
                            if (!persoonIsReedsVerwijderd) {
                                System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril, hoofddeksel, snor, kaal);
                                verwijderPers = isVerwijderPers(deletedPersonages, keyboard, verwijderPers, pers);
                            }
                        }
                    }
                }
            }



            vragenSpeler.remove(vragenSpeler.get(gekozenVraagSpeler));


        }
    }

    private static boolean isVerwijderPers(ArrayList<String> deletedPersonages, Scanner keyboard, boolean verwijderPers, Personage pers) {
        System.out.println("Wil je deze persoon verwijderen? (JA - NEE)");
        boolean verkeerdeInput = true;
        boolean verwijderPersoon = false;
        while (verkeerdeInput) {
            String antwoord = keyboard.next();
            if (antwoord.equalsIgnoreCase("ja") || antwoord.equalsIgnoreCase("j") || antwoord.equalsIgnoreCase("y") || antwoord.equalsIgnoreCase("yes")) {
                System.out.println("Personen worden opgeladen...");
                verkeerdeInput = false;
                verwijderPersoon = true;
            } else if (antwoord.equalsIgnoreCase("n") || antwoord.equalsIgnoreCase("no") || antwoord.equalsIgnoreCase("nee") || antwoord.equalsIgnoreCase("neen")) {
                verwijderPers = false;
                verkeerdeInput = false;
            } else {
                System.out.print("Input is niet correct probeer het nogmaals: ");
            }
        }
        if (verwijderPersoon) {
            deletedPersonages.add(pers.getNaam());
            verwijderPers = false;
        }
        return verwijderPers;
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
