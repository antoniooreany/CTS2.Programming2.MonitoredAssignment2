package Kratzer.JavaFXDemos;// Demonstrate drawing on a canvas.

import javafx.application.*; 
import javafx.scene.*; 
import javafx.stage.*; 
import javafx.scene.layout.*; 
import javafx.scene.control.*; 
import javafx.event.*; 
import javafx.geometry.*; 
import javafx.scene.canvas.*; 
import javafx.scene.paint.*; 
import javafx.scene.text.*; 

public class CanvasDemo extends Application { 
	Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.BLACK }; 
	int colorIdx = 0; 
	boolean isSmall = false; 

	public static void main(String[] args) { 

		// Start the JavaFX application by calling launch(). 
		launch(args);   
	} 

	// Override the start() method. 
	public void start(Stage myStage) { 

		// Give the stage a title. 
		myStage.setTitle("Draw Directly to a Canvas."); 

		// Use a FlowPane for the root node. 
		FlowPane rootNode = new FlowPane(10, 10); 

		// Center the nodes in the scene. 
		rootNode.setAlignment(Pos.CENTER); 

		// Create a scene. 
		Scene myScene = new Scene(rootNode, 450, 480); 

		// Set the scene on the stage. 
		myStage.setScene(myScene); 

		// Create a canvas. 
		Canvas myCanvas = new Canvas(400, 400); 

		// Get the graphics context for the canvas. 
		GraphicsContext gc = myCanvas.getGraphicsContext2D(); 

		// Create buttons that change color and scale. 
		Button btnChangeColor = new Button("Change Color"); 
		Button btnChangeScale = new Button("Change Scale"); 

		// Handle the action events for the Change Color button. 
		btnChangeColor.setOnAction(new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent ae) { 

				// Set the stroke and fill color. 
				gc.setStroke(colors[colorIdx]); 
				gc.setFill(colors[colorIdx]); 

				// Redraw the line, text, and filled rectangle in the 
				// new color. This leaves the color of the other items 
				// unchanged. 
				gc.strokeLine(0, 0, 200, 200); 
				gc.fillText("This is drawn on the canvas.", 60, 50); 
				gc.fillRect(100, 320, 300, 40); 

				// Change the color. 
				colorIdx++; 
				if(colorIdx == colors.length) colorIdx= 0; 
			} 
		}); 

		// Handle the action events for the Change Scale button. 
		btnChangeScale.setOnAction(new EventHandler<ActionEvent>() { 
			public void handle(ActionEvent ae) { 
				// Clear the canvas and reset the colors to black and 
				// and the color index to 0. 
				gc.clearRect(0, 0, 400, 400); 
				colorIdx = 0;  
				gc.setStroke(Color.BLACK); 
				gc.setFill(Color.BLACK); 

				// Switch between small and large scale. 
				if(!isSmall) {         
					// Scale to one half size. 
					gc.scale(0.5, 0.5); 
				} else { 
					// Scale to full size 
					gc.scale(2.0, 2.0); 
				} 
				isSmall = !isSmall; 

				// Redisplay the graphics and text. 
				gc.strokeLine(0, 0, 200, 200); 
				gc.strokeOval(100, 100, 200, 200); 
				gc.strokeRect(0, 200, 50, 200); 
				gc.fillOval(0, 0, 20, 20); 
				gc.fillRect(100, 320, 300, 40); 
				gc.setFont(new Font(20)); 
				gc.fillText("This is drawn on the canvas.", 60, 50); 
			} 
		}); 

		// Draw initial output on the canvas. 
		gc.strokeLine(0, 0, 200, 200); 
		gc.strokeOval(100, 100, 200, 200); 
		gc.strokeRect(0, 200, 50, 200); 
		gc.fillOval(0, 0, 20, 20); 
		gc.fillRect(100, 320, 300, 40); 

		// Set the font size to 20 and draw text. 
		gc.setFont(new Font(20)); 
		gc.fillText("This is drawn on the canvas.", 60, 50); 

		// Add the canvas and button to the scene graph. 
		rootNode.getChildren().addAll(myCanvas, btnChangeColor, btnChangeScale); 

		// Show the stage and its scene. 
		myStage.show(); 
	} 
}

