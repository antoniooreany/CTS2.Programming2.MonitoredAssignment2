package com.cts2.programming2.assignment2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

// Group members : Rodion Danilenko, Anton Gorshkov, Henry Cela
//TODO Bug: when app starts, no info in the BarChart available. When mouse appears in the Scene, data appears in the BarChart.
//TODO Make the info available in the BarChart when app starts.
public class Main extends Application {
    // Initialize constants
    private static final int ROOT_NODE_SPACING = 10;
    private static final double TOP_INSET = 10;
    private static final double RIGHT_INSET = 10;
    private static final double BOTTOM_INSET = 10;
    private static final double LEFT_INSET = 10;
    static final int COL_COUNT = 16;
    static final int ROW_COUNT = 16;
    private static final double H_GAP = 2;
    private static final double V_GAP = 2;
    private static final double PIXEL_WIDTH = 40;
    private static final double PIXEL_HEIGHT = 40;
    private static final Color INIT_COLOR = Color.WHITE;
    private static final Color PAINT_COLOR = Color.BLACK;
    private static final String TITLE = "Monitored Assignment1";

    public static HBox rootNode;
    static RightPane rightPane;
    static LeftPane leftPane;
    public static Scene scene;

    // Override the start() method.
    public void start(Stage stage) {
        // Give the stage a TITLE.
        stage.setTitle(TITLE);
        // Create the major HBox.
        rootNode = new HBox(ROOT_NODE_SPACING);
        // Create the GridPane.
        rightPane = new RightPane(COL_COUNT, ROW_COUNT, H_GAP, V_GAP, PIXEL_WIDTH, PIXEL_HEIGHT, INIT_COLOR, PAINT_COLOR);
        // Gaps at the outside borders
        rightPane.setPadding(new Insets(TOP_INSET, RIGHT_INSET, BOTTOM_INSET, LEFT_INSET));
        leftPane = new LeftPane();
        leftPane.setMaxSize(300,90000);
        // Create a scene.
        scene = new Scene(rootNode);
        // Handle a mouse press and drag event on the scene.
//        rightPane.addEventHandler(MouseEvent.ANY, rightPane.getMouseEventHandler()); //TODO Move this statement into the constructor of the RightPane?
        // Create a scene.
        rootNode.getChildren().addAll(leftPane, rightPane);
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
