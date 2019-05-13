package Kratzer.JavaFXDemos;// Demonstrate check boxes.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class CheckBoxDemo extends Application {

    private CheckBox cbKeyboard;
    private CheckBox cbMouse;
    private CheckBox cbTouchScreen;

    private Label response;
    private Label selected;

    private String inputDevices = "";

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch(). 
        launch(args);
    }

    // Override the start() method. 
    public void start(Stage myStage) {

        // Give the stage a title. 
        myStage.setTitle("Demonstrate Check Boxes");

        // Use a FlowPane for the root node. In this case, 
        // vertical gap of 10. 
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);

        // Center the controls vertically, left-align them horizontally. 
        rootNode.setAlignment(Pos.CENTER_LEFT);

        // Set a padding value of 10 on the left for the flow pane. 
        rootNode.setPadding(new Insets(0, 0, 0, 10));

        // Create a scene. 
        Scene myScene = new Scene(rootNode, 300, 180);

        // Set the scene on the stage. 
        myStage.setScene(myScene);

        Label heading = new Label("Select Input Devices");

        // Create a label that will report the state of the 
        // selected check box. 
        response = new Label("No Devices Selected");

        // Create a label that will report all input devices selected. 
        selected = new Label("Supported devices: <none>");

        // Create the check boxes. 
        cbKeyboard = new CheckBox("Keyboard");
        cbMouse = new CheckBox("Mouse");
        cbTouchScreen = new CheckBox("Touch Screen");

        // Handle action events for the check boxes. 
        cbKeyboard.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if (cbKeyboard.isSelected()) {
                    response.setText("Keyboard selected.");
                } else {
                    response.setText("Keyboard cleared.");
                }

                showAll();
            }
        });

        cbMouse.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if (cbMouse.isSelected()) {
                    response.setText("Mouse selected.");
                } else {
                    response.setText("Mouse cleared.");
                }

                showAll();
            }
        });

        cbTouchScreen.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if (cbTouchScreen.isSelected()) {
                    response.setText("Touch Screen selected.");
                } else {
                    response.setText("Touch Screen cleared.");
                }

                showAll();
            }
        });

        // Add controls to the scene graph. 
        rootNode.getChildren().addAll(heading, cbKeyboard, cbMouse,
                cbTouchScreen, response, selected);

        // Show the stage and its scene. 
        myStage.show();
    }

    // Update and show the input devices list. 
    private void showAll() {
        inputDevices = "";

        // Use isSelected() to determine the state of the check boxes. 
        if (cbKeyboard.isSelected()) {
            inputDevices = "Keyboard ";
        }
        if (cbMouse.isSelected()) {
            inputDevices += "Mouse ";
        }
        if (cbTouchScreen.isSelected()) {
            inputDevices += "Touch Screen";
        }

        if (inputDevices.equals("")) {
            inputDevices = "<none>";
        }

        selected.setText("Supported devices: " + inputDevices);
    }
}
