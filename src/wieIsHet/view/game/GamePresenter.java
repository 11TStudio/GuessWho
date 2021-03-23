package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.stage.WindowEvent;
import wieIsHet.model.MainModel;

public class GamePresenter {
    MainModel model;
    GameView gameView;
    RosterView rosterView;
    VerwijderPersView verwijderPersView;
    RightSidebarView rightSidebarView;
    String gekozenPersonageSpeler1;

    public GamePresenter(MainModel model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        this.rosterView = gameView.getPersonageView();
        this.verwijderPersView = gameView.getVerwijderView();
        this.rightSidebarView = gameView.getRightSidebarView();
        this.gekozenPersonageSpeler1 = model.getGekozenPersoonSpeler1().getNaam();

        // Wij zetten deze hier vast.
        rightSidebarView.lblSpeler1Personage.setText(gekozenPersonageSpeler1);
        rightSidebarView.personageImg1.setImage(new Image("/images/personages/"+gekozenPersonageSpeler1+".png"));
        // TODO: Score

        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        verwijderPersView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    if(model.isTurnSpeler1()) {
                        model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                personage.setInActive(true);
                                button.setDisable(true);
                            }
                        });
                    } else {
                        model.getAllPersonagesSpeler2().getPersonages().forEach(personage -> {
                            if(button.getText().equals(personage.getNaam())) {
                                personage.setInActive(true);
                                button.setDisable(true);
                            }
                        });
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
