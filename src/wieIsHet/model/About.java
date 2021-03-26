package wieIsHet.model;

import wieIsHet.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Deze klasse laad de about vanuit een tekstbestand in de rootfolder van het project
 *
 * @version 1.0
 * @author LeventHAN
 */
public class About {
    public static final String RULES_FILE = "game_assets/about.txt";

    private String about = "";

    public About() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/" + RULES_FILE)))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                about += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.debug("Unable to load game rules: " + e.getMessage());
            throw new WieIsHetException("Unable to load the game rules...");
        }
    }

    public String getAbout() {
        return about;
    }
}

