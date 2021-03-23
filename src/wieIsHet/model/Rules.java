package wieIsHet.model;

import wieIsHet.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Deze klasse laad de spelregels vanuit een tekstbestand in de rootfolder van het project
 */
public class Rules {
    public static final String RULES_FILE = "game_assets/rules.txt";

    private String rules = "";

    public Rules() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/" + RULES_FILE)))){
            String line = "";
            while ((line=reader.readLine())!=null){
                rules += line + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.debug("Unable to load game rules: " + e.getMessage());
            throw new WieIsHetException("Unable to load the game rules...");
        }
    }

    public String getRules(){
        return rules;
    }
}

