package wieIsHet.view.help;

import javafx.scene.control.Alert;
import wieIsHet.model.Rules;
import wieIsHet.model.WieIsHetException;

public class HelpPresenter {
    public HelpPresenter(HelpView view) {
        try {
            view.getTaRules().setText(new Rules().getRules());
        } catch (WieIsHetException me) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(me.getMessage());
            alert.showAndWait();
        }
    }
}