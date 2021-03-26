package wieIsHet.view.wissel;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.WindowEvent;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.model.Vraag;
import wieIsHet.view.game.GamePresenter;
import wieIsHet.view.game.GameView;
import wieIsHet.view.game.Knop;
import wieIsHet.view.start.StartPresenter;
import wieIsHet.view.start.StartView;

public class WisselPresenter {
    MainModel model;
    WisselView wisselView;
    boolean set = false;
    String antwoord = "JA";

    public WisselPresenter(MainModel model, WisselView wisselView) {

        this.model = model;
        this.wisselView = wisselView;

        this.addEventHandlers();
        this.updateView();


    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.

        wisselView.getListPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    switch (button.getText()) {
                        case "Ja!":
                            if (antwoord.equals("JA")) {
                                if (model.gunstigOmTeGokken()) {
                                    String nPers = model.getRandomPersonageComputer();
                                    model.setFoundItSpeler2(model.getGekozenPersoonSpeler1().getNaam().equals(nPers));
                                    model.setWrongGokSpeler2(!model.getGekozenPersoonSpeler1().getNaam().equals(nPers));
                                    showFinishedDialog();
                                } else {
                                    GameView gameView = new GameView();
                                    GamePresenter gamePresenter = new GamePresenter(model, gameView);
                                    wisselView.getScene().setRoot(gameView);
                                    gamePresenter.addWindowEventHandlers();
                                    // Default width and height for the whole project
                                    gameView.getScene().getWindow().setWidth(1020);
                                    gameView.getScene().getWindow().setHeight(730);
                                }
                            } else {
                                return;
                            }
                            break;
                        default:
                            if (antwoord.equals("NEE")) {
                                if (model.gunstigOmTeGokken()) {
                                    String nPers = model.getRandomPersonageComputer();
                                    model.setFoundItSpeler2(model.getGekozenPersoonSpeler1().getNaam().equals(nPers));
                                    model.setWrongGokSpeler2(!model.getGekozenPersoonSpeler1().getNaam().equals(nPers));
                                    showFinishedDialog();
                                } else {
                                    GameView gameView = new GameView();
                                    GamePresenter gamePresenter = new GamePresenter(model, gameView);
                                    wisselView.getScene().setRoot(gameView);
                                    gamePresenter.addWindowEventHandlers();
                                    // Default width and height for the whole project
                                    gameView.getScene().getWindow().setWidth(1020);
                                    gameView.getScene().getWindow().setHeight(730);
                                }

                            } else {
                                return;
                            }
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
        wisselView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
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

    private void putButtons() {

        if (!set) {

            Vraag vraagje = model.getRandomVraagComputer();
            vraagje.setGevraagd(true);
            if (!model.checkVraagSpeler2(vraagje)) {
                antwoord = "NEE";
            }

            Label lblVraag = new Label(vraagje.getVraag());
            model.getAlleVragenSpeler2().getVragen().remove(vraagje);
            lblVraag.setStyle("-fx-font-weight: 600; -fx-font-size: 20px;");
            wisselView.add(lblVraag, 2, 5, 2, 2);

            String loc = "/images/answers/yes.png";
            Knop knopje = new Knop(120, 120, loc, "Ja!");
            knopje.setContentDisplay(ContentDisplay.TOP);
            wisselView.getListPersonagesButtons().add(knopje);
            wisselView.add(knopje, 2, 8, 1, 1);


            loc = "/images/answers/no.png";
            knopje = new Knop(120, 120, loc, "Nee!");
            knopje.setContentDisplay(ContentDisplay.TOP);
            wisselView.getListPersonagesButtons().add(knopje);
            wisselView.add(knopje, 4, 8, 1, 1);

            addEventHandlers();
            set = true;
        }


    }

    private void showFinishedDialog() {
        Log.debug("showing finished");
        ChoiceDialog<String> again = new ChoiceDialog<String>("Ok", "Ok", "Nope");
        if (model.playerLostComputerGok()) {
            again.setTitle("You Lost!");
            again.setHeaderText("De computer heeft goed gegokt! De tegenstaander zijn personage was: " + model.getGekozenPersoonSpeler2().getNaam());
            again.setGraphic(new ImageView("/images/personages/" + model.getGekozenPersoonSpeler2().getNaam() + ".png"));
        } else {
            again.setTitle("You Won!");
            again.setGraphic(new ImageView("/images/answers/won.png"));
            again.setHeaderText("U hebt het spel gewonnen! De computer heeft slecht gegokt!");

        }
        again.setContentText("You wanna play again?");
        again.showAndWait();
        String result = again.getResult();
        if (result == null || result.equals("Nope")) {
            Platform.exit();
        } else {
            model = new MainModel();
            StartView startView = new StartView();
            StartPresenter startPresenter = new StartPresenter(model, startView);
            wisselView.getScene().setRoot(startView);
            startPresenter.addWindowEventHandlers();
            // Default width and height for the whole project
            startView.getScene().getWindow().setWidth(1020);
            startView.getScene().getWindow().setHeight(730);
        }
    }
}
