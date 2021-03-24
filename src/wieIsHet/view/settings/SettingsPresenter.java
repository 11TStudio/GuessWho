package wieIsHet.view.settings;

import javafx.application.Platform;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.ImageView;
import wieIsHet.Log;
import wieIsHet.model.MainModel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import wieIsHet.view.game.GamePresenter;
import wieIsHet.view.game.GameView;


public class SettingsPresenter {
    private MainModel model;
    private SettingsView view;
    private boolean settingsChanged = false;

    public SettingsPresenter(MainModel model, SettingsView view) {
        this.model = model;
        this.view = view;
        updateView();
        addEventHandlers();
    }

    private void updateView() {
        view.getCbAutoPickEnable().setSelected(model.getSettings().isCbAutoPickEnable());
    }

    private void addEventHandlers() {
        view.getBtnSave().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert areYouSure = new Alert(Alert.AlertType.WARNING);
                areYouSure.setContentText("This wil restart the game, are you sure?");
                areYouSure.showAndWait();
                String result = areYouSure.getResult().getText();
                if (result.equals("OK")) {
                    boolean selected = view.getCbAutoPickEnable().isSelected();
                    model.getSettings().setAutoPickEnable(selected);
                    view.getScene().getWindow().hide();
                    settingsChanged = true;
                }
            }
        });
    }

    public boolean settingsChanged() {
        return settingsChanged;
    }
}
