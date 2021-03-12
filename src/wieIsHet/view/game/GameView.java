package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class GameView  extends BorderPane {
    RosterView rooster;
    FooterView footer;
    // private Node attributen (controls)

    // private Node attributen (controls)
    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {

        rooster = new RosterView();
        footer = new FooterView();
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
    }

    private void layoutNodes() {

        this.setBottom(footer);
        this.setCenter(rooster);
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
    }

    // implementatie van de nodige
    // package-private Getters

}
