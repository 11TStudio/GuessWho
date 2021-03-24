package wieIsHet.view.about;

import javafx.scene.control.Alert;
import wieIsHet.model.MainModel;
import wieIsHet.model.Rules;
import wieIsHet.model.WieIsHetException;

public class AboutPresenter {
    public AboutPresenter(MainModel model, AboutView view) {
        try {
            view.getTaRules().setText(new Rules().getRules());
        } catch (WieIsHetException me) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(me.getMessage());
            alert.showAndWait();
        }
    }
}