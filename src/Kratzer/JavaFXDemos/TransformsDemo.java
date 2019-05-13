package Kratzer.JavaFXDemos;// Demonstrate rotation, scaling, translation, and shear.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.transform.*;

public class TransformsDemo extends Application {

    Shear shear;
    Rotate rotate;
    Scale scale;
    Translate translate;

    double angle = 0.0;
    double scaleFactor = 0.4;
    double xShearFactor = 0.0;

    boolean trans = true;

    Button btnRotate;
    Button btnScale;
    Button btnShear;
    Button btnTranslate;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Transforms Demo");

        // Use a FlowPane for the root node. In this case,  
        // vertical and horizontal gaps of 40 are used. 
        FlowPane rootNode = new FlowPane(40, 40);

        // Center the controls in the scene.  
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 500, 200);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Create transforms. 
        rotate = new Rotate();
        scale = new Scale(scaleFactor, scaleFactor);
        shear = new Shear();
        translate = new Translate();

        // Create transform push buttons.  
        btnRotate = new Button("Rotate");
        btnScale = new Button("Scale");
        btnShear = new Button("Shear");
        btnTranslate = new Button("Translate");

        // Add rotation to the transform list for the Rotate button. 
        btnRotate.getTransforms().add(rotate);

        // Add scaling to the transform list for the Scale button. 
        btnScale.getTransforms().add(scale);

        // Add shear to the transform list for the Shear button. 
        btnShear.getTransforms().add(shear);

        // Add translation to the transform list for the Translate button. 
        btnTranslate.getTransforms().add(translate);

        // Handle the action events for the Rotate button.  
        btnRotate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, it is rotated 15 degrees 
                // around its center. 
                angle += 15.0;

                rotate.setAngle(angle);
                rotate.setPivotX(btnRotate.getWidth() / 2);
                rotate.setPivotY(btnRotate.getHeight() / 2);
            }
        });

        // Handle the action events for the Scale button.  
        btnScale.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, the button's scale is changed. 
                scaleFactor += 0.1;
                if (scaleFactor > 2.0) {
                    scaleFactor = 0.4;
                }

                scale.setX(scaleFactor);
                scale.setY(scaleFactor);
            }
        });

        // Handle the action events for the Shear button.  
        btnShear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, the button's shear is changed. 
                xShearFactor += 0.1;
                if (xShearFactor > 2.0) {
                    xShearFactor = 0.0;
                }

                shear.setX(xShearFactor);
            }
        });

        // Handle the action events for the Translate button.  
        btnTranslate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                // Each time button is pressed, the button is moved. 
                if (trans) {
                    translate.setX(50);
                    translate.setY(50);
                } else {
                    translate.setX(0);
                    translate.setY(0);
                }

                // Flip the translation state. 
                trans = !trans;
            }
        });

        // Add the label and buttons to the scene graph.  
        rootNode.getChildren().addAll(btnRotate, btnScale, btnShear, btnTranslate);

        // Show the stage and its scene.  
        myStage.show();
    }
}
