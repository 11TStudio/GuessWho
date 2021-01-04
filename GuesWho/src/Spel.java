import wieIsHet.*;
import java.util.*;

public class Spel {
    public static void main(String[] args) {

        Personage[][] spelRooster = new Personage[2][3];
        spelRooster[0][0] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[0][1] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[0][2] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[0][3] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][0] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][1] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][2] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][3] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[2][0] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[2][1] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[2][2] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[2][3] = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);


        // test om te zien of alles werkt lol :D
        // p.voorstellingPersonages();

        System.out.printf("%27s \n", "Welkom aan onze spel!");
        System.out.println("----~~~~~ Wie is het?  ~~~~----");

        // Declaratie van input en daarna naam vragen van de speler.
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Voer je naam in: ");
        String spelerNaam = keyboard.nextLine();


        // TODO: Print de personages via .voorstellingPersonages()
        pSpeler.voorstellingPersonages();


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
