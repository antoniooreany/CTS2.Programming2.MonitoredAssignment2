package Kratzer.JavaFXDemos;// Demonstrate a text field.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class TextFieldDemo extends Application {

    TextField tf;
    Label response;

    Button btnGetText;
    Button btnReverse;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch(). 
        launch(args);
    }

    // Override the start() method. 
    public void start(Stage myStage) {

        // Give the stage a title. 
        myStage.setTitle("Demonstrate a TextField");

        // Use a FlowPane for the root node. In this case, 
        // vertical and horizontal gaps of 10. 
        FlowPane rootNode = new FlowPane(10, 10);

        // Center the controls in the scene. 
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene. 
        Scene myScene = new Scene(rootNode, 230, 140);

        // Set the scene on the stage. 
        myStage.setScene(myScene);
        
        // Create a label that will display the string. 
        response = new Label("String: ");

        // Create button that gets the text. 
        btnGetText = new Button("Get String");

        // Create button that reverses the text. 
        btnReverse = new Button("Reverse");

        // Create a text field 
        tf = new TextField();

        // Set the prompt. 
        tf.setPromptText("Enter a String");

        // Set preferred column count. 
        tf.setPrefColumnCount(15);

        // Handle action events for the text field. Action 
        // events are generated when ENTER is pressed while 
        // the text field has input focus. In this case, the 
        // text in the field is obtained and displayed. 
        tf.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("String: " + tf.getText());
            }
        });

        // Get text from the text field when the button is pressed 
        // and display it. 
        btnGetText.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("String: " + tf.getText());
            }
        });

        // Get text from the text field when the button is pressed, 
        // reverse it using a StringBuilder, and then display it. 
        btnReverse.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                StringBuilder str = new StringBuilder(tf.getText());
                tf.setText(str.reverse().toString());
            }
        });

        // Use a separator to better organize the layout. 
        Separator separator = new Separator();
        separator.setPrefWidth(200);

        // Add controls to the scene graph. 
        rootNode.getChildren().addAll(tf, btnGetText, btnReverse,
                separator, response);

        // Show the stage and its scene. 
        myStage.show();
    }
}
