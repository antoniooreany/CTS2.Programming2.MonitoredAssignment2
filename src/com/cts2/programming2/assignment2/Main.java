package com.cts2.programming2.assignment2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// Group members : Rodion Danilenko, Anton Gorshkov, Henry Cela
public class Main extends Application {
    // Initialize constants
    private static final String TITLE = "Monitored Assignment2";
    private static final int ROOT_NODE_SPACING = 10;
    private static final int ROOT_NODE_PADDING = 10;
    // Override the start() method.
    public void start(Stage stage) {
        // Give the stage a TITLE.
        stage.setTitle(TITLE);
        // Create the major HBox-container.
        HBox rootNode = new HBox(ROOT_NODE_SPACING);
        rootNode.setPadding(new Insets(ROOT_NODE_PADDING));
        // Create the GridPane-container for painting, with all the functionality for this.
        PaintPane paintPane = new PaintPane();
        // Create the VBox-container with buttons and chart, with all the functionality for this..
        Controller controller = new Controller(paintPane);
        // Create a scene.
        Scene scene = new Scene(rootNode);
        // add "style.css" from a compiled jar-file
        String css = Main.class.getResource("/style.css").toExternalForm();
        scene.getStylesheets().clear();
        scene.getStylesheets().add(css);
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
