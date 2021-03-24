package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class FooterView extends HBox {
    Button kiesVraag;
    Button gok;
    ComboBox<String> cbVragen;
    HBox footer;
    ObservableList<String> vragen;

    public FooterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        footer = new HBox(8);

        cbVragen= new ComboBox<>();
        vragen = FXCollections.observableArrayList();

        // this.setMargin(this.cbVragen, new Insets(15));
        kiesVraag = new Button("ASK IT!");
        gok = new Button("Gok!");





        // TODO score



        // HBox.setMargin(kiesVraag, new Insets(10, 10, 10, 10));
    }

    private void layoutNodes() {
        cbVragen.setItems(vragen);
        cbVragen.getSelectionModel().select(0);
        //footer.setPadding(new Insets(15, 12, 15, 12));
        // this.getChildren().addAll(new Label("Dit is een test label"));
        //footer.setStyle("-fx-background-color: #336699;");
        this.getChildren().addAll(cbVragen, kiesVraag, gok);
    }

    public String getCbVragen() {
        return cbVragen.getValue();
    }

    public Button getKiesVraag() {
        return kiesVraag;
    }

    public Button getGok() {
        return gok;
    }

    public void removeVraag(String vraag) {
        cbVragen.getItems().remove(vraag);
        vragen.remove(vraag);
    }
}
