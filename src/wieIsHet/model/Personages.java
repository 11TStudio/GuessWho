package wieIsHet.model;


import java.io.*;
import java.util.*;

/**
 * De class Personages heeft alle Personage 's thuis.
 * Hij is namelijk een List van Personage 's.
 * Is onze rechterhand in de spel en is de tweede belangrijkste class in onze spel.
 *
 * @version 1.0
 * @author LeventHAN
 */
public class Personages {
    List<Personage> personages;
    private final InputStream inputStream;

    public Personages() {
        personages = new LinkedList<>();
        this.inputStream = this.getClass().getResourceAsStream("/game_assets/personages.txt");
        this.readPersonages();
        this.writePersonages();
    }


    /**
     * Een methode om de personages van een bestand te lezen.
     * De delimeter is een ';'
     * Na elk delimeter wordt een eigenschap van personage geschreven.
     * <p>
     * In v2.0 zal er ook een checker geplaatst worden om te zien of spel opgeslagen is.
     * Zo ja, dan zal er van een adere bestand gelezen worden.
     *
     * @author LeventHAN
     */
    private void readPersonages() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Personage personage;
            while (line != null) {
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
                line = reader.readLine(); // lees den volgende rij moat
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Een methode om de huidige personages in een file te schrijven. EXTRA VOOR V2!
     * Zal effectief gebruikt worden in v2.0
     *
     * @author LeventHAN
     * @see 2.0
     */
    private void writePersonages() {
        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("testPersonages.txt"))) {
            for (Personage person : personages) {
                bw.write(person.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Getter methode dat een personage terug stuurt aan de hand van een index
     *
     * @param index een integer dat als index beschouwt wordt
     * @return Personage op dat index plaats
     * @author LeventHAN
     */
    public Personage getPersonageByIndex(int index) {
        return personages.get(index);
    }


    /**
     * Getter voor de personages in een List te krijgen
     * Zodat we dan de methodes van List op deze kan toepassen zoals forEach, size(), etc..
     *
     * @return personages met personages
     * @author LeventHAN
     */
    public List<Personage> getPersonages() {
        return personages;
    }

    /**
     * Getter voor de aantal overgebleven personages dat nog actief zijn
     *
     * @return een getal dat de aantal active personages zegt
     * @author LeventHAN
     */
    public int getAantalOvergeblevenActivePersonages() {
        int counter;
        counter = (int) personages.stream().filter(Personage::isActive).count();
        return counter;
    }


    /**
     * Deze sorteer methode (Comperator) is expliciet niet gebruikt in v1.0 om de personages in een random volgorde te plaatsen
     * De volgorde dat in de personages bestand staat dus.
     * <p>
     * Ik zal deze methode in een settings toevoegen zodat als men het gesorteerd wil dat men het kan gebruiken.
     *
     * @author LeventHAN
     * @since 2.0
     */
    public void sorteerGeslachtNaam() {
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

    /**
     * toString() methode voor logging doelen
     *
     * @return alle personages in een string
     * @author LeventHAN
     */
    @Override
    public String toString() {
        return "Personages{" +
                "personages=" + personages +
                '}';
    }
}
