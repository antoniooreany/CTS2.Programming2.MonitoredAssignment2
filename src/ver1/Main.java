package ver1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static final String TITLE = "MA 2";
    public static final int COL_COUNT = 16;
    public static final int ROW_COUNT = 16;
    public static final double H_GAP = 2;
    public static final double V_GAP = 2;
    public static final double PIXEL_WIDTH = 40;
    public static final double PIXEL_HEIGHT = 40;
    public static final Color INIT_COLOR = Color.WHITE;
    public static final Color PAINT_COLOR = Color.BLACK;
    public static final double TOP_INSET = 10;
    public static final double RIGHT_INSET = 10;
    public static final double BOTTOM_INSET = 10;
    public static final double LEFT_INSET = 10;
    public static HBox rootNode;
    public static LeftSide leftSide;
    public static PaintPane rightSide;
    public Scene scene;
    //    public double[] iv = new double[]{110, 120, 130, 140, 150, 160, 170, 180};
    public static double[] iv;
    public static double[] ov; //TODO init this


    // Override the start() method.
    @Override
    public void start(Stage stage) {
        // Give the stage a title.
        stage.setTitle(TITLE);
        // Create the major HBox.
        rootNode = new HBox(10);

        // Create the GridPane.
        rightSide = new PaintPane(COL_COUNT, ROW_COUNT, H_GAP, V_GAP, //TODO NPE
                PIXEL_WIDTH, PIXEL_HEIGHT, INIT_COLOR, PAINT_COLOR);
        iv = rightSide.sequencePattern;
        // Gaps at the outside borders
        rightSide.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));

        ov = TXOR_Engine.run(iv); //TODO NPE
        // Create the ver1.LeftSide.
        leftSide = new LeftSide(ov);

        // Create a scene.
        scene = new Scene(rootNode);
        // Handle a mouse press and drag event on the scene.
        rightSide.addEventHandler(MouseEvent.ANY, rightSide.getMouseEventHandler());
        // Create a scene.
        rootNode.getChildren().addAll(leftSide, rightSide);
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
