package cs2410.assn8.cell;

/**
 * Created by chadsmith on 12/7/16.
 */
public enum CellStatus {
    CELL("-fx-background-image: url('/data/cell.png'); -fx-background-size: stretch"),
    MINE("-fx-background-image: url('/data/mine.png'); -fx-background-size: stretch"),
    FLAGGED("-fx-background-image: url('/data/flagged.png'); -fx-background-size: stretch"),
    QUESTIONED("-fx-background-image: url('/data/question.png'); -fx-background-size: stretch"),
    UNMARKED("-fx-background-image: url('/data/unmark.png'); -fx-background-size: stretch"),
    CLEARED("-fx-background-image: url('/data/cleared.png'); -fx-background-size: stretch"),
    GOOD("-fx-background-image: url('/data/good.png'); -fx-background-size: stretch"),
    BAD("-fx-background-image: url('/data/bad.png'); -fx-background-size: stretch"),

    ONE("-fx-background-image: url('/data/one.png'); -fx-background-size: stretch"),
    TWO("-fx-background-image: url('/data/two.png'); -fx-background-size: stretch"),
    THREE("-fx-background-image: url('/data/three.png'); -fx-background-size: stretch"),
    FOUR("-fx-background-image: url('/data/four.png'); -fx-background-size: stretch"),
    FIVE("-fx-background-image: url('/data/five.png'); -fx-background-size: stretch"),
    SIX("-fx-background-image: url('/data/six.png'); -fx-background-size: stretch"),
    SEVEN("-fx-background-image: url('/data/seven.png'); -fx-background-size: stretch"),
    EIGHT("-fx-background-image: url('/data/eight.png'); -fx-background-size: stretch");



    private String cellStatus;

    CellStatus(String cellStyle){
        this.cellStatus = cellStyle;
    }
    public String getCellStatus() {
        return cellStatus;
    }
}