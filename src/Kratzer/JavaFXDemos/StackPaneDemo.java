package Kratzer.JavaFXDemos;// Demonstrate StackPane.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class StackPaneDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Demonstrate StackPane");

        // Create a text field and two labels. 
        TextField tf = new TextField();
        tf.setMaxWidth(120);

        Label lblTop = new Label("Enter your name.");
        Label lblBottom = new Label("Name required for forum access.");

        // Create the StackPane. 
        StackPane rootNode = new StackPane();

        // By default, nodes are centered. The following aligns 
        // the labels to the top and bottom center. 
        StackPane.setAlignment(lblTop, Pos.TOP_CENTER);
        StackPane.setAlignment(lblBottom, Pos.BOTTOM_CENTER);

        // Add the labels and text field to the scene graph.  
        rootNode.getChildren().addAll(tf, lblTop, lblBottom);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 200, 120);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Show the stage and its scene.  
        myStage.show();
    }
}
