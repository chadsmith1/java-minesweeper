package cs2410.assn8.gui;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * This class is the scoreboard/tracker board for the game. It contains the mines that the user has yet to
 * distinguish. It also has the time since the game was started, and it contains the start button.
 *
 * @author chadsmith
 * @version KanyeWest
 */
public class ScoreBoard extends GridPane {

    private Label lb_TimeStandStill = new Label("Time: ");
    private Label lb_TimeRefreshed = new Label();
    private Label lb_MineStandStill = new Label("Mines: ");
    private Label lb_MinesRefreshed = new Label();

    private Integer time = 0;
    private IntegerProperty ip_Time = new SimpleIntegerProperty(time);

    private Integer minesLeft = 100;
    private IntegerProperty ip_MinesLeft = new SimpleIntegerProperty(minesLeft);

    private Button bt_Start = new Button("Reset Board");

    public ScoreBoard() {

        this.setAlignment(Pos.CENTER);
        this.setHgap(20);
        this.setPadding(new Insets(20));

        bt_Start.setPrefWidth(175);
        bt_Start.getStylesheets().addAll("file:css/custom.css");
        bt_Start.setId("start-button");

        lb_TimeRefreshed.textProperty().bind(ip_Time.asString());
        lb_MinesRefreshed.textProperty().bind(ip_MinesLeft.asString());

        lb_TimeStandStill.setStyle("-fx-font-size: 14");
        lb_TimeRefreshed.setStyle("-fx-font-size: 18");
        lb_MineStandStill.setStyle("-fx-font-size: 14");
        lb_MinesRefreshed.setStyle("-fx-font-size: 18");

        HBox time = new HBox(5, lb_TimeStandStill, lb_TimeRefreshed);
        HBox mines = new HBox(5, lb_MineStandStill, lb_MinesRefreshed);

        this.add(time, 1, 1);
        this.add(bt_Start, 2, 1);
        this.add(mines, 3, 1);
    }

    public void setActionBt_Start (EventHandler<ActionEvent> startEvent){

        bt_Start.setOnAction(startEvent);
    }

    public void setTime(){

        ip_Time.set(time++);
    }
    public Integer getTime() {
        return time;
    }

    public void setUsedMines(){

        ip_MinesLeft.setValue(minesLeft--);
    }

    public void setReplacedMines(){

        ip_MinesLeft.setValue(minesLeft++);
    }

    public Integer getMines () {

        return minesLeft;
    }


}
