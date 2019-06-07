package com.cts2.programming2.assignment2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;

// Group members : Rodion Danilenko, Anton Gorshkov, Henry Cela
//TODO Bug: when app starts, no info in the BarChart available. When mouse appears in the Scene, data appears in the BarChart.
//TODO Make the info available in the BarChart when app starts.
public class Main extends Application {
    // Initialize constants
    private static final String TITLE = "Monitored Assignment1";
    private static final int ROOT_NODE_SPACING = 10;
    // Gaps at the outside borders
    private static int ROOT_NODE_PADDINGS = 10;

//    public static Scene scene;

    // Override the start() method.
    public void start(Stage stage) {
        // Give the stage a TITLE.
        stage.setTitle(TITLE);
        // Create the major HBox.
        HBox rootNode = new HBox(ROOT_NODE_SPACING);
        // Create the GridPane.
        rootNode.setPadding(new Insets(ROOT_NODE_PADDINGS));
        PaintPane paintPane = new PaintPane();
        Controller controller = new Controller(paintPane);
        // Create a scene.
        Scene scene = new Scene(rootNode);
        // add "style.css"
        scene.getStylesheets().add((new File("./src/com/cts2/programming2/assignment2/style.css")).toURI().toString());
        // Create a scene.
        rootNode.getChildren().addAll(controller, paintPane);
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
