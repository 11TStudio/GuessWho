package wieIsHet.view.start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import wieIsHet.view.game.VerwijderPersView;


public class StartView extends BorderPane {

    // private Node attributen (controls)
    ButtonsView buttonsView;
    Image backGround;
    Image logo;
    ImageView imageView;
    Label copyright;

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
        backGround = new Image("images/backgrounds/bg.png");
        logo = new Image("images/logo/logo.png");
        imageView = new ImageView(logo);
        copyright = new Label("Copyright \u00A9 2021 LeventHAN");
        copyright.setStyle("-fx-background-color: yellow;");

    }

    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        setCenter(imageView);
        setTop(buttonsView);
        setBottom(copyright);
        setAlignment(imageView, Pos.CENTER);
        setAlignment(buttonsView, Pos.CENTER);
        setAlignment(copyright, Pos.CENTER);

        setMargin(buttonsView, new Insets(20,0,0,0));

        setBackground(new Background(new BackgroundImage(backGround,
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