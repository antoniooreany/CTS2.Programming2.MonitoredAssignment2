package Kratzer.JavaFXDemos;// Transform 2-D rectangles and circles.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.shape.*;

public class TransformShapesDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Transform 2-D Shapes");

        // Use a FlowPane for the root node. In this case,  
        // vertical and horizontal gaps of 40 are used. 
        FlowPane rootNode = new FlowPane(40, 40);

        // Center the controls in the scene.  
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 500, 200);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Create two equivalent rectanges. 
        Rectangle rectA = new Rectangle(100, 50);
        Rectangle rectB = new Rectangle(100, 50);

        // Rotate rectB 45 degrees around its center. 
        rectB.getTransforms().add(new Rotate(45, rectB.getWidth() / 2,
                rectB.getHeight() / 2));

        // Create two equivalent circles. 
        Circle circleA = new Circle(20);
        Circle circleB = new Circle(20);

        // Shear circleB by a factor 0.3 on the X axis. 
        circleB.getTransforms().add(new Shear(0.3, 0));

        // Add the rectangles and circles to the scene graph.  
        rootNode.getChildren().addAll(rectA, rectB, circleA, circleB);

        // Show the stage and its scene.  
        myStage.show();
    }
}
