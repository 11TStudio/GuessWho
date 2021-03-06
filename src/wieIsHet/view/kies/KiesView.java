package wieIsHet.view.kies;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import wieIsHet.model.MainModel;
import wieIsHet.view.game.Knop;

import java.util.ArrayList;
import java.util.List;

/**
 * Deze view laat de spelers een personage kiezen.
 *
 * @author LeventHAN
 */
public class KiesView extends GridPane {
    MainModel model;
    List<Button> listPersonagesButtons = new ArrayList<>();
    int row = 0;
    int col = 0;
    String persoonNaam;
    Label lblTitel;
    Label lblDescriptionText;

    public KiesView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // geen css bestand gebruikt omdat ik elk label apart een style wil geven.
        lblTitel = new Label("Kies een personage.");
        lblTitel.setStyle("-fx-font-weight: 900; -fx-font-size: 30px;");
        lblDescriptionText = new Label("Deze personage moet vervolgens geraden worden door de tegenstaander.");
        lblDescriptionText.setStyle("-fx-font-size: 15px; -fx-background-color: lightgreen;");
        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
            persoonNaam = personage.getNaam();
            String loc = "/images/personages/" + persoonNaam + ".png";
            Knop knopje = new Knop(80, 80, loc, persoonNaam);
            setHgrow(knopje, Priority.ALWAYS);
            setHgrow(knopje, Priority.ALWAYS);
            // So we can add eventhandlers to all the buttons :P
            knopje.setContentDisplay(ContentDisplay.TOP);
            listPersonagesButtons.add(knopje);
            if (row % 5 == 0) {
                col++;
                row = 0;
            }
            // Ipv layoutNodes doe ik deze hier.
            add(knopje, row, col);
            row++;
        });
    }

    private void layoutNodes() {
        add(lblTitel, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 1, 3, 2);
        add(lblDescriptionText, 0, (model.getAllPersonagesSpeler1().getPersonages().size() / 5) + 2, 5, 5);
        // this.setGridLinesVisible(false);
        setHgap(20);
        setVgap(15);
        setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getListPersonagesButtons() {
        return listPersonagesButtons;
    }

}
