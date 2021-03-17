package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class RosterView extends GridPane {
    Button button;
    int row = 0;
    int col = 0;

    public RosterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        for (int i = 0; i < 20; i++) {
            final int buttonNumber = i;
            // TODO: Personage19 komt meermaals terug.
            // Gefixt door final te gebruiken.
            String naam = "Person"+i;
            //      String loc = "/images/personages/"+img+".png";
            String loc = "/images/personages/Person1.png";

            final Knop button = new Knop(80,80,loc,naam);
            //button.setMinSize(80, 80);

            if(row%5==0) {
                col++;
                row=0;
            }

            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {

                    System.out.print(button+"\n"+ buttonNumber +"\n");
                }
            });

            this.add(button, row, col);
            this.setHgrow(button, Priority.ALWAYS);
            this.setHgrow(button, Priority.ALWAYS);
            System.out.print("The ROW: "+row+"\n");
            System.out.print("The COL: "+col+"\n");
            row++;

        }

    }

    private void layoutNodes() {
        // this. is onze view.

        this.setGridLinesVisible(true);
        this.setHgap(50);
        this.setVgap(35);
        this.setPadding(new Insets(15, 15, 10, 15));
    }


}
