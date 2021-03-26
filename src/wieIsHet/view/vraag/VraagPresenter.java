package wieIsHet.view.vraag;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContentDisplay;
import javafx.stage.WindowEvent;
import wieIsHet.model.MainModel;
import wieIsHet.view.game.Knop;
import wieIsHet.view.gok.GokPresenter;
import wieIsHet.view.gok.GokView;
import wieIsHet.view.wissel.WisselPresenter;
import wieIsHet.view.wissel.WisselView;

public class VraagPresenter {
    MainModel model;
    VraagView vraagView;
    boolean set = false;

    public VraagPresenter(MainModel model, VraagView vraagView) {

        this.model = model;
        this.vraagView = vraagView;

        this.addEventHandlers();
        this.updateView();


    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.

        vraagView.getListPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    switch (button.getText()) {
                        case "Gok!":
                            GokView gokView = new GokView();
                            GokPresenter gokPresenter = new GokPresenter(model, gokView);
                            vraagView.getScene().setRoot(gokView);
                            gokPresenter.addWindowEventHandlers();
                            // Default width and height for the whole project
                            gokView.getScene().getWindow().setWidth(1020);
                            gokView.getScene().getWindow().setHeight(730);
                            break;
                        default:
                            WisselView wisselView = new WisselView();
                            WisselPresenter wisselPresenter = new WisselPresenter(model, wisselView);
                            vraagView.getScene().setRoot(wisselView);
                            wisselPresenter.addWindowEventHandlers();
                            // Default width and height for the whole project
                            wisselView.getScene().getWindow().setWidth(1020);
                            wisselView.getScene().getWindow().setHeight(730);
                    }
                }
            });
        });
    }

    private void updateView() {

        // Vult de view met data uit model
        putButtons();

    }

    public void addWindowEventHandlers() {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
        vraagView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Ben je zeker?");
                alert.setContentText("Weet je zeker dat je wilt afsluiten?");
                alert.setTitle("Warning!");
                alert.getButtonTypes().clear();
                ButtonType no = new ButtonType("Neen");
                ButtonType yes = new ButtonType("Ja");
                alert.getButtonTypes().addAll(no, yes);
                alert.showAndWait();
                if (alert.getResult().equals(no)) {
                    event.consume();
                }
                // IN V2!!
//                else if (alert.getResult().equals(yes)) {
//                    try {
//                        model.saveGame();
//                    } catch (WieIsHetException e) {
//                        alert = new Alert(Alert.AlertType.ERROR);
//                        alert.setTitle("Unable to save:");
//                        alert.setContentText(e.getMessage());
//                        alert.showAndWait();
//                    }
//                }
            }
        });
    }

    private void putButtons() {

        if (!set) {
            String loc = "/images/answers/endTurn.png";
            Knop knopje = new Knop(120, 120, loc, "Eindig Ronde");
            knopje.setContentDisplay(ContentDisplay.TOP);
            vraagView.getListPersonagesButtons().add(knopje);
            vraagView.add(knopje, 0, 5, 5, 5);


            loc = "/images/answers/guess.png";
            knopje = new Knop(120, 120, loc, "Gok!");
            knopje.setContentDisplay(ContentDisplay.TOP);
            vraagView.getListPersonagesButtons().add(knopje);
            vraagView.add(knopje, 5, 5, 5, 5);

            addEventHandlers();
            set = true;
        }


    }
}
