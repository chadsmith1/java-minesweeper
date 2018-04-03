package cs2410.assn8.gui;

import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

/**
 * Created by chadsmith on 12/9/16.
 */
public class GameMenuBar extends MenuBar {

    private Menu setting;
    private Menu sizeMenu;
    private MenuItem size10;
    private MenuItem size25;
    private MenuItem size50;

    public GameMenuBar(){

        sizeMenu = new Menu();
        sizeMenu.setText("Size");

        size10 = new MenuItem("10 x 10");
        //size10.setOnAction(event);
        size25 = new MenuItem("25 x 25");
        //size25.setOnAction(event);
        size50 = new MenuItem("50 x 50");
        //size50.setOnAction(event);

        sizeMenu.getItems().addAll(size10, size25, size50);

        setting = new Menu();
        setting.setText("Settings");
        setting.getItems().addAll(sizeMenu);

        getMenus().addAll(setting);

    }


}
