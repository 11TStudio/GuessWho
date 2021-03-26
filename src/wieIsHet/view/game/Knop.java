package wieIsHet.view.game;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;

/**
 * De klassen Knop ıs onze vaste klasse om buttons te maken met afbeeldıngen en verschıllende groottes.
 * De buttons hebben ook een sound achter elk klik.
 * Deze klassen maakt mijn code efficienter.
 *
 * @author LeventHAN
 */
public class Knop extends Button {
    public Knop (double height, double width, String locatie, String personageNaam) {
        ImageView ivPersonImage = new ImageView(new Image(locatie));
        ivPersonImage.setFitWidth(width);
        ivPersonImage.setFitHeight(height);
        setCursor(Cursor.HAND);
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                AudioClip acClickSound = new AudioClip(this.getClass().getResource("/media/onMouseClick.mp3").toExternalForm());
                acClickSound.play();
            }
        });
        setText(personageNaam);
        setGraphic(ivPersonImage);
        setPrefSize(height, width);
    }
}
