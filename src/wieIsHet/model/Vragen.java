package wieIsHet.model;


import java.io.*;
import java.util.LinkedList;
import java.util.List;


/**
 * De klassen vragen is een van de derde belangrijkste klassen in onze spel
 * Het houdt namelijk een List en men kan de List methodes aan deze object toepassen dus.
 * Zoals forEach, add, remove, size(), etc..
 *
 * @author LeventHAN
 * @version 1.0
 */
public class Vragen {
    List<Vraag> vragen;
    private final InputStream inputStream;

    public Vragen() {
        vragen = new LinkedList<>();
        this.inputStream = this.getClass().getResourceAsStream("/game_assets/vragen.txt");
        this.readVragen();
        // In v2!!!
        // this.writeVragen();
    }

    /**
     * Getter voor de vragen
     *
     * @return vragen met alle vragen en waarop we de methodes van List kunnen toepassen dus
     * @author LeventHAN
     */
    public List<Vraag> getVragen() {
        return vragen;
    }

    /**
     * Getter voor de aantal gevraagde vragen
     *
     * @return een integer dat de aantal gevraagde correspondeert
     * @author LeventHAN
     */
    public int getGevraagdeVragen() {
        int counter = (int) vragen.stream().filter(Vraag::isGevraagd).count();
        return counter;
    }

    /**
     * Getter voor de aantal niet gevraagde, dus overgebleven vragen
     *
     * @return een integer dat de aantal beschikbaare vragen die kunnen gevraagd worden correspondeert
     * @author LeventHAN
     */
    public int getOvergeblevenVragen() {
        int counter = (int) vragen.stream().filter(vraag -> !vraag.isGevraagd()).count();
        return counter;
    }

    /**
     * Een methode dat de vragen uit een bestand leest
     *
     * @author LeventHAN
     */
    private void readVragen() {
        // Hier aanvullen...
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line = reader.readLine();
            Vraag vraag;
            while (line != null) {
                String[] stukken = line.split(";");
                vraag = new Vraag(stukken[0], Boolean.parseBoolean(stukken[1]));
                vragen.add(vraag);
                line = reader.readLine(); // lees den volgende
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Een methode dat de vragen op een bestand schrijft.
     * Bedoeld voor v2.0!!!
     * Heeft geen enkele functie in v1.0, dus.
     *
     * @author LeventHAN
     * @since 2.0
     */
    private void writeVragen() {
        // Hier aanvullen...
        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("testVragen.txt"))) {
            for (Vraag vraag : vragen) {
                bw.write(vraag.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Methode om vragen te verwijderen, zal in v2.0 gebruikt worden!
     *
     * @param vraag de vraag dat men wilt verwijderen
     * @author LeventHAN
     */
    public void removeVraag(Vraag vraag) {
        vragen.remove(vraag);
    }

    /**
     * Methode om vragen te voegen, zal in v2.0 gebruikt worden!
     *
     * @param vraag de vraag dat men wilt toevoegen
     * @author LeventHAN
     */
    public void addVraag(Vraag vraag) {
        vragen.add(vraag);
    }

    /**
     * toStrin() methode voor logging doelen
     *
     * @return string met alle vragen
     */
    @Override
    public String toString() {
        return "Vragen{" +
                "vragen=" + vragen +
                '}';
    }
}
