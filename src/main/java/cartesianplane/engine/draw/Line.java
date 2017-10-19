package cartesianplane.engine.draw;

import cartesianplane.engine.Coord;
import cartesianplane.engine.Draw;
import cartesianplane.engine.RelativeShape;
import javafx.scene.shape.Shape;

/**
 * User: hugo_<br/>
 * Date: 18/10/2017<br/>
 * Time: 18:59<br/>
 */
public class Line extends Draw {

    private double size = 0.0;
    private double angle = 0.0;

    public Line(double size, double angle) {
        this.size = size;
        this.angle = angle;
    }

    @Override
    public RelativeShape[] relativeShapesArrangement() {

        javafx.scene.shape.Line line = new javafx.scene.shape.Line();
        line.setStartX(0);
        line.setStartY(0);

        double hipotenusa = size, catetoOposto, catetoAdjacente;
        catetoOposto = Math.sin(Math.toRadians(angle)) * hipotenusa;
        catetoAdjacente = Math.cos(Math.toRadians(angle)) * hipotenusa;

        line.setEndX(catetoAdjacente);
        line.setEndY(catetoOposto);

        RelativeShape[] shapes = new RelativeShape[1];
        shapes[0] = new RelativeShape(line, new Coord(0,0));
        return shapes;

    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }
}
