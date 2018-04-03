package cs2410.assn8.gui;

import cs2410.assn8.control.GameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Scene mainScene;

    private GameController mainPane;

    @Override
    public void start(Stage primaryStage) throws Exception{

        mainPane = new GameController();
        mainScene = new Scene(mainPane, 800, 800);
        mainScene.getStylesheets().addAll("file:css/custom.css");
        primaryStage.setScene(mainScene);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Assignment 8 Minesweeperish");
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> mainPane.closeTimer());
    }
}
