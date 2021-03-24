package wieIsHet.view.help;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

public class HelpView extends BorderPane {
    private TextArea taRules;

    public HelpView() {
        initialiseNodes ();
        layoutNodes();
    }

    private void initialiseNodes (){
        taRules = new TextArea();
        taRules.setPrefWidth(Double.MAX_VALUE);
        taRules.setPrefHeight(Double.MAX_VALUE);
        taRules.setWrapText(true);
        taRules.setFont(Font.font("Arial",12));
        taRules.setEditable(false);
    }

    private void layoutNodes() {
        setCenter(taRules);
        setPrefWidth(400);
        setPrefHeight(300);
    }

    TextArea getTaRules() {
        return taRules;
    }
}
