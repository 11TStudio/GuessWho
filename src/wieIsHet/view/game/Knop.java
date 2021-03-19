package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import wieIsHet.model.MainModel;


public class Knop extends Button {
    MainModel model = new MainModel();
    public Knop (int x, int y, String locatie, String personageNaam, int PersoonNummer) {
        ImageView personImage = new ImageView(new Image(locatie));
        personImage.setFitWidth(y);
        personImage.setFitHeight(x);
        setText(model.getNamePersonage(PersoonNummer));

        setGraphic(personImage);
        setPrefSize(x, y);
    }
}
