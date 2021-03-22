package wieIsHet.view.start;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import wieIsHet.model.MainModel;
import wieIsHet.view.game.KiesPersPresenter;
import wieIsHet.view.game.KiesView;

public class StartPresenter {
    final MainModel model;
    final StartView startView;
    KiesView kiesView;

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
                            kiesView.getScene().getWindow().sizeToScene();
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
    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }

}

