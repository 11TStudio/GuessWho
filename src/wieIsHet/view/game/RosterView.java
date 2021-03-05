package wieIsHet.view.game;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class RosterView extends GridPane {
    List<Button> buttonlist = new ArrayList<>();

    public RosterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        // attributen initialiseren
        for (int i = 0; i < 20; i++) {
            String img = "Person"+i;
            // DEBUGING WITH ONLY ONE PERSON
            //      String loc = "/images/personages/"+img+".png";
            String loc = "/images/personages/Person1.png";

            Button button = new Button(img);
            button.setPrefSize(80, 80);

            ImageView personImage = new ImageView(new Image(loc));

            button.setGraphic(personImage);

            buttonlist.add(button);
        }
        System.out.println(buttonlist);

    }

    private void layoutNodes() {
        // this. is onze view.
        this.setGridLinesVisible(true);
        this.setHgap(50);
        this.setVgap(35);
        this.setPadding(new Insets(15, 15, 10, 15));
        this.getChildren().addAll(buttonlist);
    }

}
