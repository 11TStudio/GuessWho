package wieIsHet.view.start;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class StartView extends BorderPane {

    // private Node attributen (controls)
    ButtonsView buttonsView;
    Image achtergrond;

    // private Node attributen (controls)
    public StartView() {
        buttonsView = new ButtonsView();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // Initialisatie van de Nodes
        // bvb.:
        // button = new Button("...")
        // label = new Label("...")
        achtergrond = new Image("images/backgrounds/achterground.png");


    }

    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        this.setCenter(buttonsView);
        this.setBackground(new Background(new BackgroundImage(achtergrond,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT)));

    }

    // implementatie van de nodige
    // package-private Getters
    public ButtonsView getButtonsView() {
        return buttonsView;
    }
}