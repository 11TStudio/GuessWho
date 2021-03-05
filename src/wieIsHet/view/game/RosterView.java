package wieIsHet.view.game;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class RosterView extends GridPane {


    public RosterView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
    }

    private void layoutNodes() {

        this.setGridLinesVisible(true);
        this.setHgap(50);
        this.setVgap(35);
        this.setPadding(new Insets(15, 15, 10, 15));
        int w = 0;
        for (int i = 0; i < 20; i++) {
            String img = "Person"+i;
            if (i%5==0) { w = 0; }
            if (i < 5) {
                ImageView image = new ImageView(
                        new Image("/images/personages/Person1.png"));
                this.add(image, 0, 0+w, 1, 1);
            } else if (i >= 5 && i < 10) {
                ImageView image = new ImageView(
                        new Image("/images/personages/Person1.png"));
                this.add(image, 1, 0+w, 1, 1);
            } else if (i >= 10 && i < 15) {
                ImageView image = new ImageView(
                        new Image("/images/personages/Person1.png"));
                this.add(image, 2, 0+w, 1, 1);
            } else {
                ImageView image = new ImageView(
                        new Image("/images/personages/Person1.png"));
                this.add(image, 3, 0+w, 1, 1);
            }
            w++;
        }
    }

}
