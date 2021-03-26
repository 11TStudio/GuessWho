package wieIsHet.view.start;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.model.WieIsHetException;
import wieIsHet.view.about.AboutPresenter;
import wieIsHet.view.about.AboutView;
import wieIsHet.view.game.GamePresenter;
import wieIsHet.view.game.GameView;
import wieIsHet.view.help.HelpPresenter;
import wieIsHet.view.help.HelpView;
import wieIsHet.view.kies.KiesPersPresenter;
import wieIsHet.view.kies.KiesView;
import wieIsHet.view.settings.SettingsPresenter;
import wieIsHet.view.settings.SettingsView;

public class StartPresenter {
    final MainModel model;
    final StartView startView;
    boolean splashOn = true;

    public StartPresenter(
        MainModel model,
        StartView startView
                                ) {
        this.model = model;
        this.startView = startView;
        this.addEventHandlers();
        this.updateView();

    }

    private void addEventHandlers() {
        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        addMenuEventHandlers();
        startView.getButtonsView().getBtnsStartScherm().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    switch(button.getText()) {
                        case "Start PvP":
                            // TODO: model.setPVP(true)
                            // TODO: Een systeem om de views te veranderen per click.
                            Log.debug("User clicked to Start PvP button.");
//                            GameView gameView = new GameView();
//                            GamePresenter gamePresenter = new GamePresenter(model, gameView);
//                            startView.getScene().setRoot(gameView);
//                            gameView.getScene().getWindow().sizeToScene();
                            break;
                        case "Start PvC":
                            Log.debug("User clicked to Start PvC button.");
                            KiesView kiesView = new KiesView();
                            KiesPersPresenter kiesPersPresenter = new KiesPersPresenter(model, kiesView);
                            startView.getScene().setRoot(kiesView);
                            kiesPersPresenter.addWindowEventHandlers();
                            // Default width and height for the whole project
                            kiesView.getScene().getWindow().setWidth(1020);
                            kiesView.getScene().getWindow().setHeight(730);
                            Log.debug("Game mode set to PvC, game is running.");
                            break;
                        case "About Us":
                            Log.debug("User clicked to About Us button.");
                            AboutView aboutView = new AboutView();
                            new AboutPresenter(model, aboutView);
                            Stage aboutStage = new Stage();
                            aboutStage.initOwner(startView.getScene().getWindow());
                            aboutStage.initModality(Modality.APPLICATION_MODAL);
                            Scene scene = new Scene(aboutView);
                            scene.getStylesheets().add("/css/style.css");
                            aboutStage.setScene(scene);
                            aboutStage.setX(startView.getScene().getWindow().getX());
                            aboutStage.setY(startView.getScene().getWindow().getY() + 100);
                            aboutStage.showAndWait();
                            break;
                        default:
                            Log.debug("User clicked to Exit button.");
                            Platform.exit();
                    }
                }
            });
        });
    }

    private void addMenuEventHandlers() {
        startView.getMiExit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        startView.getMiAbout().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AboutView aboutView = new AboutView();
                new AboutPresenter(model, aboutView);
                Stage aboutStage = new Stage();
                aboutStage.initOwner(startView.getScene().getWindow());
                aboutStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(aboutView);
                scene.getStylesheets().add("/css/style.css");
                aboutStage.setScene(scene);
                aboutStage.setX(startView.getScene().getWindow().getX());
                aboutStage.setY(startView.getScene().getWindow().getY() + 100);
                aboutStage.showAndWait();
            }
        });
        startView.getMiSave().setOnAction(new EventHandler<ActionEvent>() {
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
        startView.getMiLoad().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    model.loadGame();
                    GameView newView = new GameView(/*  TODO: model.getCombinationSize(), model.getMaxNumberOfGuesses() */);
                    startView.getScene().setRoot(newView);
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
        startView.getMiRules().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HelpView helpView = new HelpView();
                new HelpPresenter(helpView);
                Stage helpStage = new Stage();
                helpStage.setTitle("Rules of the game");
                helpStage.initOwner(startView.getScene().getWindow());
                helpStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(helpView);
                scene.getStylesheets().add("css/style.css");
                helpStage.setScene(scene);
                helpStage.setX(startView.getScene().getWindow().getX());
                helpStage.setY(startView.getScene().getWindow().getY() + 100);
                helpStage.showAndWait();
            }
        });
        startView.getMiSettings().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SettingsView settingsView = new SettingsView();
                SettingsPresenter presenter = new SettingsPresenter(model, settingsView);
                Stage settingsStage = new Stage();
                settingsStage.setTitle("Settings");
                settingsStage.initOwner(startView.getScene().getWindow());
                settingsStage.initModality(Modality.APPLICATION_MODAL);
                Scene scene = new Scene(settingsView);
                scene.getStylesheets().add("css/style.css");
                settingsStage.setScene(scene);
                settingsStage.setX(startView.getScene().getWindow().getX());
                settingsStage.setY(startView.getScene().getWindow().getY() + 100);
                settingsStage.showAndWait();
                if (presenter.settingsChanged()) {
                    model.restart();
                    StartView startView = new StartView();
                    Log.debug("Settings are changed.");
                }
            }
        });
        startView.getMiRestart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                model.restart();
                Log.debug("New game started.");
            }
        });
    }


    private void updateView() {
        // Vult de view met data uit model
        // splash-screen


    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
        startView.getScene().getWindow().setOnCloseRequest(new EventHandler<WindowEvent>() {
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

    private void splashScreen() {
        splashOn = false;
    }

}

