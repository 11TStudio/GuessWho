package wieIsHet.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import wieIsHet.model.HomePage;

public class Presenter {
    private HomePageView view;
    private HomePage model;

    public Presenter(HomePage model, HomePageView view) {
        this.view = view;
        this.model = model;
        addEventHandlers();
    }

    private void addEventHandlers() {
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

}
