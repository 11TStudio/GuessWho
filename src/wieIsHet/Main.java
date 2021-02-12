package wieIsHet;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wieIsHet.model.HomePage;
import wieIsHet.view.HomePageView;
import wieIsHet.view.Presenter;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        String baard;
        String bril;
        String hoofddeksel;
        String snor;
        String kaal;

        boolean rondeComputer = false;

        String fixGeslacht = "";


        int lengteBeschikbaarPersonen = 0;

        boolean checkNaam = true;

        ArrayList<String> deletedPersonagesSpeler = new ArrayList<>();
        ArrayList<String> deletedPersonagesSpelerComputer = new ArrayList<>();

        boolean laatstePersoon = false;

        Personage gekozenPersonageObj = null;
        Personage gekozenCompPersonageObj = null;

        boolean spelActief = true;

        int aantalAskedQuestionSpeler = 0;
        int aantalAskedQuestionComputer = 0;

        int gekozenVraagSpeler = 0;
        int gekozenVraagComputer = 0;

        String gekozenPersonage = "";
        String gekozenPersonageComp = "";

        ArrayList<String> gevraagdeVragenSpeler = new ArrayList<>();
        ArrayList<String> gevraagdeVragenComputer = new ArrayList<>();


        ArrayList<String> vragenSpeler = new ArrayList<>();
        vragenSpeler.add("Is het een vrouw?");
        vragenSpeler.add("Draagt de persoon een bril?");
        vragenSpeler.add("Heeft je persoon blauwe ogen?");
        vragenSpeler.add("Heeft je persoon bruine ogen?");
        vragenSpeler.add("Heeft je persoon grijze ogen?");
        vragenSpeler.add("Heeft hij een baard?");
        vragenSpeler.add("Heeft hij een snor?");
        vragenSpeler.add("Is je persoon kaal?");
        vragenSpeler.add("Heeft je persoon blond haar?");
        vragenSpeler.add("Heeft je persoon zwart haar?");
        vragenSpeler.add("Heeft je persoon bruin haar?");
        vragenSpeler.add("Heeft je persoon iets op zijn hoofd?");

        ArrayList<String> vragenComputer = new ArrayList<>();
        vragenComputer.add("Is het een vrouw?");
        vragenComputer.add("Draagt de persoon een bril?");
        vragenComputer.add("Heeft je persoon blauwe ogen?");
        vragenComputer.add("Heeft je persoon bruine ogen?");
        vragenComputer.add("Heeft je persoon grijze ogen?");
        vragenComputer.add("Heeft hij een baard?");
        vragenComputer.add("Heeft hij een snor?");
        vragenComputer.add("Is je persoon kaal?");
        vragenComputer.add("Heeft je persoon blond haar?");
        vragenComputer.add("Heeft je persoon zwart haar?");
        vragenComputer.add("Heeft je persoon bruin haar?");
        vragenComputer.add("Heeft je persoon iets op zijn hoofd?");

        // Er moeten 20 personages zijn. Momenteel voor de console hebben we maar 12/ (Anders zijn er veel personages en op console versie is dat echt niet mooi.)
        // Maar de code is uitbereidbaar zonder moeite.
        Personage[][] spelRooster = new Personage[3][4];
        spelRooster[0][0] = new Personage("Levent", true, Personage.kleurOog.GRIJS, true, true, Personage.geslachtType.MAN, false, true, Personage.kleurHaar.ZWART);
        spelRooster[0][1] = new Personage("Liam", true, Personage.kleurOog.BLAUW, true, false, Personage.geslachtType.MAN, true, false, Personage.kleurHaar.BRUIN);
        spelRooster[0][2] = new Personage("Jan", false, Personage.kleurOog.BLAUW, false, false, Personage.geslachtType.MAN, true, true, Personage.kleurHaar.BLOND);
        spelRooster[0][3] = new Personage("Peter", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][0] = new Personage("Lise", false, Personage.kleurOog.BLAUW, true, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.ZWART);
        spelRooster[1][1] = new Personage("Kathleen", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.BRUIN);
        spelRooster[1][2] = new Personage("Sara", false, Personage.kleurOog.GRIJS, false, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.BLOND);
        spelRooster[1][3] = new Personage("Julie", false, Personage.kleurOog.BLAUW, true, false, Personage.geslachtType.VROUW, false, true, Personage.kleurHaar.ZWART);
        spelRooster[2][0] = new Personage("Michealle", false, Personage.kleurOog.BRUIN, false, false, Personage.geslachtType.VROUW, false, false, Personage.kleurHaar.BLOND);
        spelRooster[2][1] = new Personage("Joshua", true, Personage.kleurOog.GRIJS, false, true, Personage.geslachtType.MAN, false, true, Personage.kleurHaar.ZWART);
        spelRooster[2][2] = new Personage("Roy", false, Personage.kleurOog.BRUIN, true, false, Personage.geslachtType.MAN, true, true, Personage.kleurHaar.BLOND);
        spelRooster[2][3] = new Personage("Mathias", true, Personage.kleurOog.GRIJS, true, true, Personage.geslachtType.MAN, false, false, Personage.kleurHaar.ZWART);





        HomePageView view = new HomePageView();
        Scene scene = new Scene(view);
        HomePage model = new HomePage();
        Presenter presenter = new Presenter(model, view);
        primaryStage.setTitle("Test Wie Is Het FX");
        primaryStage.setResizable(true);
        primaryStage.setWidth(1020);
        primaryStage.setHeight(800);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
