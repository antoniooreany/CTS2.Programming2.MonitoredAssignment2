package Kratzer.JavaFXDemos;// Demonstrate ListView.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class ListViewDemo extends Application {

    Label response;

    ListView<String> lvApple;

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch(). 
        launch(args);
    }

    // Override the start() method. 
    public void start(Stage myStage) {

        // Give the stage a title. 
        myStage.setTitle("ListView Demo");

        // Use a FlowPane for the root node. In this case, 
        // vertical and horizontal gaps of 10. 
        FlowPane rootNode = new FlowPane(10, 10);

        // Center the controls in the scene. 
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene. 
        Scene myScene = new Scene(rootNode, 400, 340);

        // Set the scene on the stage. 
        myStage.setScene(myScene);

        // Create a label. 
        response = new Label("Select Your Apple");

        // Create an ObservableList of entries for the list view. 
        ObservableList<String> appleTypes
                = FXCollections.observableArrayList("Winesap", "Cortland", "Gala",
                        "Golden Delicious", "Fuji",
                        "Jonathan");

        // Create the list view. 
        lvApple = new ListView<String>(appleTypes.sorted());

        // Set the preferred height and width. 
        lvApple.setPrefSize(280, 280);

        // Get the list view selection model. 
        MultipleSelectionModel<String> lvSelModel
                = lvApple.getSelectionModel();

        // Use a change listener to respond to a change of selection within 
        // a list view. 
        lvSelModel.selectedItemProperty().addListener(
                new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> changed,
                    String oldVal, String newVal) {

                // Display the selection. 
                response.setText("Apple selected is " + newVal);
            }
        });

        // Add the label and list view to the scene graph. 
        rootNode.getChildren().addAll(lvApple, response);

        // Show the stage and its scene. 
        myStage.show();
    }
}
