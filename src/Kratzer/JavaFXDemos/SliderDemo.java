package Kratzer.JavaFXDemos;// Demonstrate a Slider

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.beans.value.*;

public class SliderDemo extends Application {

    Slider sldrHorz;
    Slider sldrVert;

    Button btnReset;

    Label lblValueHorz;
    Label lblValueVert;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Demonstrate a Slider");

        // Use a FlowPane for the root node. 
        FlowPane rootNode = new FlowPane(10, 10);

        // Center the controls in the scene. 
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 250, 250);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Create labels that will show the slider values. 
        lblValueHorz = new Label("Horizontal value: ");
        lblValueVert = new Label("Vertical value: ");

        // Create horizontal slider. 
        sldrHorz = new Slider(0.0, 10.0, 0.0);

        // Configure the horizontal slider. 
        sldrHorz.setShowTickMarks(true);
        sldrHorz.setShowTickLabels(true);
        sldrHorz.setBlockIncrement(1.0);
        sldrHorz.setSnapToTicks(true);
        sldrHorz.setMajorTickUnit(5.0);
        sldrHorz.setMinorTickCount(4);

        // Create vertical slider. 
        sldrVert = new Slider(0.0, 20.0, 10.0);
        sldrVert.setOrientation(Orientation.VERTICAL);

        // Configure the vertical slider. 
        sldrVert.setShowTickMarks(true);
        sldrVert.setShowTickLabels(true);
        sldrVert.setBlockIncrement(2.0);
        sldrVert.setSnapToTicks(true);
        sldrVert.setMajorTickUnit(4.0);
        sldrVert.setMinorTickCount(3);

        // Create the reset button. 
        btnReset = new Button("Reset Sliders");

        // Handle action events for the button. 
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                sldrHorz.setValue(0.0);
                sldrVert.setValue(10.0);
            }
        });

        // Handle change events on the slider's value. 
        sldrHorz.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed,
                    Number oldVal, Number newVal) {

                // Display the slider's current value.  
                lblValueHorz.setText("Current value is " + newVal.intValue());
            }
        });

        sldrVert.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> changed,
                    Number oldVal, Number newVal) {

                // Display the slider's current value.  
                lblValueVert.setText("Current value is " + newVal.intValue());
            }
        });

        // Add the sliders, label, and button to the scene graph.  
        rootNode.getChildren().addAll(sldrHorz, sldrVert, lblValueHorz,
                lblValueVert, btnReset);

        // Show the stage and its scene.  
        myStage.show();
    }
}
