package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import wieIsHet.model.MainModel;
import wieIsHet.model.Personages;

import java.util.ArrayList;
import java.util.List;

public class RosterView extends GridPane {
    MainModel model;
    List<Button> personagesButtons = new ArrayList<>();
    int row = 0;
    int col = 0;
    String persoonNaam;

    public RosterView() {
        this.model = new MainModel();
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
//        // attributen initialiseren
//        for (int i = 0; i < model.getSizePersonages(); i++) {
//            persoonNaam = "Personage"+(i+1);
//            String loc = "/images/personages/"+persoonNaam+".png";
//            Knop knopje = new Knop(80,80,loc,persoonNaam, i);
//            setHgrow(knopje, Priority.ALWAYS);
//            setHgrow(knopje, Priority.ALWAYS);
//            personagesButtons.add(knopje);
//            if(row%5==0) {
//                col++;
//                row=0;
//            }
//            this.add(personagesButtons.get(i), row, col);
//            row++;
//        }

    }

    private void layoutNodes() {

        // this.getChildren().addAll(personagesButtons);
        this.setGridLinesVisible(true);
        this.setHgap(50);
        this.setVgap(35);
        this.setPadding(new Insets(15, 15, 10, 15));
    }

    public List<Button> getPersonagesButtons() {
        return personagesButtons;
    }
    public void removePersonageButton() {
        //this.initialiseNodes();
    }
}
