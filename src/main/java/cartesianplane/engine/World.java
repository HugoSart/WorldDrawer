package cartesianplane.engine;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.*;

/**
 * User: hugo_<br/>
 * Date: 18/10/2017<br/>
 * Time: 19:04<br/>
 */
public class World {

    private Stage stage;

    private Coord origin = new Coord(0,0);

    private RealDraw renderDraw = null;

    public List<RealDraw> drawList = new LinkedList<>();

    public World() {
        this(new Stage());
    }

    public World(Stage stage) {
        this.stage = stage;
        Parent root = new Pane();
        root.setScaleY(-1);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void renderFrame() {
        clear();
        for (RealDraw realDraw : drawList) {
            renderDraw = realDraw;
            for (RelativeShape shape : realDraw.draw.getRelativeShapes())
                drawShape(shape);
        }
    }

    private void drawShape(RelativeShape shape) {
        adjustToOrigin(shape);
        getRootPane().getChildren().add(shape.shape);
    }

    public void add(Draw draw, Coord coord) {
        drawList.add(new RealDraw(draw, coord));
    }

    private Pane getRootPane() {
        return (Pane)stage.getScene().getRoot();
    }

    public Coord getOrigin() {
        return origin;
    }

    public void setOrigin(Coord coord) {
        origin = coord;
    }

    private void clear() {
        getRootPane().getChildren().clear();
    }

    private void adjustToOrigin(RelativeShape relativeShape) {
        relativeShape.shape.setLayoutX(relativeShape.shape.getLayoutX() + origin.getX() + renderDraw.coord.getX());
        relativeShape.shape.setLayoutY(relativeShape.shape.getLayoutY() + origin.getY() + renderDraw.coord.getY());
    }

    static class RealDraw {

        Draw draw;
        Coord coord;

        RealDraw(Draw draw, Coord coord) {
            this.draw = draw;
            this.coord = coord;
        }
    }

}
