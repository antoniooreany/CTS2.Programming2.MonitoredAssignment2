package Kratzer.JavaFXDemos;// Demonstrate a TilePane.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class TilePaneDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Demonstrate TilePane");

        // Create a TilePane.  
        TilePane sqrsCubesPane = new TilePane(10, 10);

        // Add three labels that will act as column headings. 
        sqrsCubesPane.getChildren().add(new Label("Value"));
        sqrsCubesPane.getChildren().add(new Label("Square"));
        sqrsCubesPane.getChildren().add(new Label("Cube"));

        // Add labels that display a value, its square, and cube. 
        for (int i = 1; i < 10; i++) {
            sqrsCubesPane.getChildren().add(new Label(i + ""));
            sqrsCubesPane.getChildren().add(new Label(i * i + ""));
            sqrsCubesPane.getChildren().add(new Label(i * i * i + ""));
        }

        sqrsCubesPane.setPrefColumns(3);

        // Create the root node of the scene graph and add 
        // the tile pane to it. 
        FlowPane rootNode = new FlowPane();
        rootNode.getChildren().add(sqrsCubesPane);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 200, 280);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Show the stage and its scene.  
        myStage.show();
    }
}
