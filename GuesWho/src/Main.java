import wieIsHet.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Voer je naam in: ");
        String naam = keyboard.nextLine();
        Personage p = new Personage();
        p.getAllePersonages();
        System.out.print("Welk personage kies je?(Nummer van het personage): ");
        String personage = keyboard.nextLine();
        Spel wieIsHet = new Spel();
        wieIsHet.startSpel(naam, personage);
    }
}
