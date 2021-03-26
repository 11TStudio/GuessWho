package wieIsHet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import wieIsHet.model.MainModel;
import wieIsHet.view.start.StartView;
import wieIsHet.view.start.StartPresenter;


/**
 * Opstartklasse van de applicatie.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        StartView view = new StartView();
        Scene scene = new Scene(view);
        MainModel model = new MainModel();
        StartPresenter presenter = new StartPresenter(model, view);
        primaryStage.setTitle("Wie is Het");
        primaryStage.getIcons().add(new Image(("images/logo/logo.png")));
        primaryStage.setResizable(true);
        primaryStage.setWidth(1020);
        primaryStage.setHeight(730);
        primaryStage.setScene(scene);
        presenter.addWindowEventHandlers();
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
