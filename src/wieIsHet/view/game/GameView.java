package wieIsHet.view.game;

import javafx.scene.layout.BorderPane;

public class GameView  extends BorderPane {
    RosterView rosterView;
    // private Node attributen (controls)

    // private Node attributen (controls)
    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {

        rosterView = new RosterView();
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
    }

    private void layoutNodes() {
        this.setCenter(rosterView);
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
    }

    // implementatie van de nodige
    // package-private Getters

}
