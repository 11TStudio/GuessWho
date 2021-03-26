package wieIsHet.view.gok;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import wieIsHet.model.MainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Deze view toont alle beschikbaare actieve personages dat speler heeft en maakt het mogelijk om te gokken.
 *
 * @author LeventHAN
 */
public class GokView extends GridPane {
    MainModel model;
    List<Button> personagesButtons = new ArrayList<>();
    Label lblTitel;
    Label lblDescriptionText;

    public GokView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        lblTitel = new Label("Verwijder Personages");
        lblTitel.setStyle("-fx-font-weight: 900; -fx-font-size: 30px;");
        lblDescriptionText = new Label("Klik de personages die u wilt verwijderen.");
        lblDescriptionText.setStyle("-fx-font-size: 15px; -fx-background-color: lightgreen;");
    }

    private void layoutNodes() {

        // this.setGridLinesVisible(true);
        add(lblTitel, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 1, 3, 1);
        add(lblDescriptionText, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 2, 3, 1);
        this.setHgap(20);
        this.setVgap(15);
        this.setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getPersonagesButtons() {
        return personagesButtons;
    }
}
