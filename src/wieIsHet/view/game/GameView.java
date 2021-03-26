package wieIsHet.view.game;


import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

/**
 * De game view is waar de meeste spel draait.
 * Hier worden 3 views samen gebracht.
 * Namelijk de Footer, Side en Zoom.
 *
 * @author LeventHAN
 */

public class GameView extends BorderPane {
    private ZoomPersView verwijderView;
    private FooterView footer;
    private RightSidebarView rightSidebar;
    private MenuItem miExit;
    private MenuItem miRestart;
    private MenuItem miSave;
    private MenuItem miLoad;
    private MenuItem miSettings;
    private MenuItem miAbout;
    private MenuItem miRules;

    public GameView() {
        this.initialiseNodes();
        this.layoutNodes();

    }

    private void initialiseNodes() {
        footer = new FooterView();
        verwijderView = new ZoomPersView();
        rightSidebar = new RightSidebarView();
        //menu
        miExit = new MenuItem("Exit");
        miAbout = new MenuItem("About");
        miRules = new MenuItem("Rules");
        miSettings = new MenuItem("Settings");
        miSave = new MenuItem("Save");
        miLoad = new MenuItem("Load");
        miRestart = new MenuItem("Restart");
    }


    private void layoutNodes() {


        Menu menuGame = new Menu("Game", null, miSettings, miSave, miLoad, new SeparatorMenuItem(), miRestart, miExit);
        Menu menuHelp = new Menu("Help", null, miRules, miAbout);
        MenuBar menuBar = new MenuBar(menuGame, menuHelp);
        setTop(menuBar);

        setBottom(footer);
        setCenter(verwijderView);
        setRight(rightSidebar);


    }

    /**
     * Getter voor de zoom view zodat we zijn methodes kunnen raken in onze presenter.
     *
     * @return ZoomPersView
     * @author LeventHAN
     */
    public ZoomPersView getVerwijderView() {
        return verwijderView;
    }

    /**
     * Getter voor de rıghst sıdebar view zodat we zijn methodes kunnen raken in onze presenter.
     *
     * @return RightSidebarView
     * @author LeventHAN
     */
    public RightSidebarView getRightSidebarView() {
        return rightSidebar;
    }

    /**
     * Getter voor de footer view zodat we zijn methodes kunnen raken in onze presenter.
     *
     * @return FooterView
     * @author LeventHAN
     */
    public FooterView getFooterView() {
        return footer;
    }

    /**
     * Getter voor de menu ıtem EXIT zodat we de button kunnen callen in onze presenter.
     *
     * @return miExit
     * @author LeventHAN
     */
    public MenuItem getMiExit() {
        return miExit;
    }

    /**
     * Getter voor de menu ıtem restart zodat we de button kunnen callen in onze presenter.
     *
     * @return miRestart
     * @author LeventHAN
     */
    public MenuItem getMiRestart() {
        return miRestart;
    }

    /**
     * Getter voor de menu ıtem save zodat we de button kunnen callen in onze presenter.
     *
     * @return miSave
     * @author LeventHAN
     */
    public MenuItem getMiSave() {
        return miSave;
    }

    /**
     * Getter voor de menu ıtem load zodat we de button kunnen callen in onze presenter.
     *
     * @return miLoad
     * @author LeventHAN
     */
    public MenuItem getMiLoad() {
        return miLoad;
    }

    /**
     * Getter voor de menu ıtem settıngs zodat we de button kunnen callen in onze presenter.
     *
     * @return miSettings
     * @author LeventHAN
     */
    public MenuItem getMiSettings() {
        return miSettings;
    }

    /**
     * Getter voor de menu ıtem about zodat we de button kunnen callen in onze presenter.
     *
     * @return miAbout
     * @author LeventHAN
     */
    public MenuItem getMiAbout() {
        return miAbout;
    }

    /**
     * Getter voor de menu ıtem rules zodat we de button kunnen callen in onze presenter.
     *
     * @return miRules
     * @author LeventHAN
     */
    public MenuItem getMiRules() {
        return miRules;
    }

}
