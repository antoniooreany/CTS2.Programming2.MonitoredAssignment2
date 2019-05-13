package Kratzer.JavaFXDemos;// Demonstrate a simple scene graph that contains a label.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class MultipleChildrenDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch(). 
        launch(args);
    }

    // Override the start() method. 
    public void start(Stage myStage) {

        // Give the stage a title. 
        myStage.setTitle("Demonstrate A Simple Scene Graph");

        // Use a FlowPane for the root node. 
        FlowPane rootNode = new FlowPane();

        // Create a scene. 
        Scene myScene = new Scene(rootNode, 300, 200);

        // Set the scene on the stage. 
        myStage.setScene(myScene);

        // Create a label. 
        Label myLabel = new Label("Label One  ");

        // Create a second label. 
        Label myLabel2 = new Label("Label Two  ");

        // Create a third label. 
        Label myLabel3 = new Label("Label Three");

        // Add three labels to the scene graph. 
        rootNode.getChildren().add(myLabel);
        rootNode.getChildren().add(myLabel2);
        rootNode.getChildren().add(myLabel3);

        // Show the stage and its scene. 
        myStage.show();
    }

}
