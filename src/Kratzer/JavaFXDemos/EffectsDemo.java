package Kratzer.JavaFXDemos;// Demonstrate BoxBlur, Glow, and Reflection.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.effect.*;

public class EffectsDemo extends Application {

    double blurVal = 1.0;
    double glowVal = 0.0;

    Reflection reflection;
    BoxBlur blur;
    Glow glow;

    Button btnBlur;
    Button btnGlow;
    ; 
 
  Label reflect;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Effects Demo");

        // Use a FlowPane for the root node. In this case,  
        // vertical and horizontal gaps of 20 are used. 
        FlowPane rootNode = new FlowPane(20, 20);

        // Center the controls in the scene.  
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 340, 120);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Create the effects. 
        reflection = new Reflection();
        blur = new BoxBlur(1.0, 1.0, 1);
        glow = new Glow(0.0);

        // Create push buttons.  
        btnBlur = new Button("Blur off");
        btnGlow = new Button("Glow");

        // Set the blur and glow effects. 
        btnGlow.setEffect(glow);
        btnBlur.setEffect(blur);

        // Create the reflection label. 
        reflect = new Label("Reflection Adds Visual Sparkle");

        // Set the reflection effect on the reflection label. 
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        reflect.setEffect(reflection);

        // Handle the action events for the Blur button. 
        btnBlur.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, its blur status is changed. 
                if (blurVal == 10.0) {
                    blurVal = 1.0;
                    btnBlur.setText("Blur off");
                } else {
                    blurVal++;
                    btnBlur.setText("Blur on");
                }
                // Set the blur rectangle to the new dimensions. 
                blur.setWidth(blurVal);
                blur.setHeight(blurVal);
            }
        });

        // Handle the action events for the Glow button.  
        btnGlow.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, its glow value is changed. 
                glowVal += 0.1;
                if (glowVal > 1.0) {
                    glowVal = 0.0;
                }

                // Set the new glow value. 
                glow.setLevel(glowVal);
            }
        });

        // Add the label and buttons to the scene graph.  
        rootNode.getChildren().addAll(btnBlur, btnGlow, reflect);

        // Show the stage and its scene.  
        myStage.show();
    }
}
