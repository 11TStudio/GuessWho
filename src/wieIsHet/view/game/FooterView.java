package wieIsHet.view.game;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;

/**
 * De view voor de footer
 * Toont de vragen, ask it en gok buttons!
 *
 * @author LeventHAN
 */
public class FooterView extends HBox {
    Button btnKiesVraag;
    Button btnGok;
    ComboBox<String> cbVragen;
    HBox hbFooter;
    ObservableList<String> olVragen;

    public FooterView() {
        this.initialiseNodes();
        this.layoutNodes();
    }

    private void initialiseNodes() {
        hbFooter = new HBox(20);

        cbVragen = new ComboBox<>();
        olVragen = FXCollections.observableArrayList();

        btnKiesVraag = new Button("ASK IT!");
        btnGok = new Button("Gok!");


        // TODO score in v2
    }

    private void layoutNodes() {

        cbVragen.setItems(olVragen);
        cbVragen.getSelectionModel().select(0);
        this.getChildren().addAll(cbVragen, btnKiesVraag, btnGok);
        this.getStylesheets().add("css/footerView.css");
        // CSS deed raar en wou niet meewerken :(
        this.setStyle("-fx-padding: 10px;" +
                "-fx-background-color: #2babd7");
    }

    /**
     * Deze getter wordt gebruikt om de vraag uit de combobox te krijgen
     *
     * @return String met de vraag
     */
    public String getCbVragen() {
        return cbVragen.getValue();
    }

    /**
     * Getter voor de button kiesvraag zodat we een eventhandler kunnen plakken
     * @return kiesVraag button
     */
    public Button getBtnKiesVraag() {
        return btnKiesVraag;
    }

    /**
     * Getter voor de button gok zodat we een eventhandler kunnen plakken
     * @return gok button
     */
    public Button getBtnGok() {
        return btnGok;
    }

}
