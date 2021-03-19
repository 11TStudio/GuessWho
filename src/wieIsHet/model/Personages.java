package wieIsHet.model;

import java.io.*;
import java.util.*;
import java.util.stream.DoubleStream;

public class Personages {
    List<Personage> personages;
    private final InputStream inputStream;

    public Personages() {
        // We zeggen op voorhand hoeveel plaatsen we minstens nodig hebben
        personages = new LinkedList<>();
        this.inputStream = this.getClass().getResourceAsStream("/game_assets/personages.txt");
        this.readPersonages();
    }


    public List<Personage> getPersonages() {
        return personages;
    }

    public Personage getPersonage(int i) {
        return personages.get(i);
    }

    public int getSize() {
        return personages.size();
    }


    private void readPersonages() {
        // Hier aanvullen...
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = reader.readLine();
            Personage personage;
            while(line != null) {
                String[] stukken = line.split(";");
                // String naam,
                // String heeftBaard,
                // String oogKleur,
                // String heeftBril,
                // String heeftSnor,
                // String typeGeslacht,
                // String isKaal,
                // String heeftHoofddeksel,
                // String haarKleur
                personage = new Personage(stukken[0], stukken[1], stukken[2], stukken[3], stukken[4], stukken[5], stukken[6], stukken[7], stukken[8]);
                personages.add(personage);
                line = reader.readLine(); // lees den volgende
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
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

    }

    @Override
    public String toString() {
        return "Personages{" +
                "personages=" + personages +
                '}';
    }
}
