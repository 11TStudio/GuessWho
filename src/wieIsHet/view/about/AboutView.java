package wieIsHet.view.about;

import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

/**
 * De view voor de about
 * Toont de about ons text.
 *
 * @author LeventHAN
 */
public class AboutView extends BorderPane {
    private TextArea taRules;

    public AboutView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        taRules = new TextArea();
        taRules.setPrefWidth(Double.MAX_VALUE);
        taRules.setPrefHeight(Double.MAX_VALUE);
        taRules.setWrapText(true);
        taRules.setFont(Font.font("Arial", 12));
        taRules.setEditable(false);
    }

    private void layoutNodes() {
        setCenter(taRules);
        setPrefWidth(600);
        setPrefHeight(600);
    }

    TextArea getTaRules() {
        return taRules;
    }
}
