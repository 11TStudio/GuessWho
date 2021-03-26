package wieIsHet.model;


import java.io.*;
import java.util.*;

public class Personages {
    List<Personage> personages;
    private final InputStream inputStream;

    public Personages() {
        // We zeggen op voorhand hoeveel plaatsen we minstens nodig hebben
        personages = new LinkedList<>();
        this.inputStream = this.getClass().getResourceAsStream("/game_assets/personages.txt");
        this.readPersonages();
        this.writePersonages();
    }




    private void readPersonages() {
        // Hier aanvullen...
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = reader.readLine();
            Personage personage;
            while(line != null) {
                String[] stukken = line.split(";");
                // String naam,
                // boolean heeftBaard,
                // enum oogKleur,
                // boolean heeftBril,
                // boolean heeftSnor,
                // enum typeGeslacht,
                // boolean isKaal,
                // boolean heeftHoofddeksel,
                // enum haarKleur
                // boolean isActive
                personage = new Personage(stukken[0], Boolean.parseBoolean(stukken[1]), Personage.kleurOog.valueOf(stukken[2]), Boolean.parseBoolean(stukken[3]), Boolean.parseBoolean(stukken[4]), Personage.geslachtType.valueOf(stukken[5]), Boolean.parseBoolean(stukken[6]), Boolean.parseBoolean(stukken[7]), Personage.kleurHaar.valueOf(stukken[8]), Boolean.parseBoolean(stukken[9]));
                personages.add(personage);
                line = reader.readLine(); // lees den volgende
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writePersonages() {
        // Hier aanvullen...
        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("testPersonages.txt"))) {
            for (Personage person : personages) {
                bw.write(person.toString());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Personage getPersonageByIndex(int index) {
        return personages.get(index);
    }


    public Personages getOnlyActivePersonages() {
        Personages activePersonages = null;
        personages.forEach(personage -> {
            if(personage.isActive()){
                activePersonages.getPersonages().add(personage);
            }
        });
        return activePersonages;
    }

    public List<Personage> getPersonages() {
        return personages;
    }

    public int getSize() {
        return personages.size();
    }

    public int getAantalOvergeblevenActivePersonages() {
        int counter;
        counter= (int) personages.stream().filter(Personage::isActive).count();
        return counter;
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
