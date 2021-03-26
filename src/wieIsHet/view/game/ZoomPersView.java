package wieIsHet.view.game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import wieIsHet.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class ZoomPersView extends GridPane {
    MainModel model;
    List<Button> personagesButtons = new ArrayList<>();
    Label titel;

    public ZoomPersView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        titel = new Label("Klik op de personages om ze te vergroten!");
        this.getStylesheets().add("css/zoomView.css");
    }

    private void layoutNodes() {
        add(titel, 0, (model.getAllPersonagesSpeler1().getPersonages().size()/5)+1, 5, 5);
        this.setHgap(20);
        this.setVgap(15);
        this.setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getPersonagesButtons() {
        return personagesButtons;
    }
}
