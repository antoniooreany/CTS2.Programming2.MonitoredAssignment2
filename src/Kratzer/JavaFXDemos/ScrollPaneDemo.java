package Kratzer.JavaFXDemos;// Demonstrate a scroll paintPane.
// This program scrolls the contents of a multi-line 
// label, but any other type of Node can be scrolled. 

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class ScrollPaneDemo extends Application {

    ScrollPane scrlPane;

    Button btnReset;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Demonstrate a ScrollPane");

        // Use a FlowPane for the root node. 
        FlowPane rootNode = new FlowPane(10, 10);

        // Center the controls in the scene. 
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 200, 200);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Create a label that will be scrolled. 
        Label scrlLabel = new Label(
                "ScrollPane streamlines the process of\n"
                + "adding scroll bars to a Node whose\n"
                + "contents exceed the allotted space.\n"
                + "It also enables a control to fit in a\n"
                + "smaller space than it otherwise would.\n"
                + "Because of its ease-of-use, ScrollPane\n"
                + "offers an elegant solution to a wide range\n"
                + "user interface design challenges.");

        // Create a scroll paintPane, setting scrlLabel as the content.
        scrlPane = new ScrollPane(scrlLabel);

        // Set the viewport width and height. 
        scrlPane.setPrefViewportWidth(130);
        scrlPane.setPrefViewportHeight(80);

        // Enable panning. 
        scrlPane.setPannable(true);

        // Create a reset button. 
        btnReset = new Button("Reset Scroll Bar Positions");

        // Handle action events for the reset button. 
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Set the scroll bars to their zero position. 
                scrlPane.setVvalue(0);
                scrlPane.setHvalue(0);
            }
        });

        // Add the scroll paintPane and button to the scene graph.
        rootNode.getChildren().addAll(scrlPane, btnReset);

        // Show the stage and its scene.  
        myStage.show();
    }
}
