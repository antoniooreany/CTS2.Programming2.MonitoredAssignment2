package MA1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Group members : Rodion Danilenko, Anton Gorshkov, Henry Cela
public class Main extends Application {
    // Initialize constants
    private static final double TOP_INSET = 10;
    private static final double RIGHT_INSET = 10;
    private static final double BOTTOM_INSET = 10;
    private static final double LEFT_INSET = 10;
    private static final int COL_COUNT = 16;
    private static final int ROW_COUNT = 16;
    private static final double H_GAP = 2;
    private static final double V_GAP = 2;
    private static final double PIXEL_WIDTH = 20;
    private static final double PIXEL_HEIGHT = 20;
    private static final Color INIT_COLOR = Color.WHITE;
    private static final Color PAINT_COLOR = Color.BLACK;
    private static final String title = "Monitored Assignment1";

    // Override the start() method.
    public void start(Stage stage) {
        // Give the stage a title.
        stage.setTitle(title);
        // Create the GridPane.
        PaintPane paintPane = new PaintPane(COL_COUNT, ROW_COUNT, H_GAP, V_GAP, PIXEL_WIDTH, PIXEL_HEIGHT, INIT_COLOR, PAINT_COLOR);
        // Gaps at the outside borders
        paintPane.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));
        // Create a scene.
        Scene scene = new Scene(paintPane);
        // Handle a mouse press and drag event on the scene.
        scene.addEventHandler(MouseEvent.ANY, paintPane.getMouseEventHandler());
        // Set the scene on the stage.
        stage.setScene(scene);
        // the size of the stage match the size of the scene
        stage.sizeToScene();
        // the size of the stage set as not resizable
        stage.setResizable(false);
        // Show the stage and its scene.
        stage.show();
    }

    public static void main(String[] args) {
        // Start the JavaFX application by calling launch().
        launch(args);
    }
}
