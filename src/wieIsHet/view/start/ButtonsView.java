package wieIsHet.view.start;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import wieIsHet.view.game.GamePresenter;
import wieIsHet.view.game.GameView;
import wieIsHet.view.game.Knop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ButtonsView extends VBox {

    // private Node attributen (controls)
    Image achtergrond;
    List<Button> btnsStartScherm = new ArrayList<>();

    // private Node attributen (controls)
    public ButtonsView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
        Knop btnStartPvP = new Knop(20,20,"images/buttons/pvp.png","Start PvP");
        Knop btnStartPvC = new Knop(20,20,"images/buttons/pvc.png","Start PvC");
        Knop btnStartAbout = new Knop(20,20,"images/buttons/pvp.png","About Us");
        Knop btnExit = new Knop(20,20,"images/buttons/pvp.png","Exit");



        btnsStartScherm.add(btnStartPvP);
        btnsStartScherm.add(btnStartPvC);
        btnsStartScherm.add(btnStartAbout);
        btnsStartScherm.add(btnExit);

        btnsStartScherm.forEach(button -> {
            button.setContentDisplay(ContentDisplay.TOP);
            button.setStyle("-fx-font-size:12; -fx-font-weight: 900;");
        });



    }

    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        this.setSpacing(8);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(btnsStartScherm);
    }

    // implementatie van de nodige
    // package-private Getters
    public List<Button> getBtnsStartScherm() {
        return btnsStartScherm;
    }
}