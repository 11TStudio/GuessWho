package wieIsHet.view.settings;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;

public class SettingsView extends VBox {
    private CheckBox cbAutoPickEnable;
    private Button btnSave;


    public SettingsView() {
        initialiseNodes ();
        layoutNodes();
    }
    private void initialiseNodes() {
        cbAutoPickEnable = new CheckBox("Kies te raden persoon automatisch.");
        btnSave = new Button("Save");
    }

    private void layoutNodes() {
        getChildren().addAll(cbAutoPickEnable, btnSave);
        setSpacing(10);
        setPadding(new Insets(10));
    }

    Button getBtnSave() {
        return btnSave;
    }

    CheckBox getCbAutoPickEnable() {
        return cbAutoPickEnable;
    }
}