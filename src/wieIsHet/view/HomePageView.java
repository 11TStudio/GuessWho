package wieIsHet.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import wieIsHet.Main;

public class HomePageView extends BorderPane {

    private TextArea taDictee;
    private Button btnLeesVoor;


    public HomePageView() {
        setCenter(addGridPane());
        taDictee = new TextArea("bla bla");
        btnLeesVoor = new Button("Lees Voor");
    }

    public TextArea getTaDictee() {
        return taDictee;
    }

    public Button getBtnLeesVoor() {
        return btnLeesVoor;
    }


    public GridPane addGridPane() {
        GridPane grid = new GridPane();
        // Enkel voor DEBUG :)
        grid.setGridLinesVisible(true);
        grid.setHgap(50);
        grid.setVgap(35);
        grid.setPadding(new Insets(15, 15, 10, 15));

//        // Category in column 2, row 1
//        Text category = new Text("Sales:");
//        category.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        grid.add(category, 1, 0);
//
//        // Title in column 3, row 1
//        Text chartTitle = new Text("Current Year");
//        chartTitle.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        grid.add(chartTitle, 2, 0);
//
//        // Subtitle in columns 2-3, row 2
//        Text chartSubtitle = new Text("Goods and Services");
//        grid.add(chartSubtitle, 1, 1, 2, 1);
//        // House icon in column 1, rows 1-2
//        ImageView imageHouse = new ImageView(
//                new Image(Main.class.getResourceAsStream("images/house.png")));
//        grid.add(imageHouse, 0, 0, 1, 1);
//
//        // Left label in column 1 (bottom), row 3
//        Text goodsPercent = new Text("Goods\n80%");
//        GridPane.setValignment(goodsPercent, VPos.BOTTOM);
//        grid.add(goodsPercent, 0, 2);
//
//        // Chart in columns 2-3, row 3
//        ImageView imageChart = new ImageView(
//                new Image(Main.class.getResourceAsStream("images/piechart.png")));
//        grid.add(imageChart, 1, 2, 2, 1);
//
//        // Right label in column 4 (top), row 3
//        Text servicesPercent = new Text("Services\n20%");
//        GridPane.setValignment(servicesPercent, VPos.TOP);
//        grid.add(servicesPercent, 3, 2);

        int w = 0;
        for (int i = 0; i < 20; i++) {
            String img = "Person"+i;
            if (i%5==0) { w = 0; }
            if (i < 5) {
                ImageView image = new ImageView(
                new Image("/images/Person1.png"));
                grid.add(image, 0, 0+w, 1, 1);
            } else if (i >= 5 && i < 10) {
                ImageView image = new ImageView(
                        new Image("/images/Person1.png"));
                grid.add(image, 1, 0+w, 1, 1);
            } else if (i >= 10 && i < 15) {
                ImageView image = new ImageView(
                        new Image("/images/Person1.png"));
                grid.add(image, 2, 0+w, 1, 1);
            } else {
                ImageView image = new ImageView(
                        new Image("/images/Person1.png"));
                grid.add(image, 3, 0+w, 1, 1);
            }
            w++;
        }

        return grid;
    }

}
