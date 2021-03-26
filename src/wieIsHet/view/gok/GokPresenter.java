package wieIsHet.view.gok;

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

public class GokPresenter {
    MainModel model;
    GokView gokView;
    int row = 0;
    int col = 0;
    boolean set=false;

    public GokPresenter(MainModel model, GokView gokView) {

        this.model = model;
        this.gokView = gokView;

        this.addEventHandlers();
        this.updateView();



    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.

        gokView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(model.isTurnSpeler1()) {
                        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                model.setFoundItSpeler1(model.getGekozenPersoonSpeler2().getNaam().equals(personage.getNaam()));
                                model.setWrongGokSpeler1(!model.getGekozenPersoonSpeler2().getNaam().equals(personage.getNaam()));
                                model.gameFinished();
                                showFinishedDialog();
                                updateView();
                            }
                        });
                    } else {
                        model.getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                model.setFoundItSpeler1(model.getGekozenPersoonSpeler1().equals(personage));
                                showFinishedDialog();
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

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
        gokView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
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

    private void updatePersonages() {

        if(!set){
            model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                if(!personage.isActive()) return;

                String persoonNaam;

                persoonNaam = personage.getNaam();
                String loc = "/images/personages/"+persoonNaam+".png";
                Knop knopje = new Knop(80,80,loc,persoonNaam);
                GridPane.setHgrow(knopje, Priority.ALWAYS);
                GridPane.setHgrow(knopje, Priority.ALWAYS);
                // So we can add eventhandlers to all the buttons :P
                knopje.setContentDisplay(ContentDisplay.TOP);
                gokView.getPersonagesButtons().add(knopje);
                if(row%5==0) {
                    col++;
                    row=0;
                }
                gokView.add(knopje, row, col);
                row++;

            });
            addEventHandlers();
            set=true;
        }


    }

    private void showFinishedDialog() {
        Log.debug("showing finished");
        if (!model.gameFinished()) return;
        ChoiceDialog<String> again = new ChoiceDialog<String>("Ok", "Ok", "Nope");
        if (model.playerLost()) {
            again.setTitle("You Lost!");
            again.setHeaderText("U hebt verloren! De personage was: "+model.getGekozenPersoonSpeler2().getNaam());
            again.setGraphic(new ImageView("/images/personages/"+model.getGekozenPersoonSpeler2().getNaam()+".png"));
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
            gokView.getScene().setRoot(startView);
            startPresenter.addWindowEventHandlers();
            // Default width and height for the whole project
            startView.getScene().getWindow().setWidth(1020);
            startView.getScene().getWindow().setHeight(730);
        }
    }
}