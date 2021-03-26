package wieIsHet.view.verwijder;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import wieIsHet.model.MainModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Deze view toont de scherm waar de spelers hun personages kunnen verwijderen.
 *
 * @author LeventHAN
 */
public class VerwijderPersView extends GridPane {
    MainModel model;
    List<Button> personagesButtons = new ArrayList<>();
    // In v2 zal gebruikt worden!
    String persoonNaam;
    Button btnGaVerder;
    Label lblTitel;
    Label lblDescriptionText;

    public VerwijderPersView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        btnGaVerder = new Button("Ga Verder");
        lblTitel = new Label("Verwijder Personages");
        lblTitel.setStyle("-fx-font-weight: 900; -fx-font-size: 30px;");
        lblDescriptionText = new Label("Klik de personages die u wilt verwijderen.");
        lblDescriptionText.setStyle("-fx-font-size: 15px; -fx-background-color: lightgreen;");
    }

    private void layoutNodes() {

        // this.setGridLinesVisible(true);
        add(lblTitel, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 1, 3, 1);
        add(lblDescriptionText, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 2, 3, 1);
        this.add(btnGaVerder, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 3, 2, 1);
        this.setHgap(20);
        this.setVgap(15);
        this.setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getPersonagesButtons() {
        return personagesButtons;
    }

    public Button getBtnGaVerder() {
        return btnGaVerder;
    }
}
