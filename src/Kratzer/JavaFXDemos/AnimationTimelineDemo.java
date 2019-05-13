package Kratzer.JavaFXDemos;

import javafx.application.*;
import javafx.scene.*;  
import javafx.stage.*;  
import javafx.scene.layout.*;  
import javafx.scene.control.*;  
import javafx.event.*;  
import javafx.geometry.*;  
import javafx.animation.*; 
import javafx.util.*; 

public class AnimationTimelineDemo extends Application {

	Label response;  
	Button btnStart; 
	Button btnPauseResume; 

	public static void main(String[] args) {  

		// Start the JavaFX application by calling launch().  
		launch(args);    
	}  

	// Override the start() method.  
	public void start(Stage myStage) {  

		// Give the stage a title.  
		myStage.setTitle("Timeline Animation Demo");  

		// Use a VBox for the root node. 
		VBox rootNode = new VBox(30);  

		// Center the controls in the scene.  
		rootNode.setAlignment(Pos.CENTER);  

		// Create a scene.  
		Scene myScene = new Scene(rootNode, 300, 180);  

		// Set the scene on the stage.  
		myStage.setScene(myScene);  

		// Create a label.  
		response = new Label("Push the Start button.");  

		// Create buttons. 
		btnStart = new Button("Start");  
		btnPauseResume = new Button("Pause/Resume"); 
		btnPauseResume.setDisable(true); // initially disable the button. 

		// Create key values that affect the scale in both the X and Y 
		// directions of bntStart. 
		KeyValue kvScaleX = new KeyValue(btnStart.scaleXProperty(), 1.5); 
		KeyValue kvScaleY = new KeyValue(btnStart.scaleYProperty(), 1.5); 

		// Create a key value that affects the rotation of btnStart. 
		KeyValue kvRotation = new KeyValue(btnStart.rotateProperty(), 180); 

		// Create a key frame that use the key values. 
		KeyFrame kf = new KeyFrame(new Duration(1000), 
				kvScaleX, kvScaleY, kvRotation); 

		// Create a animation timeline. 
		Timeline myTL = new Timeline(kf); 
		myTL.setCycleCount(4);  
		myTL.setAutoReverse(true); 

		// Add the key frame to the timeline. 
		myTL.getKeyFrames().add(kf); 

		// Handle the action events for the Start button.  
		btnStart.setOnAction(new EventHandler<ActionEvent>() {  
			public void handle(ActionEvent ae) {  

				// If animation is not currently running, then run it. 
				if(myTL.getStatus() == Animation.Status.STOPPED) { 
					response.setText("Animation Started");   

					// Enable the Pause/Resume button. 
					btnPauseResume.setDisable(false); 

					// Play the animation. 
					myTL.play();  
				} else { // Otherwise, wait. 
					response.setText("Animation Already Running"); 
				} 
			}  
		});  

		// Handle the action events for the Pause/Resume button.  
		btnPauseResume.setOnAction(new EventHandler<ActionEvent>() {  
			public void handle(ActionEvent ae) {  

				// If animation is running, then pause it. 
				if(myTL.getStatus() == Animation.Status.RUNNING) { 
					response.setText("Animation Paused"); 
					myTL.pause(); 
				} else { // Otherwise, resume play. 
					if(myTL.getStatus() == Animation.Status.PAUSED) { 
						response.setText("Animation Resumed"); 
						myTL.play(); 
					} 
				} 
			}  
		});  

		// Handle animation-finish events. 
		myTL.setOnFinished(new EventHandler<ActionEvent>() {  
			public void handle(ActionEvent ae) {  
				response.setText("Animation Finished");  

				// Disable the Pause/Resume button. 
				btnPauseResume.setDisable(true); 
			}  
		});  

		// Add the label and buttons to the scene graph.  
		rootNode.getChildren().addAll(btnStart, btnPauseResume, response);  

		// Show the stage and its scene.  
		myStage.show();  
	}  

}
