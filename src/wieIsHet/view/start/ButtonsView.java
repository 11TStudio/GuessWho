package wieIsHet.view.start;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import wieIsHet.view.game.Knop;

import java.util.ArrayList;
import java.util.List;

/**
 * Deze view houdt alle buttons van de startscherm.
 *
 * @author LeventHAN
 */
public class ButtonsView extends HBox {

    List<Button> listStartSchermButtons = new ArrayList<>();

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
        Knop btnStartPvP = new Knop(40, 60, "images/buttons/pvp.png", "Start PvP");
        Knop btnStartPvC = new Knop(40, 60, "images/buttons/pvc.png", "Start PvC");
        Knop btnStartAbout = new Knop(40, 60, "images/buttons/pvp.png", "About Us");
        Knop btnExit = new Knop(40, 60, "images/buttons/pvp.png", "Exit");
        btnStartPvP.setTooltip(new Tooltip("Moet nog gemaakt worden in V2!"));

        listStartSchermButtons.add(btnStartPvP);
        listStartSchermButtons.add(btnStartPvC);
        listStartSchermButtons.add(btnStartAbout);
        listStartSchermButtons.add(btnExit);

        listStartSchermButtons.forEach(button -> {
            button.setContentDisplay(ContentDisplay.TOP);
            button.setStyle("" +
                    "-fx-font-size:12; " +
                    "-fx-font-weight: 900;" +
                    "-fx-border-color: #cbb501;" +
                    "-fx-background-color: rgb(252,234,81);");
        });


    }

    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        this.setSpacing(8);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(listStartSchermButtons);
    }

    // implementatie van de nodige
    // package-private Getters
    public List<Button> getListStartSchermButtons() {
        return listStartSchermButtons;
    }
}