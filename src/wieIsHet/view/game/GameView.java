package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;

public class GameView  extends BorderPane {
    RosterView personageView;
    VerwijderPersView verwijderView;
    FooterView footer;
    RightSidebarView rightSidebar;

    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        personageView = new RosterView();
        footer = new FooterView();
        verwijderView = new VerwijderPersView();
        rightSidebar = new RightSidebarView();
    }

    private void layoutNodes() {
        setBottom(footer);
        setCenter(verwijderView);
        setRight(rightSidebar);
    }

    public RosterView getPersonageView() {
        return personageView;
    }

    public VerwijderPersView getVerwijderView() {
        return verwijderView;
    }

    public RightSidebarView getRightSidebarView() {
        return rightSidebar;
    }

}
