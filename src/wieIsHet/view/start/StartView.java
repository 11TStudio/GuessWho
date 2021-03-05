package wieIsHet.view.start;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StartView extends BorderPane {

    // private Node attributen (controls)
    Button btnStartPVC;
    Button btnStartPVP;
    Button btnExit;
    Image achtergrond;
    // private Node attributen (controls)
    public StartView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
        btnStartPVP = new Button("PvP");
        btnStartPVC = new Button("PvC");
        btnExit = new Button("EXIT");
        achtergrond = new Image("images/backgrounds/achterground.png");

    }

    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        this.setBackground(new Background(new BackgroundImage(achtergrond,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));
    }

    // implementatie van de nodige
    // package-private Getters

}