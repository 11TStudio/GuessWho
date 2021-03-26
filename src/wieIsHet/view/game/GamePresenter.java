package wieIsHet.view.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.model.WieIsHetException;
import wieIsHet.view.about.AboutPresenter;
import wieIsHet.view.about.AboutView;
import wieIsHet.view.gok.GokPresenter;
import wieIsHet.view.gok.GokView;
import wieIsHet.view.help.HelpPresenter;
import wieIsHet.view.help.HelpView;
import wieIsHet.view.settings.SettingsPresenter;
import wieIsHet.view.settings.SettingsView;
import wieIsHet.view.start.StartPresenter;
import wieIsHet.view.start.StartView;
import wieIsHet.view.verwijder.VerwijderPersPresenter;
import wieIsHet.view.verwijder.VerwijderPersView;

public class GamePresenter {
    MainModel model;
    GameView gameView;
    ZoomPersView zoomPersView;
    RightSidebarView rightSidebarView;
    FooterView footerView;
    String gekozenPersonageSpeler1;
    int row = 0;
    int col = 0;
    boolean set=false;

    public GamePresenter(MainModel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.zoomPersView = gameView.getVerwijderView();
        this.rightSidebarView = gameView.getRightSidebarView();
        this.footerView = gameView.getFooterView();
        this.gekozenPersonageSpeler1 = model.getGekozenPersoonSpeler1().getNaam();


        this.addEventHandlers();
        this.updateView();
    }


    private void updateView() {
        // Vult de gameView met data uit model
        // TODO: Speler vs Speler logic
        if (model.gameFinished()) {
            showFinishedDialog();
        }
        // Wij zetten de gekozen personage hier vast.
        rightSidebarView.lblSpeler1Personage.setText(gekozenPersonageSpeler1);
        rightSidebarView.personageImg1.setImage(new Image("/images/personages/"+gekozenPersonageSpeler1+".png"));



        updatePersonages();
        updateVragen();
        // TODO: Score


    }



    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via gameView.getScene().getWindow()
        gameView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
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

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de gameView.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de gameView.
        addMenuEventHandlers();

        footerView.getGok().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GokView gokView = new GokView();
                GokPresenter gokPresenter = new GokPresenter(model, gokView);
                gameView.getScene().setRoot(gokView);
                gokPresenter.addWindowEventHandlers();
                // Default width and height for the whole project
                gokView.getScene().getWindow().setWidth(1020);
                gokView.getScene().getWindow().setHeight(730);
            }
        });

        footerView.getKiesVraag().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (model.getAlleVragenSpeler1().getGevraagdeVragen()==model.getAlleVragenSpeler1().getSize()) {
                    return;
                }
                Log.debug("De gekozen vraag is "+footerView.getCbVragen());
                // model.getAlleVragenSpeler1().getVragen().remove(i);
                model.getAlleVragenSpeler1().getVragen().forEach(vraag -> {
                    if(footerView.getCbVragen().equals(vraag.getVraag())){
                        vraag.setGevraagd(true);
                        ChoiceDialog<String> answer = new ChoiceDialog<String>("Ok", "Ok");
                        answer.setTitle("Antwoord voor: "+vraag.getVraag());
                        answer.setHeaderText("De tegenstaander zegt: "+(model.checkVraagSpeler1(vraag)? "JA!" : "NEEN!"));
                        answer.setGraphic(new ImageView("/images/answers/"+ (model.checkVraagSpeler1(vraag)? "yes" : "no") +".png"));
                        answer.setContentText("Je gaat nu personages mogen elimineren!");
                        answer.showAndWait();
                        String result = answer.getResult();
                        if(result==null || result.equals("Ok")) {

                            VerwijderPersView verwijderView = new VerwijderPersView();
                            VerwijderPersPresenter verwijderPresenter = new VerwijderPersPresenter(model, verwijderView);
                            gameView.getScene().setRoot(verwijderView);
                            verwijderPresenter.addWindowEventHandlers();
                            // Default width and height for the whole project
                            verwijderView.getScene().getWindow().setWidth(1020);
                            verwijderView.getScene().getWindow().setHeight(730);
                        }
                    }
                });
                updateView();
            }
        });


        zoomPersView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(model.isTurnSpeler1()) {
                        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                ChoiceDialog<String> zoom = new ChoiceDialog<String>("Ga terug", "Ga terug");
                                zoom.setTitle("Zoom versie van de personage.");
                                zoom.setHeaderText("Deze personage is: "+personage.getNaam());
                                zoom.setGraphic(new ImageView("/images/personages/"+personage.getNaam()+".png"));
                                zoom.showAndWait();
                            }
                        });
                    } else {
                        model.getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                ChoiceDialog<String> zoom = new ChoiceDialog<String>("Ga terug", "Ga terug");
                                zoom.setTitle("Zoom versie van de personage.");
                                zoom.setHeaderText("Deze personage is: "+personage.getNaam());
                                zoom.setGraphic(new ImageView("/images/personages/"+personage.getNaam()+".png"));
                                zoom.showAndWait();
                            }
                        });
                    }
                }
            });
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
                zoomPersView.getPersonagesButtons().add(knopje);
                if(row%5==0) {
                    col++;
                    row=0;
                }
                zoomPersView.add(knopje, row, col);
                row++;
            });
            set = true;
            addEventHandlers();
        }
    }

    private void updateVragen() {

        // Clear out de vragen zodat er geen dubbele komen
        footerView.vragen.clear();
        // Steek alle vragen die niet gevraagd zijn in den combobox
        model.getAlleVragenSpeler1().getVragen().forEach(vraag -> {
            if(!vraag.isGevraagd()){
                footerView.vragen.add(vraag.getVraag());
            }
        });
        // Maak den eerste item de selected as default
        footerView.cbVragen.getSelectionModel().select(0);
    }

    private void addMenuEventHandlers() {
        gameView.getMiExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        gameView.getMiAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutView aboutView = new AboutView();
                new AboutPresenter(model, aboutView);
                Stage aboutStage = new Stage();
                aboutStage.initOwner(gameView.getScene().getWindow());
                aboutStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(aboutView);
                scene.getStylesheets().add("/css/style.css");
                aboutStage.setScene(scene);
                aboutStage.setX(gameView.getScene().getWindow().getX());
                aboutStage.setY(gameView.getScene().getWindow().getY() + 100);
                aboutStage.showAndWait();
            }
        });
        gameView.getMiSave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    model.saveGame();
                } catch (WieIsHetException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unable to save:");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        });
        gameView.getMiLoad().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    model.loadGame();
                    GameView newView = new GameView(/*  TODO: model.getCombinationSize(), model.getMaxNumberOfGuesses() */);
                    gameView.getScene().setRoot(newView);
                    new GamePresenter(model, newView);
                    newView.getScene().getWindow().sizeToScene();
                } catch (WieIsHetException e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Unable to save:");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        });
        gameView.getMiRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HelpView helpView = new HelpView();
                new HelpPresenter(helpView);
                Stage helpStage = new Stage();
                helpStage.setTitle("Rules of the game");
                helpStage.initOwner(gameView.getScene().getWindow());
                helpStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(helpView);
                scene.getStylesheets().add("css/style.css");
                helpStage.setScene(scene);
                helpStage.setX(gameView.getScene().getWindow().getX());
                helpStage.setY(gameView.getScene().getWindow().getY() + 100);
                helpStage.showAndWait();
            }
        });
        gameView.getMiSettings().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingsView settingsView = new SettingsView();
                SettingsPresenter presenter = new SettingsPresenter(model, settingsView);
                Stage settingsStage = new Stage();
                settingsStage.setTitle("Settings");
                settingsStage.initOwner(gameView.getScene().getWindow());
                settingsStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(settingsView);
                scene.getStylesheets().add("css/style.css");
                settingsStage.setScene(scene);
                settingsStage.setX(gameView.getScene().getWindow().getX());
                settingsStage.setY(gameView.getScene().getWindow().getY() + 100);
                settingsStage.showAndWait();
                if (presenter.settingsChanged()) {
                    model.restart();
                    StartView startView = new StartView();
                    StartPresenter startPresenter = new StartPresenter(model, startView);
                    gameView.getScene().setRoot(startView);
                    startPresenter.addWindowEventHandlers();
                    // Default width and height for the whole project
                    startView.getScene().getWindow().setWidth(1020);
                    startView.getScene().getWindow().setHeight(730);
                    Log.debug("Settings are changed.");
                }
            }
        });
        gameView.getMiRestart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.restart();
                StartView startView = new StartView();
                StartPresenter startPresenter = new StartPresenter(model, startView);
                gameView.getScene().setRoot(startView);
                startPresenter.addWindowEventHandlers();
                // Default width and height for the whole project
                startView.getScene().getWindow().setWidth(1020);
                startView.getScene().getWindow().setHeight(730);
            }
        });
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
            if (model.getAllPersonagesSpeler1().getAantalOvergeblevenActivePersonages()==0) return;
            model.restart();
            StartView startView = new StartView();
            StartPresenter startPresenter = new StartPresenter(model, startView);
            gameView.getScene().setRoot(startView);
            startPresenter.addWindowEventHandlers();
            // Default width and height for the whole project
            startView.getScene().getWindow().setWidth(1020);
            startView.getScene().getWindow().setHeight(730);
        }
    }


}
