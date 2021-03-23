package wieIsHet.view.game;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import wieIsHet.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class VerwijderPersView extends GridPane {
    MainModel model;
    List<Button> personagesButtons = new ArrayList<>();
    int row = 0;
    int col = 0;
    String persoonNaam;

    public VerwijderPersView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
            persoonNaam = personage.getNaam();
            String loc = "/images/personages/"+persoonNaam+".png";
            Knop knopje = new Knop(80,80,loc,persoonNaam);
            setHgrow(knopje, Priority.ALWAYS);
            setHgrow(knopje, Priority.ALWAYS);
            // So we can add eventhandlers to all the buttons :P
            knopje.setContentDisplay(ContentDisplay.TOP);
            personagesButtons.add(knopje);
            if(row%5==0) {
                col++;
                row=0;
            }
            this.add(knopje, row, col);
            row++;
        });
    }

    private void layoutNodes() {

        this.setGridLinesVisible(true);
        this.setHgap(20);
        this.setVgap(15);
        this.setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getPersonagesButtons() {
        return personagesButtons;
    }
}
