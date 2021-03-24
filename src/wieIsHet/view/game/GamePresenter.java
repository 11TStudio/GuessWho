package wieIsHet.view.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.model.WieIsHetException;
import wieIsHet.view.about.AboutPresenter;
import wieIsHet.view.about.AboutView;
import wieIsHet.view.help.HelpPresenter;
import wieIsHet.view.help.HelpView;
import wieIsHet.view.kies.KiesPersPresenter;
import wieIsHet.view.kies.KiesView;
import wieIsHet.view.settings.SettingsPresenter;
import wieIsHet.view.settings.SettingsView;
import wieIsHet.view.start.StartPresenter;
import wieIsHet.view.start.StartView;

public class GamePresenter {
    MainModel model;
    GameView gameView;
    VerwijderPersView verwijderPersView;
    RightSidebarView rightSidebarView;
    FooterView footerView;
    String gekozenPersonageSpeler1;

    public GamePresenter(MainModel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.verwijderPersView = gameView.getVerwijderView();
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
        updateVragen();
        System.out.println("DEBUG LEVENT");
        // TODO: Score


    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via gameView.getScene().getWindow()

    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de gameView.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de gameView.
        addMenuEventHandlers();

        footerView.getKiesVraag().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Log.debug("De gekozen vraag is "+footerView.getCbVragen());
                for (int i = 0; i < model.getAlleVragenSpeler1().getVragen().size(); i++) {
                    if(footerView.getCbVragen().equals(model.getAlleVragenSpeler1().getVragen().get(i).getVraag())){
                        model.getAlleVragenSpeler1().getVragen().remove(i);
                        footerView.removeVraag(model.getAlleVragenSpeler1().getVragen().get(i).getVraag());
                    }
                }
                updateView();
                System.out.println("DEBUG AMQ "+model.getAlleVragenSpeler1().getVragen().size());
            }
        });

        verwijderPersView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(model.isTurnSpeler1()) {
                        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                personage.setInActive(true);
                                button.setDisable(true);
                                Log.debug("Aantal disabled personages: "+model.getSizeDeletedPersonagesSpeler1());
                                updateView();
                            }
                        });
                    } else {
                        model.getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                personage.setInActive(true);
                                button.setDisable(true);
                                updateView();
                            }
                        });
                    }
                }
            });
        });
    }

    private void updateVragen() {
        System.out.println("DEBUG SIZE AFTER UPDATEVRAGEN: "+model.getAlleVragenSpeler1().getVragen().size());
        // Steek alle vragen die niet gevraagd zijn in den combobox
        model.getAlleVragenSpeler1().getVragen().forEach(vraag -> {
            if(!vraag.isGevraagd()){
                footerView.vragen.add(vraag.getVraag());
            }
        });
        // Maak den eerste item de selected as default
        footerView.cbVragen.getSelectionModel().select(0);
        System.out.println(model.getAlleVragenSpeler1().getVragenOver());
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
                    // Default width and height for the whole project
                    startView.getScene().getWindow().setWidth(1020);
                    startView.getScene().getWindow().setHeight(650);
                    System.out.println(presenter.settingsChanged());
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
                // Default width and height for the whole project
                startView.getScene().getWindow().setWidth(1020);
                startView.getScene().getWindow().setHeight(650);
            }
        });
    }

    private void showFinishedDialog() {
        Log.debug("showing finished");
        if (!model.gameFinished()) return;
        ChoiceDialog<String> again = new ChoiceDialog<String>("Ok", "Ok", "Nope");
        if (model.playerLost()) {
            again.setTitle("You Lost!");
            again.setHeaderText("The correct combination was:");
        } else {
            again.setTitle("You Won!");
            // TODO: again.setGraphic(new ImageView("/images/duim.png"));
            // TODO: again.setHeaderText("You found it in " + model.getNumberOfGuessesDone() + " moves...");
        }
        again.setContentText("You wanna play again?");
        again.showAndWait();
        String result = again.getResult();
        if (result == null || result.equals("Nope")) {
            Platform.exit();
        } else {
            this.model = new MainModel();
            KiesView kiesView = new KiesView();
            KiesPersPresenter kiesPersPresenter = new KiesPersPresenter(model, kiesView);
            gameView.getScene().setRoot(kiesView);
            // Default width and height for the whole project
            kiesView.getScene().getWindow().setWidth(1020);
            kiesView.getScene().getWindow().setHeight(650);
        }
    }


}
