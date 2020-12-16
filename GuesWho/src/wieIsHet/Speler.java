package wieIsHet;

public class Speler {
    private String naam;
    private int score;
    private String vraag;

    public Speler(String naam, int score, String vraag) {
        this.naam = naam;
        this.score = score;
        this.vraag = vraag;
    }

    public void updateScore(int n) {
        this.score = this.score + n;
    }

    public int getScore() {
        return this.score;
    }

    public String getNaam() {
        return this.naam;
    }
}
