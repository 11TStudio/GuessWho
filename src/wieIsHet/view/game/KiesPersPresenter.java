package wieIsHet.view.game;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import wieIsHet.model.MainModel;

public class KiesPersPresenter {
    MainModel model;
    KiesView kiesView;

    public KiesPersPresenter(MainModel model, KiesView kiesView) {
        this.model = model;
        this.kiesView = kiesView;

        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {

        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
        kiesView.getPersonagesButtons().forEach(button -> {
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    model.getAllPersonagesSpeler1().getPersonages().forEach(personage -> {
                        if(button.getText().equals(personage.getNaam())) {
                            personage.setInActive(true);
                            button.setDisable(true);
                        }
                    });
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
