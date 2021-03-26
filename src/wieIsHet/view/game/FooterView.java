package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
        footer = new HBox(20);

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

}
