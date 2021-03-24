package wieIsHet.model;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Deze klasse is verantwoordelijk voor het opslagen en laden van een spel.
 * Het spel wordt opgeslagen naar een binair bestand in de rootfolder van het project
 * @author LeventHAN
 * @version v1.0
 */
public class WieIsHetSaver {

    private static final String SAVE_GAME_SETTINGS = "save_game_settings.bin";
    private MainModel model;

    public WieIsHetSaver(MainModel model) {
        this.model = model;
    }

    /**
     * Bewaart de settings, de personages, de button status, de spelers
     * @throws IOException
     */
    public void save() throws IOException {
        //save game to file
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(SAVE_GAME_SETTINGS));
        boolean autoPickStatus = model.getSettings().isCbAutoPickEnable();
        dos.writeBoolean(autoPickStatus);
        Personages speler1 = model.getAllPersonagesSpeler1();
        Personages speler2 = model.getAllPersonagesSpeler2();

        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("save_game_speler_1.txt"))) {
            for (Personage person : speler1.getPersonages()) {
                bw.write(person.toString());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("save_game_speler_2.txt"))) {
            for (Personage person : speler2.getPersonages()) {
                bw.write(person.toString());
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Laad de settings, de personages, de button status, de spelers
     * @throws IOException
     */
    public void load() throws IOException {

        DataInputStream dis = new DataInputStream(new FileInputStream(SAVE_GAME_SETTINGS));
        boolean autoPickStatus = dis.readBoolean();
        Settings settings = new Settings();
        settings.setAutoPickEnable(autoPickStatus);
        Personages personagesSpeler1 = new Personages();
        Personages personagesSpeler2 = new Personages();
        personagesSpeler1.getPersonages().clear();
        personagesSpeler2.getPersonages().clear();

        try(BufferedReader reader = new BufferedReader(new FileReader("save_game_speler_2.txt"))){
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
                personage = new Personage(stukken[0], stukken[1], stukken[2], stukken[3], stukken[4], stukken[5], stukken[6], stukken[7], stukken[8], stukken[9]);
                personagesSpeler1.getPersonages().add(personage);
                line = reader.readLine(); // lees den volgende
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(new FileReader("save_game_speler_2.txt"))){
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
                personage = new Personage(stukken[0], stukken[1], stukken[2], stukken[3], stukken[4], stukken[5], stukken[6], stukken[7], stukken[8], stukken[9]);
                personagesSpeler2.getPersonages().add(personage);
                line = reader.readLine(); // lees den volgende
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        // model.load(guesses,riddle,settings);
    }
}

