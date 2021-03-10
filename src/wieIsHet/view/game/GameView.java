package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class GameView  extends BorderPane {
    private ComboBox<String> cbVragen;
    RosterView rosterView;
    // private Node attributen (controls)

    // private Node attributen (controls)
    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {

        rosterView = new RosterView();


        this.cbVragen= new ComboBox<>();
        ObservableList<String> namen = FXCollections.observableArrayList(
                "Mijn vraag dat hier zal komen is wel wat lang denk ik he ?",
                "Is je haar kleur deze kleur of dat kleur ?",
                "Wtf Zeg Gij Moat?"
        );
        this.cbVragen.setItems(namen);
        this.cbVragen.getSelectionModel().select(0);

        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
    }

    private void layoutNodes() {
        this.setCenter(rosterView);
        this.setBottom(this.cbVragen);
        this.setMargin(this.cbVragen, new Insets(15));
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
    }

    // implementatie van de nodige
    // package-private Getters

}
