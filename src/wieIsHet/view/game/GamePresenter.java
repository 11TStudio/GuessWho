package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import wieIsHet.model.MainModel;
import wieIsHet.model.Personages;

public class GamePresenter {
    MainModel model;
    GameView gameView;
    RosterView rosterView;

    public GamePresenter(MainModel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.rosterView = gameView.getRooster();

        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        for (int i = 0; i < model.getSizePersonages(); i++) {
            final int fix_i=i;
            rosterView.getPersonagesButtons().get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    // Hier komt de naam.
                    model.setPersonageSpeler(rosterView.getPersonagesButtons().get(fix_i).getText());
                }
            });
        }



    }

    private void updateView() {
        // Vult de view met data uit model

    }

    public void addWindowEventHandlers () {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
