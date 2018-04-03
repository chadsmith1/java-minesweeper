package cs2410.assn8.control;

/**
 * Created by chadsmith on 12/7/16.
 */
public class SpotOfCell {

    public Integer x;
    public Integer y;

    public void set(int x, int y) {

        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {

        return x.toString() + ", " + y.toString();
    }
}
