package Kratzer.JavaFXDemos;// Demonstrate BorderPane.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class BorderPaneDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().  
        launch(args);
    }

    // Override the start() method.  
    public void start(Stage myStage) {

        // Give the stage a title.  
        myStage.setTitle("Demonstrate BorderPane");

        // Use a BorderPane  
        BorderPane rootNode = new BorderPane();

        // Create a scene.  
        Scene myScene = new Scene(rootNode, 340, 200);

        // Set the scene on the stage.  
        myStage.setScene(myScene);

        // Create controls and put them into the five BorderPane locations. 
        // Center 
        TextField tfCenter = new TextField("This text field is in the center");
        BorderPane.setAlignment(tfCenter, Pos.CENTER);
        rootNode.setCenter(tfCenter);

        // Right 
        Slider sldrRight = new Slider(0.0, 100.0, 50.0);
        sldrRight.setOrientation(Orientation.VERTICAL);
        sldrRight.setPrefWidth(60);
        sldrRight.setShowTickLabels(true);
        sldrRight.setShowTickMarks(true);
        BorderPane.setAlignment(sldrRight, Pos.CENTER);
        rootNode.setRight(sldrRight);

        // Left 
        Button btnAlpha = new Button("Alpha");
        Button btnBeta = new Button("Beta");
        Button btnGamma = new Button("Gamma");
        btnAlpha.setPrefWidth(60);
        btnBeta.setPrefWidth(60);
        btnGamma.setPrefWidth(60);

        Label vbLabel = new Label("Vbox on left");

        VBox vbLeft = new VBox(10);
        vbLeft.getChildren().addAll(vbLabel, btnAlpha, btnBeta, btnGamma);
        vbLeft.setAlignment(Pos.CENTER);
        rootNode.setLeft(vbLeft);
        BorderPane.setAlignment(vbLeft, Pos.CENTER);

        // Set margin for left location. 
        BorderPane.setMargin(vbLeft, new Insets(10, 10, 10, 10));

        // Top 
        Label lblTop = new Label("This label is displayed along the top.");
        BorderPane.setAlignment(lblTop, Pos.CENTER);
        rootNode.setTop(lblTop);

        // Bottom 
        Label lblBottom
                = new Label("This label is displayed along the bottom.");
        BorderPane.setAlignment(lblBottom, Pos.CENTER);
        rootNode.setBottom(lblBottom);

        // Show the stage and its scene.  
        myStage.show();
    }
}
