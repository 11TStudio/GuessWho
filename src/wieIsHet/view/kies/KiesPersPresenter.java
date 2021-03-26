package wieIsHet.view.kies;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.view.game.GamePresenter;
import wieIsHet.view.game.GameView;

import java.util.Random;

public class KiesPersPresenter {
    MainModel model;
    KiesView kiesView;

    public KiesPersPresenter(MainModel model, KiesView kiesView) {
        this.model = model;
        this.kiesView = kiesView;

        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        kiesView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Random random = new Random();
                    model.setGekozenPersoonSpeler2(model.getAllPersonagesSpeler2().getPersonageByIndex(random.nextInt(model.getSizePersonages2())));

                    model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                        if(button.getText().equals(personage.getNaam())) {
                            model.setGekozenPersoonSpeler1(personage);
                            GameView gameView = new GameView();
                            GamePresenter gamePresenter = new GamePresenter(model, gameView);
                            kiesView.getScene().setRoot(gameView);
                            gamePresenter.addWindowEventHandlers();
                            // Default width and height for the whole project
                            gameView.getScene().getWindow().setWidth(1020);
                            gameView.getScene().getWindow().setHeight(730);
                        }
                    });
                    Log.debug("Personage van Speler 1 is "+model.getGekozenPersoonSpeler1());
                    Log.debug("Personage van Speler 2 is "+model.getGekozenPersoonSpeler2());
                }
            });
        });
    }

    private void updateView() {

        // Vult de view met data uit model


    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
        kiesView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
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
}
