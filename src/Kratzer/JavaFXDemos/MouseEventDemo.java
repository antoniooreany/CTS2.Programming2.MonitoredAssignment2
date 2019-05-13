package Kratzer.JavaFXDemos;// Handle mouse events.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.input.*;

public class MouseEventDemo extends Application {

    Label showEvent;
    Label showLocation;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch(). 
        launch(args);
    }

    // Override the start() method. 
    public void start(Stage myStage) {

        // Give the stage a title. 
        myStage.setTitle("Handle Mouse Events");

        // Use a FlowPane for the root node. In this case, 
        // the horizontal gap is 10. 
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);

        // Center the controls in the scene. 
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene. 
        Scene myScene = new Scene(rootNode, 300, 100);

        // Set the scene on the stage. 
        myStage.setScene(myScene);

        // Create labels. 
        showEvent = new Label("Use the mouse.");
        showLocation = new Label("");

        // Handle a mouse click event on the scene. 
        myScene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                int clickcount = me.getClickCount();
                String times = "time";
                if (clickcount > 1) {
                    times += "s";
                }

                switch (me.getButton()) {
                    case PRIMARY:
                        showEvent.setText("Primary button clicked " + clickcount
                                + " " + times);
                        break;
                    case MIDDLE:
                        showEvent.setText("Middle button clicked " + clickcount
                                + " " + times);
                        break;
                    case SECONDARY:
                        showEvent.setText("Secondary button clicked " + clickcount
                                + " " + times);
                        break;
                }
            }
        });

        // Handle a mouse move event on the scene. 
        myScene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                showLocation.setText("Mouse at " + me.getSceneX() + ", "
                        + me.getSceneY());
            }
        });

        // Handle a mouse dragged event on the scene. 
        myScene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                showLocation.setText("Mouse (dragged) at " + me.getSceneX() + ", "
                        + me.getSceneY());
            }
        });

        // Add the labels to the scene graph. 
        rootNode.getChildren().addAll(showEvent, showLocation);

        // Show the stage and its scene. 
        myStage.show();
    }
}
