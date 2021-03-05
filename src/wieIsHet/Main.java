package wieIsHet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wieIsHet.model.MainModel;
import wieIsHet.view.start.StartPresenter;
import wieIsHet.view.start.StartView;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        StartView view = new StartView();
        Scene scene = new Scene(view);
        MainModel model = new MainModel();
        StartPresenter presenter = new StartPresenter(model, view);
        primaryStage.setTitle("Wie is Het - Hoofscherm");
        primaryStage.setResizable(true);
        primaryStage.setWidth(1020);
        primaryStage.setHeight(600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
