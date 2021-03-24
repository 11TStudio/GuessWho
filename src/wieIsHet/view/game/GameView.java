package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class GameView  extends BorderPane {
    private VerwijderPersView verwijderView;
    private FooterView footer;
    private RightSidebarView rightSidebar;
    private MenuItem miExit;
    private MenuItem miRestart;
    private MenuItem miSave;
    private MenuItem miLoad;
    private MenuItem miSettings;
    private MenuItem miAbout;
    private MenuItem miRules;

    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        footer = new FooterView();
        verwijderView = new VerwijderPersView();
        rightSidebar = new RightSidebarView();
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


        Menu menuGame = new Menu("Game",null,miSettings, miSave, miLoad, new SeparatorMenuItem(),miRestart,miExit);
        Menu menuHelp = new Menu("Help",null, miRules,miAbout);
        MenuBar menuBar = new MenuBar(menuGame,menuHelp);
        setTop(menuBar);

        setBottom(footer);
        setCenter(verwijderView);
        setRight(rightSidebar);
    }

    public VerwijderPersView getVerwijderView() {
        return verwijderView;
    }

    public RightSidebarView getRightSidebarView() {
        return rightSidebar;
    }

    public FooterView getFooterView() {
        return footer;
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
