package cartesianplane;

import cartesianplane.engine.*;
import cartesianplane.engine.draw.Line;
import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * User: hugo_<br/>
 * Date: 18/10/2017<br/>
 * Time: 19:07<br/>
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        final World world = new World(primaryStage);
        world.setOrigin(new Coord(primaryStage.getWidth()/2,primaryStage.getHeight()/2));

        for (int i = 0; i < 360; i++) {
            Line line = new Line(300, i * 0.01);
            world.add(line, Coord.ORIGIN);
        }

        world.renderFrame();

        primaryStage.iconifiedProperty().addListener((observable, oldValue, newValue) -> world.renderFrame());
        primaryStage.maximizedProperty().addListener((observable, oldValue, newValue) -> world.renderFrame());

    }

}
