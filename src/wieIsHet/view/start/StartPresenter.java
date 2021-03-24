package wieIsHet.view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import wieIsHet.Log;
import wieIsHet.model.MainModel;
import wieIsHet.view.kies.KiesPersPresenter;
import wieIsHet.view.kies.KiesView;

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

        startView.getButtonsView().getBtnsStartScherm().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    switch(button.getText()) {
                        case "Start PvP":
                            // TODO: model.setPVP(true)
                            // TODO: Een systeem om de views te veranderen per click.
                            System.out.println("Clicked on Start PvP");
//                            GameView gameView = new GameView();
//                            GamePresenter gamePresenter = new GamePresenter(model, gameView);
//                            startView.getScene().setRoot(gameView);
//                            gameView.getScene().getWindow().sizeToScene();
                            break;
                        case "Start PvC":
                            System.out.println("Clicked on Start PvC");
                            KiesView kiesView = new KiesView();
                            KiesPersPresenter kiesPersPresenter = new KiesPersPresenter(model, kiesView);
                            startView.getScene().setRoot(kiesView);
                            // Default width and height for the whole project
                            kiesView.getScene().getWindow().setWidth(1020);
                            kiesView.getScene().getWindow().setHeight(650);
                            break;
                        case "About Us":
                            System.out.println("Clicked on About Us");
//                            GameView gameView = new GameView();
//                            GamePresenter gamePresenter = new GamePresenter(model, gameView);
//                            startView.getScene().setRoot(gameView);
//                            gameView.getScene().getWindow().sizeToScene();
                            break;
                        default:
                            System.out.println("Clicked on Exit");
//                            GameView gameView = new GameView();
//                            GamePresenter gamePresenter = new GamePresenter(model, gameView);
//                            startView.getScene().setRoot(gameView);
//                            gameView.getScene().getWindow().sizeToScene();
                    }
                }
            });
        });
    }

    private void updateView() {
        // Vult de view met data uit model
        // splash-screen


    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }

    private void splashScreen() {
        splashOn = false;
    }

}

