package wieIsHet.view.start;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

/**
 * De view dat bij de start scherm getoond wordt.
 * De buttonsview wordt hier in toegevoegd.
 *
 * @author LeventHAN
 */
public class StartView extends BorderPane {

    // private Node attributen (controls)
    ButtonsView buttonsView;
    Image imgBackGround;
    Image imgLogo;
    ImageView imageView;
    MenuItem miExit;
    MenuItem miRestart;
    MenuItem miSave;
    MenuItem miLoad;
    MenuItem miSettings;
    MenuItem miAbout;
    MenuItem miRules;

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
        imgBackGround = new Image("images/backgrounds/bg.png");
        imgLogo = new Image("images/logo/logo.png");
        imageView = new ImageView(imgLogo);
        //menu
        miExit = new MenuItem("Exit");
        miAbout = new MenuItem("About");
        miRules = new MenuItem("Rules");
        miSettings = new MenuItem("Settings");
        miSave = new MenuItem("Save");
        miLoad = new MenuItem("Load");
        miRestart = new MenuItem("Restart");

    }

    private void layoutNodes() {
        // Layout van de Nodes
        // add… methodes (of set…)
        // Insets, padding, alignment, …
        Menu menuGame = new Menu("Game", null, miSettings, miSave, miLoad, new SeparatorMenuItem(), miRestart, miExit);
        Menu menuHelp = new Menu("Help", null, miRules, miAbout);
        MenuBar menuBar = new MenuBar(menuGame, menuHelp);
        setTop(menuBar);
        setCenter(imageView);
        setBottom(buttonsView);
        setAlignment(imageView, Pos.CENTER);
        setAlignment(buttonsView, Pos.TOP_CENTER);
        setMargin(buttonsView, new Insets(0, 0, 20, 0));

        // setMargin(buttonsView, new Insets(20,0,0,0));

        setBackground(new Background(new BackgroundImage(imgBackGround,
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

    public MenuItem getMiExit() {
        return miExit;
    }

    public MenuItem getMiRestart() {
        return miRestart;
    }

    public MenuItem getMiSave() {
        return miSave;
    }

    public MenuItem getMiLoad() {
        return miLoad;
    }

    public MenuItem getMiSettings() {
        return miSettings;
    }

    public MenuItem getMiAbout() {
        return miAbout;
    }

    public MenuItem getMiRules() {
        return miRules;
    }
}