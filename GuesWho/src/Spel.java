import wieIsHet.*;

import java.sql.SQLOutput;
import java.util.*;

public class Spel {
    public static void main(String[] args) {

        boolean loading = true;

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
        spelRooster[2][3] = new Personage("Mathias", true, Personage.kleurOog.GRIJS, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);


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
                String baard = "Heeft geen baard.";
                String bril = "Heeft geen bril.";
                String hoofddeksel = "Heeft geen hoofddeksel.";
                String snor = "Heeft geen snor.";
                String kaal = "Kaal.";
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
        boolean checkNaam = true;
        System.out.print("Kies een personage via naam: ");
        gekozenPersonage = keyboard.nextLine();
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

        // Random een personage kiezen voro computer
        Random random = new Random();
        int rij = random.nextInt(3);
        int kolom = random.nextInt(4);
        gekozenCompPersonageObj = spelRooster[rij][kolom];
        // System.out.println(gekozenCompPersonage);

        while (spelActief) {
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




            System.out.println("===================================================================");
            System.out.println(gevraagdeVragenSpeler);
            System.out.println("===================================================================");
            aantalAskedQuestion++;
            System.out.println("[DEBUG] - >");
            System.out.println("===================================================================");
            System.out.println("===================================================================");
            System.out.println(gekozenPersonageObj);
            System.out.println("===================================================================");
            System.out.println("===================================================================");
            System.out.println("< - [DEBUG]");


            System.out.println("[DEBUG] - >");
            System.out.println("===================================================================");
            System.out.println("===================================================================");
            System.out.println(gekozenCompPersonageObj);
            System.out.println("===================================================================");
            System.out.println("===================================================================");
            System.out.println("< - [DEBUG]");



            // We checken wat de computer zal zeggen.
            switch (vragenSpeler.get(gekozenVraagSpeler)) {
                case "Is het een vrouw?":
                    if (gekozenCompPersonageObj.getTypeGeslacht().equals(Personage.geslachtType.VROUW)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                case "Draagt de persoon een bril?":
                    if (gekozenCompPersonageObj.isHeeftBril()) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                case "Heeft je persoon blauwe ogen?":
                    if (gekozenCompPersonageObj.getOogKleur().equals(Personage.kleurOog.BLAUW)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;

                case "Heeft je persoon bruine ogen?":
                    if (gekozenCompPersonageObj.getOogKleur().equals(Personage.kleurOog.BRUIN)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;

                case "Heeft je persoon grijze ogen?":
                    if (gekozenCompPersonageObj.getOogKleur().equals(Personage.kleurOog.GRIJS)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;


                case "Heeft hij een baard?":
                    if (gekozenCompPersonageObj.isHeeftBaard()) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;


                case "Heeft hij een snor?":
                    if (gekozenCompPersonageObj.isHeeftSnor()) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                case "Heeft je persoon blond haar?":
                    if (gekozenCompPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BLOND)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                case "Heeft je persoon zwart haar?":
                    if (gekozenCompPersonageObj.getHaarKleur().equals(Personage.kleurHaar.ZWART)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                case "Heeft je persoon bruin haar?":
                    if (gekozenCompPersonageObj.getHaarKleur().equals(Personage.kleurHaar.BRUIN)) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                case "Heeft je persoon iets op zijn hoofd?":
                    if (gekozenCompPersonageObj.isHeeftHoofddeksel()) {
                        System.out.println("Computer: JA");
                    } else {
                        System.out.println("Computer: NEEN");
                    }
                    break;
                default:
                    System.out.println("not working");
            };


            System.out.println("Wil je iemand verwijderen uit je lijst?");
            String antwoord = keyboard.next();
            if(antwoord.equalsIgnoreCase("ja")||antwoord.equalsIgnoreCase("j")||antwoord.equalsIgnoreCase("y")||antwoord.equalsIgnoreCase("yes")) {
                System.out.println("This will be fun");
            } else if(antwoord.equalsIgnoreCase("n")||antwoord.equalsIgnoreCase("no")||antwoord.equalsIgnoreCase("nee")) {
                System.out.println("Maybe next time");
            } else {
                System.out.println("Invalid character");
            }





            // We zetten de gevraagde vraag in een arrayList
            gevraagdeVragenSpeler.add(vragenSpeler.get(gekozenVraagSpeler));
            // We verwijderen de gevraagde vraag uit de lijst van de Speler
            vragenSpeler.remove(vragenSpeler.get(gekozenVraagSpeler));
            // System.out.println(gevraagdeVragenSpeler[aantalAskedQuestion]);
            // aantalAskedQuestion++;


            /*
            gevraagdeVragenSpeler[aantalAskedQuestion] = vragenSpeler[gekozenNummer];
            aantalAskedQuestion++;

            break;
            */
    /*
            int gekozenVraag = keyboard.nextInt();

            for (Personage[] personages : spelRooster) {
                for (Personage pers : personages) {

                }
            }
            */
            // TODO: Print de personages via .voorstellingPersonages()


        /*
        // TODO: Speler kiest een PERSONAGE


        // wij declareren paar namen om bij de computer namen te gebruiken.
        String[] computerSpelersNamen = {"Jan", "Peter", "Sam", "Simon", "Paul", "Thomas", "Anniek", "Marie"};
        // We maken een random cijfer
        Random rand = new Random();
        int randomgetal = rand.nextInt(3);
        Speler spelerMens = new Speler(spelerNaam, 0);
        Speler spelerComputer = new Speler(computerSpelersNamen[randomgetal], 0);
        System.out.println(spelerMens);
        System.out.println(spelerComputer);
*/

        /*
        DEBUGGEN OF SORTEER WERKT!
        HET WERKT!
        System.out.println("SORTEER OP NIETS: ");
        System.out.println(p);

        System.out.println("SORTEER OP GESLACHT + NAAM: ");
        p.sorteerGeslachtNaam();
        */


/*
        private String vragen[] = {
                "Is het een vrouw?",
                "Draagt de persoon een bril?",
                "Heeft je persoon blauwe ogen?",
                "Heeft je persoon bruine ogen?",
                "Heeft je persoon grijze ogen?",
                "Heeft hij een baard?",
                "Heeft hij een snor?",
                "Is je persoon kaal?",
                "Heeft je persoon blond haar?",
                "Heeft je persoon zwart haar?",
                "Heeft je persoon bruin haar?",
                "Heeft je persoon iets op zijn hoofd?"
        };


        Scanner keyboard = new Scanner(System.in);
        System.out.print("Voer je naam in: ");
        String spelerNaam = keyboard.nextLine();





        /*
        System.out.print("Welk personage kies je?(Nummer van het personage): ");
        String personage = keyboard.nextLine();
        Spel wieIsHet = new Spel();
        wieIsHet.startSpel(naam, personage);

         */


        }
    }

    // Method voor keuze vraagen voor speler.
    private static boolean validatieVraagNummer(int choice, int sizeSpelVragen) {
        if (choice < 0 || choice >= sizeSpelVragen) {
            System.out.println("Deze vraag bestaat precies niet. ");
            return false;
        }
        return true;
    }
}
