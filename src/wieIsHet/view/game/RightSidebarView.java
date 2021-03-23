package wieIsHet.view.game;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class RightSidebarView extends VBox {
    Label lblSpeler1Personage;
    String speler1PersonageNaam;
    Label lblSpeler2Personage;

    Label lblTitelSpeler1;
    Label lblTitelSpeler2;

    // TODO: Namen op een text bestand schrijven en lezen met scores
    Label lblSpeler1Naam;
    String speler1Naam;
    Label lblSpeler2Naam;
    String speler2Naam;
    Label lblScoreSpeler1;
    String scoreSpeler1;
    Label lblScoreSpeler2;
    String scoreSpeler2;

    Image personageSpeler1;
    ImageView personageImg1;
    Image personageSpeler2;
    ImageView personageImg2;

    VBox sideBar;

    public RightSidebarView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        sideBar = new VBox(8);

        lblTitelSpeler1 = new Label("Jouw personage;");
        lblTitelSpeler2 = new Label("Personage te raden;");

        speler1PersonageNaam = "Onbekend";
        lblSpeler1Personage = new Label(speler1PersonageNaam);

        lblSpeler2Personage = new Label("Wie is het???");

        // Todo: Spelers naam nemen
        // TODO: Spelers naam checken voor text file met spelerNaam;Score

        String loc = "/images/personages/"+speler1PersonageNaam+".png";
        personageSpeler1 = new Image(loc);
        personageImg1 = new ImageView(personageSpeler1);
        personageImg1.setFitHeight(80);
        personageImg1.setFitWidth(80);

        loc = "/images/personages/onbekend.png";
        personageSpeler2 = new Image(loc);
        personageImg2 = new ImageView(personageSpeler2);
        personageImg2.setFitHeight(80);
        personageImg2.setFitWidth(80);

    }

    private void layoutNodes() {
        setAlignment(Pos.CENTER);
        setSpacing(10);
        setStyle("-fx-border-color: red;" +
                "-fx-border-insets: 5;" +
                "-fx-border-width: 3;" +
                "-fx-border-style: dashed;" +
                "-fx-padding: 5px;");
        this.getChildren().addAll(lblTitelSpeler1, personageImg1, lblSpeler1Personage, lblTitelSpeler2, personageImg2, lblSpeler2Personage);
    }
}
