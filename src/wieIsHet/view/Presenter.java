package wieIsHet.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import wieIsHet.model.SimpelModel;

public class Presenter {
    private HomePageView view;
    private SimpelModel model;

    public Presenter(SimpelModel model, HomePageView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        // Koppelt event handlers(anon. innerklassen)
        // aan de controlsuit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.


        view.getBtnLeesVoor().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setHeaderText("Ik heb geen zin!");
//                alert.setTitle("Dictee");
//                alert.showAndWait();
                model.leesVoor();
                view.getTaDictee().setText(model.getTekst());
            }
        });
    }



    private void updateView() {
        // Vult de view met de data uit model

    }

}
