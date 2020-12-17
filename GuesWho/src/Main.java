import wieIsHet.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Personage p1 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p2 = new Personage("Liam", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p3 = new Personage("Sandra", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.ZWART);
        Personage p4 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p5 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p6 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p7 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p8 = new Personage("Eva", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.ZWART);
        Personage p9 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p10 = new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p11= new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        Personage p12= new Personage("Levent", false, Personage.kleurOog.BRUIN, false, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);



        Personages p = new Personages();
        p.voegPersonageToe(p1);
        p.voegPersonageToe(p2);
        p.voegPersonageToe(p3);
        p.voegPersonageToe(p4);
        p.voegPersonageToe(p5);
        p.voegPersonageToe(p6);
        p.voegPersonageToe(p7);
        p.voegPersonageToe(p8);
        p.voegPersonageToe(p9);
        p.voegPersonageToe(p10);
        p.voegPersonageToe(p11);
        p.voegPersonageToe(p12);

        // test om te zien of alles werkt lol :D
        p.voorstellingPersonages();


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
