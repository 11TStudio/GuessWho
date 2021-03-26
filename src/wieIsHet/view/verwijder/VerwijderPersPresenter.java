package wieIsHet.view.verwijder;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.WindowEvent;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.view.game.Knop;
import wieIsHet.view.start.StartPresenter;
import wieIsHet.view.start.StartView;
import wieIsHet.view.vraag.VraagPresenter;
import wieIsHet.view.vraag.VraagView;

public class VerwijderPersPresenter {
    MainModel model;
    VerwijderPersView verwijderPersView;
    int row = 0;
    int col = 0;
    boolean set = false;

    public VerwijderPersPresenter(MainModel model, VerwijderPersView verwijderPersView) {

        this.model = model;
        this.verwijderPersView = verwijderPersView;

        this.addEventHandlers();
        this.updateView();


    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        verwijderPersView.getBtnGaVerder().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (model.getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages() == 0) {
                    showFinishedDialog();
                } else {
                    VraagView vraagView = new VraagView();
                    VraagPresenter vraagPresenter = new VraagPresenter(model, vraagView);
                    verwijderPersView.getScene().setRoot(vraagView);
                    vraagPresenter.addWindowEventHandlers();
                    // Default width and height for the whole project
                    vraagView.getScene().getWindow().setWidth(1020);
                    vraagView.getScene().getWindow().setHeight(730);
                }
            }
        });

        verwijderPersView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if (model.isTurnSpeler1()) {
                        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                            if (button.getText().equals(personage.getNaam())) {
                                personage.setActive(false);
                                button.setDisable(true);
                                updateView();
                            }
                        });
                    } else {
                        model.getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                            if (button.getText().equals(personage.getNaam())) {
                                personage.setActive(false);
                                button.setDisable(true);
                                updateView();
                            }
                        });
                    }
                }
            });
        });
    }

    private void updateView() {

        // Vult de view met data uit model
        updatePersonages();

    }

    public void addWindowEventHandlers() {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
        verwijderPersView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
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

    private void updatePersonages() {

        if (!set) {
            model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                if (!personage.isActive()) return;

                String persoonNaam;

                persoonNaam = personage.getNaam();
                String loc = "/images/personages/" + persoonNaam + ".png";
                Knop knopje = new Knop(80, 80, loc, persoonNaam);
                GridPane.setHgrow(knopje, Priority.ALWAYS);
                GridPane.setHgrow(knopje, Priority.ALWAYS);
                // So we can add eventhandlers to all the buttons :P
                knopje.setContentDisplay(ContentDisplay.TOP);
                verwijderPersView.getPersonagesButtons().add(knopje);
                if (row % 5 == 0) {
                    col++;
                    row = 0;
                }
                verwijderPersView.add(knopje, row, col);
                row++;

            });
            addEventHandlers();
            set = true;
        }


    }

    private void showFinishedDialog() {
        Log.debug("showing finished");
        if (!model.gameFinished()) return;
        ChoiceDialog<String> again = new ChoiceDialog<String>("Ok", "Ok", "Nope");
        if (model.playerLost()) {
            again.setTitle("You Lost!");
            again.setHeaderText("U hebt verloren! De personage was: " + model.getGekozenPersoonSpeler2().getNaam());
            again.setGraphic(new ImageView("/images/personages/" + model.getGekozenPersoonSpeler2().getNaam() + ".png"));
        } else {
            again.setTitle("You Won!");
            again.setGraphic(new ImageView("/images/answers/won.png"));
            again.setHeaderText("U hebt het spel gewonnen!");
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
            verwijderPersView.getScene().setRoot(startView);
            startPresenter.addWindowEventHandlers();
            // Default width and height for the whole project
            startView.getScene().getWindow().setWidth(1020);
            startView.getScene().getWindow().setHeight(730);
        }
    }
}
