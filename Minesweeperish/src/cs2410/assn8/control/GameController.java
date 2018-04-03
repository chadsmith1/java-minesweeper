package cs2410.assn8.control;

import cs2410.assn8.cell.CellStatus;
import cs2410.assn8.gui.CellGrid;
import cs2410.assn8.gui.Cells;
import cs2410.assn8.gui.GameMenuBar;
import cs2410.assn8.gui.ScoreBoard;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.util.Timer;
import java.util.TimerTask;

/**
 * This class is the class that contains all of the action events for the game. This class contains the timer, and.....
 * This class also is a BorderPane. The top part of the pane is set for the Scoreboard, and the middle part of the pane
 * is set for the grid of cells.
 *
 */
public class GameController extends BorderPane {

    private EventHandler<MouseEvent> eventEventHandler = event -> cellClicked(event.getButton(), (Cells) event.getSource());
    private Timer gameTimer;
    private ScoreBoard scoreBoard;
    private Cells cells[][] = new Cells[20][20];
    private CellGrid cellGrid;
    private Integer clearedCells;
    private GameMenuBar gameMenuBar = new GameMenuBar();

    public GameController() {
        setGridPane();
    }

    public void closeTimer() {
        gameTimer.cancel();
    }

    private void setGridPane() {

        clearedCells = 0;
        gameTimer = new Timer();
        scoreBoard = new ScoreBoard();
        cellGrid = new CellGrid(eventEventHandler);
        cells = cellGrid.getgrid();

        this.setTop(gameMenuBar);
        this.setCenter(scoreBoard);
        this.setBottom(cellGrid);

        actionBt_Start();

    }

    private void actionBt_Start() {
        scoreBoard.setActionBt_Start(event ->
                setGridPane()
        );
    }

    private void cellClicked(MouseButton btn, Cells cells) {

        if (clearedCells == 0 && (btn == MouseButton.PRIMARY || btn == MouseButton.SECONDARY)) {

            startTimer();
        }

        if (!cells.getCellIsPressed()){

            if (btn == MouseButton.PRIMARY) {

                if (!cells.getCellIsFlagged() && !cells.getCellIsQuestioned() && !cells.getCellIsMine()){
                    cells.setCellStyle(cells.getNeighbors());
                    clearedCells++;
                    win();
                    setNeighbors(cells.getSpotOfCell().x, cells.getSpotOfCell().y);
                }
                if (cells.getCellIsMine()){
                    lose();
                }
            }

            if (btn == MouseButton.SECONDARY) {

                if (!cells.getCellIsFlagged() && !cells.getCellIsQuestioned()) {
                    cells.setCellIsFlagged();
                    cells.setStyle(CellStatus.FLAGGED.getCellStatus());
                    scoreBoard.setUsedMines();
                } else if (cells.getCellIsFlagged()) {
                    cells.setCellIsQuestioned();
                    cells.setStyle(CellStatus.QUESTIONED.getCellStatus());

                } else if (cells.getCellIsQuestioned()) {
                    cells.setCellIsPressed();
                    scoreBoard.setReplacedMines();
                    cells.setStyle(CellStatus.CELL.getCellStatus());
                }
            }
        }
    }

private void setNeighbors(int x, int y){
        if (cells[x][y].getNeighbors() !=0) {
            return;
        }

    if (x >= 0 && x < 19 && y >= 0 && y < 20 && !cells[x + 1][y].getCellIsMine()){
        cellClicked(MouseButton.PRIMARY, cells[x + 1][y]);
    }
    if (x > 0 && x < 20 && y >= 0 && y < 20 && !cells[x - 1][y].getCellIsMine()){
        cellClicked(MouseButton.PRIMARY, cells[x - 1][y]);
    }
    if (x >= 0 && x < 20 && y >= 0 && y < 19 && !cells[x][y + 1].getCellIsMine()){
        cellClicked(MouseButton.PRIMARY, cells[x][y + 1]);
    }
    if (x >= 0 && x < 20 && y > 0 && y < 20 && !cells[x][y- 1].getCellIsMine()){
        cellClicked(MouseButton.PRIMARY, cells[x][y - 1]);
    }
}
    private void startTimer() {
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        scoreBoard.setTime();
                    }
                });
            }
        },0, 1000);
    }

    private void lose() {
        gameTimer.cancel();

        for (int y= 0; y < 20; y++){

            for(int x = 0; x < 20; x++){
                cells[x][y].setCellIsPressed();
                if (cells[x][y].getCellIsMine() && (cells[x][y].getCellIsFlagged() || cells[x][y].getCellIsFlagged())) {
                    cells[x][y].setStyle(CellStatus.GOOD.getCellStatus());
                }
                if (cells[x][y].getCellIsMine() && (!cells[x][y].getCellIsFlagged() || !cells[x][y].getCellIsFlagged())) {
                    cells[x][y].setStyle(CellStatus.UNMARKED.getCellStatus());
                }
                if (!cells[x][y].getCellIsMine() && (cells[x][y].getCellIsFlagged() || cells[x][y].getCellIsFlagged())) {
                    cells[x][y].setStyle(CellStatus.BAD.getCellStatus());
                }
            }
        }

        ImageView wImage = new ImageView("file:data/youlost.png");
        wImage.setFitWidth(150);
        wImage.setPreserveRatio(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("YOU DON'T FEEL LIKE PABLO");
        alert.showAndWait();
        alert.setGraphic(wImage);
        alert.setContentText(" whoopee you lost in " + scoreBoard.getTime().toString() + " seconds.");

    }


    private void win() {
        if (clearedCells == 300){
            winner();
        }
    }

    private void winner() {
        gameTimer.cancel();

        for (int y= 0; y < 20; y++){
            for(int x = 0; x < 20; x++){
                cells[x][y].setCellIsPressed();
                if (cells[x][y].getCellIsMine()){
                    cells[x][y].setStyle(CellStatus.GOOD.getCellStatus());
                }
            }
        }

        ImageView wImage = new ImageView("file:data/win.jpg");
        wImage.setFitWidth(150);
        wImage.setPreserveRatio(true);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("I FEEL LIKE PABLO");
        alert.showAndWait();
        alert.setGraphic(wImage);
        alert.setContentText(" whoopee you won in " + scoreBoard.getTime().toString() + " seconds.");

    }

}
