package cs2410.assn8.gui;

import javafx.event.EventHandler;
import static java.util.Collections.shuffle;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

/**
 * This is the class that puts together the Grid of cells. The format of the Cells/buttons
 * all comes from the "Cells" class, all of the cells created are placed into a grid of cells.
 *
 * @author chadsmith
 * @version KanyeWest
 */
public class CellGrid extends GridPane {

    private Cells cells;
    private Integer width;
    private Integer length;
    private Integer mineCount;
    private Integer cellCount;
    private Cells grid[][] = new Cells[20][20];
    private ArrayList<Cells> cellsArrayList = new ArrayList<>();

    public CellGrid(EventHandler event) {

        setUpGrid(event);
        displayMines();

        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(5,5,5,5));
    }

    /**
     * This section of code is to set up the grid, it first adds all of the cells to the callsArrayList
     * where afterwards it is shuffled and put into the grid.
     */
    private void setUpGrid(EventHandler event) {


        for (int n = 0; n < 300; n++) {

            cells = new Cells();
            cells.setOnMousePressed(event);
            cellsArrayList.add(cells);
        }

        for (int m = 0; m < 100; m++) {

            cells = new Cells();
            cells.setCellIsMine();
            cells.setOnMousePressed(event);
            cellsArrayList.add(cells);
        }

        shuffle(cellsArrayList);

        int totalCount = 0;

        for (int y = 0; y < 20; y++){

            for (int x = 0; x < 20; x++) {

                grid[x][y] = cellsArrayList.get(totalCount);
                grid[x][y].setCellPosition(x, y);
                this.add(cellsArrayList.get(totalCount), x, y);

                totalCount++;
            }
        }
    }
    private int countNeighborMines (int p, int q) {
        int neighborMine = 0;

        for (int x = p - 1; x < p + 2; x++) {

            for (int y = q - 1; y < q + 2; y++) {

                if (x >= 0 && x < 20 && y >= 0 && y < 20 && (x != p || y != q) && grid[x][y].getCellIsMine()){
                    neighborMine++;
                }
            }
        }
        return neighborMine;
    }

    public void displayMines() {

        for (int p = 0; p < 20; p++){

            for(int q = 0; q < 20; q++){

                grid[p][q].setNeighbors(countNeighborMines(p, q));
            }
        }
    }

    public Cells[][] getgrid() {
        return grid;
    }
}
