package cartesianplane.engine;

/**
 * User: hugo_<br/>
 * Date: 18/10/2017<br/>
 * Time: 18:56<br/>
 */
public class Coord {

    public static final Coord ORIGIN = new Coord(0,0);

    private double x, y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "[" + getClass().getSimpleName() + "[x=" + x + ", y=" + y + "]]";
    }
}
