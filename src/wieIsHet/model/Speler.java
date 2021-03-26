package wieIsHet.model;

/**
 * De klasse maakt de spelers aan met hun naam en score.
 * Alle attributen hebben een getter en een setter zodat ze aangeroepen worden van de model in v2.
 * <p>
 * Deze class zal volledig benut worden in onze v2!
 *
 * @since 2.0
 * @version 1.0
 * @author LeventHAN
 */
public class Speler {
    private String naam;
    private int score;

    public Speler() {
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
