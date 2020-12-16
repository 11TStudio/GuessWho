package wieIsHet;

import java.util.Random;

public class Spel {
    private int maxScore;
    private Speler playerOne;
    private String vraag;
    private Random rand = new Random();
    private int random = rand.nextInt(12)+1;

    public Spel() {

    }

    public int getMaxScore(Speler player) {
        return this.maxScore;
    }

    public void setMaxScore(int score) {
        if ((this.maxScore < score)) {
            this.maxScore = score;
        }
    }

    public void setPlayerOne(Speler player) {
        this.playerOne = player;
    }



    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public void startSpel(String naam, String personage) {
        Speler newPlayer = new Speler(naam, 0, personage);
        setPlayerOne(newPlayer);
        setMaxScore(getMaxScore(newPlayer));
    }

}
