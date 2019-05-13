package Kratzer.JavaFXDemos;// Demonstrate a choice box.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class ChoiceBoxDemo extends Application {

    Label response;

    ChoiceBox<String> cbApple;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch(). 
        launch(args);
    }

    // Override the start() method. 
    public void start(Stage myStage) {

        // Give the stage a title. 
        myStage.setTitle("ChoiceBox Demo");

        // Use a FlowPane for the root node. In this case, 
        // vertical and horizontal gaps of 10. 
        FlowPane rootNode = new FlowPane(10, 10);

        // Center the controls in the scene. 
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene. 
        Scene myScene = new Scene(rootNode, 220, 140);

        // Set the scene on the stage. 
        myStage.setScene(myScene);

        // Create a label. 
        response = new Label("Select Your Apple");

        // Create an ObservableList of entries for the choice box. 
        ObservableList<String> appleType
                = FXCollections.observableArrayList("Winesap", "Cortland", "Gala",
                        "Golden Delicious", "Fuji",
                        "Jonathan");

        // Create the choice box. 
        cbApple = new ChoiceBox<String>(appleType);

        // Set the initial selection. 
        cbApple.setValue("Winesap");

        // Get the choice box selection model. 
        SingleSelectionModel<String> cbSelModel
                = cbApple.getSelectionModel();

        // Use a change listener to watch for changes to the selection. 
        cbSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> changed,
                    String oldVal, String newVal) {
                response.setText("Selected apple: " + newVal);
            }
        });

        // Add the label and choice box to the scene graph. 
        rootNode.getChildren().addAll(cbApple, response);

        // Show the stage and its scene. 
        myStage.show();
    }
}
