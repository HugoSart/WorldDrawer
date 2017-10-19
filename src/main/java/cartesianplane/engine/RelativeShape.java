package cartesianplane.engine;

import javafx.scene.shape.Shape;

/**
 * User: hugo_<br/>
 * Date: 18/10/2017<br/>
 * Time: 23:40<br/>
 */
public class RelativeShape {

    Shape shape;
    Coord coord;

    public RelativeShape(Shape shape, Coord coord) {
        this.shape = shape;
        this.coord = coord;
    }

}
