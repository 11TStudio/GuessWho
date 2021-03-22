package wieIsHet.view.game;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;


public class Knop extends Button {
    public Knop (double height, double width, String locatie, String personageNaam) {
        ImageView personImage = new ImageView(new Image(locatie));
        personImage.setFitWidth(width);
        personImage.setFitHeight(height);
        setCursor(Cursor.HAND);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AudioClip clickSound = new AudioClip(this.getClass().getResource("/media/onMouseClick.mp3").toExternalForm());
                clickSound.play();
            }
        });
        setText(personageNaam);
        setGraphic(personImage);
        setPrefSize(height, width);
    }
}
