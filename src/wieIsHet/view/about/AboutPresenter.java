package wieIsHet.view.about;

import wieIsHet.model.SimpelModel;
import wieIsHet.view.game.GamePresenter;

public class AboutPresenter {
    private SimpelModel model;
    private AboutPresenter view;

    public AboutPresenter(
            SimpelModel model,
            AboutPresenter view
    ) {
        this.model = model;
        this.view = view;
        this.addEventHandlers();
        this.updateView();
    }

    private void addEventHandlers() {
        // Koppelt event handlers (anon. inner klassen)
        // aan de controls uit de view.
        // Event handlers: roepen methodes aan uit het
        // model en zorgen voor een update van de view.
    }

    private void updateView() {
        // Vult de view met data uit model
    }

    public void addWindowEventHandlers() {
        // Window event handlers (anon. inner klassen)
        // Koppeling via view.getScene().getWindow()
    }
}
