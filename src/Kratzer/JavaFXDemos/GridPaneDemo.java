package Kratzer.JavaFXDemos;// Demonstrate GridPane.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class GridPaneDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Demonstrate GridPane");

        // Create text fields and labels. 
        TextField tfName = new TextField();
        tfName.setMaxWidth(120);
        TextField tfPhone = new TextField();
        tfPhone.setMaxWidth(120);
        TextField tfEMail = new TextField();
        tfEMail.setMaxWidth(120);

        Label lblName = new Label("Enter your name:");
        Label lblPhone = new Label("Enter your phone number:");
        Label lblEMail = new Label("Enter e-mail address: ");

        // Create the GridPane. 
        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(10, 10, 10, 10)); // Gaps at the outside borders

        // Set vertical and horizontal gaps between controls. 
        rootNode.setVgap(10);
        rootNode.setHgap(20);

        // Add first column. 
        rootNode.add(lblName, 0, 0);
        rootNode.add(lblPhone, 0, 1);
        rootNode.add(lblEMail, 0, 2);

        // Add second column. 
        rootNode.add(tfName, 1, 0);
        rootNode.add(tfPhone, 1, 1);
        rootNode.add(tfEMail, 1, 2);

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 300, 120);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Show the stage and its scene.  
        myStage.show();
    }
}
