package cartesianplane.engine;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

/**
 * User: hugo_<br/>
 * Date: 18/10/2017<br/>
 * Time: 21:45<br/>
 */
public abstract class Draw {

    private Color color = Color.BLACK;
    private double strokeWidth = 0.2;

    private RelativeShape[] relativeShapes;

    public Draw() {
        relativeShapes = relativeShapes();
    }

    private RelativeShape[] relativeShapes() {
        RelativeShape[] shapes = relativeShapesArrangement();
        for (RelativeShape shape : shapes) {
            shape.shape.setFill(color);
            shape.shape.setStroke(color);
            shape.shape.setStrokeWidth(strokeWidth);
        }
        return shapes;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public double getStrokeWidth() {
        return strokeWidth;
    }

    public void setStrokeWidth(double strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public RelativeShape[] getRelativeShapes() {
        return relativeShapes();
    }

    protected abstract RelativeShape[] relativeShapesArrangement();

}
