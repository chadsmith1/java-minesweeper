package cs2410.assn8.gui;

import cs2410.assn8.cell.CellStatus;
import cs2410.assn8.control.SpotOfCell;
import javafx.scene.control.Button;

/**
 * This class constructs the cells that are placed into the grid. This class also contains the getters
 * and setters for the buttons.
 *
 * @author chadsmith
 * @version KanyeWest
 */
public class Cells extends Button {

    private boolean cellIsPressed = false;
    private boolean cellIsMine = false;
    private boolean cellIsFlagged = false;
    private boolean cellIsQuestioned = false;

    private int neighbors = 0;
    private SpotOfCell spotOfCell = new SpotOfCell();

    public Cells() {
        setPrefSize(30, 30);
        setStyle(CellStatus.CELL.getCellStatus());
    }

    /**
     * This next section of code are the getters & setters for the booleans in order to
     * mark each cell with that specific boolean that the user has placed onto it. It also
     * sets the cell's location and gets the cell's location.
     *
     */
    public void setCellPosition (int x, int y) {

        spotOfCell.set(x, y);
    }

    public SpotOfCell getSpotOfCell() {
        return spotOfCell;
    }

    public void setCellIsMine () {

        cellIsMine = true;
    }

    public boolean getCellIsMine() {

        return cellIsMine;
    }

    public void setCellIsFlagged() {

        cellIsFlagged = true;
    }

    public boolean getCellIsFlagged() {

        return cellIsFlagged;
    }

    public void setNeighbors(int neighbors) {

        this.neighbors = neighbors;
    }

    public Integer getNeighbors() {

        return neighbors;
    }

    public void setCellIsQuestioned() {

        cellIsQuestioned = true;
    }

    public boolean getCellIsQuestioned() {

        return cellIsQuestioned;
    }

    public void setCellIsPressed() {

        cellIsPressed = true;
    }

    public boolean getCellIsPressed() {

        return cellIsPressed;
    }

    public void setCellStyle(Integer minesCount) {

        setCellIsPressed();

        switch(minesCount) {

            case 0:
                setStyle(CellStatus.CLEARED.getCellStatus());
                break;

            case 1:
                setStyle(CellStatus.ONE.getCellStatus());
                break;

            case 2:
                setStyle(CellStatus.TWO.getCellStatus());
                break;

            case 3:
                setStyle(CellStatus.THREE.getCellStatus());
                break;

            case 4:
                setStyle(CellStatus.FOUR.getCellStatus());
                break;

            case 5:
                setStyle(CellStatus.FIVE.getCellStatus());
                break;

            case 6:
                setStyle(CellStatus.SIX.getCellStatus());
                break;

            case 7:
                setStyle(CellStatus.SEVEN.getCellStatus());
                break;

            case 8:
                setStyle(CellStatus.EIGHT.getCellStatus());
                break;
        }
    }

    public String toString() {

        return spotOfCell.toString();
    }
}
