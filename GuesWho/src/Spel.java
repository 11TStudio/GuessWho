import wieIsHet.*;
import java.util.*;

public class Spel {
    public static void main(String[] args) {
        String gekozenPersonage = "";
        String gekozenCompPersonage = "";
        String[] gevraagdeVragenSpeler = {};
        String[] vragenSpeler = {"Is het een vrouw?",
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
                "Heeft je persoon iets op zijn hoofd?"};






        String[] vragenComputer = {"asd", "asd"};


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
        for(Personage[] personages : spelRooster){
            for(Personage pers : personages){
                String baard = "Heeft geen baard.";
                String bril = "Heeft geen bril.";
                String hoofddeksel = "Heeft geen hoofddeksel.";
                String snor = "Heeft geen snor.";
                String kaal = "Kaal.";
                if(pers.isHeeftBaard()) {
                    baard = "Heeft wél een baard.";
                }
                if (pers.isHeeftBril()) {
                    bril = "Heeft wél een bril.";
                }
                if(pers.isHeeftHoofddeksel()) {
                    hoofddeksel = "Heeft wél een hoofddeksel.";
                }
                if(pers.isHeeftSnor()) {
                    snor = "Heeft wél een snor.";
                }
                if(pers.isKaal()) {
                    kaal = "Is wél kaal.";
                }
                System.out.printf(" Personage: %s - %s \n  Eigenschappen: \n   Haarkleur: %s - Oogkleur: %s \n   %s %s %s \n   %s %s \n /---------------------------------------------------/ \n", pers.getNaam(), pers.getTypeGeslacht(), pers.getHaarKleur(), pers.getOogKleur(), baard, bril,hoofddeksel, snor, kaal);
            }
        }

        // Kies een personage en valideer dat deze personage effectief in onze Rooster zit.
        boolean checkNaam = true;
        while (checkNaam) {
            System.out.print("Kies een personage via naam: ");
            gekozenPersonage = keyboard.nextLine();

            for (Personage[] personages : spelRooster) {
                for (Personage pers : personages) {
                    if (pers.getNaam().equals(gekozenPersonage)) {
                        System.out.println("De naam is correct");
                        checkNaam = false;
                    }
                }
            }
            if(checkNaam) {
                System.out.println("De naam bestaat niet, probeer het nog eens a.u.b.");
            }
        }

        // Random een personage kiezen voro computer
        Random random = new Random();
        int rij = random.nextInt(3);
        int kolom = random.nextInt(4);
        gekozenCompPersonage = spelRooster[rij][kolom].getNaam();
        // System.out.println(gekozenCompPersonage);

        boolean personageNietGevonden = true;
        int aantalAskedQuestion = 0;
        while (personageNietGevonden) {
            System.out.println("Kies een vraag uit de vragenlijst door op de nummer te typen: ");
            for (int i = 0; i < vragenSpeler.length; i++) {
                System.out.println(i + " " + vragenSpeler[i]);
            }
            int gekozenNummer = keyboard.nextInt();

            System.out.println(vragenSpeler[gekozenNummer]);
            gevraagdeVragenSpeler[aantalAskedQuestion] = vragenSpeler[gekozenNummer];
            System.out.println(gevraagdeVragenSpeler[aantalAskedQuestion]);
            aantalAskedQuestion++;
            break;


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
        }
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
