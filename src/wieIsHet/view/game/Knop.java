package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;


public class Knop extends Button {
    int row = 0;
    int col = 0;
    Button button;
    final int MAX_PERS = 20;

    public Knop(int row, int col, String locatie, String personageNaam) {
        this.row = row;
        this.col = col;
        ImageView personImage = new ImageView(new Image(locatie));
        setText(personageNaam);

        setGraphic(personImage);
        setPrefSize(100, 70);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
