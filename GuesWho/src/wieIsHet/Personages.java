package wieIsHet;

import java.util.*;

public class Personages {
    List<Personage> personages;

    public Personages() {
        // We zeggen op voorhand hoeveel plaatsen we minstens nodig hebben
        personages = new ArrayList<>(12);
    }

    // Personage toevoegen aan onze Personages lijst :)
    public void voegPersonageToe(Personage personage) {
        personages.add(personage);
    }

    public void voorstellingPersonages() {
        sorteerGeslachtNaam();
        System.out.println("personages= "+personages+"\n");
    }

    // Sorteerfunctie op String naam.
    public void sorteerGeslachtNaam() {
        // we schrijven onze eigen comperator...
        // onderstaande is zelfde als: Collections.sort(personages, new Comparator<Personage>() {
        // Explici type argument Peronage can be replaced with <>
        // kon gemakkelijk lambda gebruiken maar bon mag niet van docenten.
        personages.sort(new Comparator<Personage>() {
            @Override
            // Twee personages vergelijken/compare met elkaar
            // Dus eerst op geslacht daarna op naam.
            // Als geslacht niet gelijk is dan soorteer je op geslacht anders op naam.
            public int compare(Personage o1, Personage o2) {
                if (o1.getTypeGeslacht().equals(o2.getTypeGeslacht())) {
                    return o1.getNaam().compareTo(o2.getNaam());
                }
                return o1.getTypeGeslacht().compareTo(o2.getTypeGeslacht());
            }
        });
        // enkel uitcommenten om te debuggen !!!
        // System.out.println("personages= "+personages+"\n");
    }

    // ToString methode
    // Sorteren op naam

    @Override
    public String toString() {
        return "Personages{" +
                "personages=" + personages +
                '}';
    }
}
