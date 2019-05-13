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

public class AnimationTransitionDemo extends Application {

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
		myStage.setTitle("RotateTransition Demo");  

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

		// Create a RotateTransition that rotates the Start button 
		// through a 2 second period. 
		RotateTransition myRotate = 
				new RotateTransition(new Duration(2000), btnStart); 

		// Cycle 4 times, auto-reverse, and rotate through 360 degrees. 
		myRotate.setAutoReverse(true); 
		myRotate.setCycleCount(4);  
		myRotate.setByAngle(360); 

		// Handle the action events for the Start button.  
		btnStart.setOnAction(new EventHandler<ActionEvent>() {  
			public void handle(ActionEvent ae) {  

				// If animation is not currently running, then run it. 
				if(myRotate.getStatus() == Animation.Status.STOPPED) { 
					response.setText("Rotating");   

					// Enable the Pause/Resume button. 
					btnPauseResume.setDisable(false); 

					// Play the animation. 
					myRotate.play(); 
				} else { // Otherwise, wait. 
					response.setText("Rotation Already In Progress"); 
				} 
			}  
		});  

		// Handle the action events for the Pause/Resume button.  
		btnPauseResume.setOnAction(new EventHandler<ActionEvent>() {  
			public void handle(ActionEvent ae) {  

				// If animation is running, then pause it. 
				if(myRotate.getStatus() == Animation.Status.RUNNING) { 
					response.setText("Rotation Paused"); 
					myRotate.pause(); 
				} else { // Otherwise, resume play. 
					if(myRotate.getStatus() == Animation.Status.PAUSED) { 
						response.setText("Rotation Resumed"); 
						myRotate.play(); 
					} 
				} 
			}  
		});  

		// Handle animation-finish events. 
		myRotate.setOnFinished(new EventHandler<ActionEvent>() {  
			public void handle(ActionEvent ae) {  
				response.setText("Rotation Finished");  

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
