package wieIsHet.view.wissel;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import wieIsHet.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class WisselView extends GridPane {
    MainModel model;
    List<Button> personagesButtons = new ArrayList<>();
    Label lblTitel;
    Label lblDescriptionText;

    public WisselView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        lblTitel = new Label("De tegenstaander heeft een vraag gesteld!");
        lblTitel.setStyle("-fx-font-weight: 900; -fx-font-size: 30px;");
        lblDescriptionText = new Label("Je moet correct antwoorden!");
        lblDescriptionText.setStyle("-fx-font-size: 15px; -fx-background-color: lightgreen;");
    }

    private void layoutNodes() {
        add(lblTitel, 0, 0, 3, 1);
        add(lblDescriptionText, 0, 2, 3, 1);
        this.setHgap(20);
        this.setVgap(15);
        this.setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getPersonagesButtons() {
        return personagesButtons;
    }
}
