package Kratzer.JavaFXDemos;// Demonstrate a BarChartExample

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.chart.*;

public class BarChartDemo extends Application {

	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().  
		launch(args);
	}

	// Override the start() method.  
	public void start(Stage myStage) {

		// Give the stage a title.  
		myStage.setTitle("BarChartExample Demo");

		// Use a FlowPane for the root node. 
		FlowPane rootNode = new FlowPane();

		// Center the controls in the scene.  
		rootNode.setAlignment(Pos.CENTER);

		// Create a scene.  
		Scene myScene = new Scene(rootNode, 600, 600);

		// Set the scene on the stage.  
		myStage.setScene(myScene);

		// Create the two axes. 
		CategoryAxis hAxis = new CategoryAxis();
		hAxis.setLabel("Programmers");

		NumberAxis vAxis = new NumberAxis();
		vAxis.setLabel("Lines of Code");

		// Create a bar chart that shows the first quarter 
		// productivity in terms of lines of code produced per 
		// month for John, Mary, and Terry. 
		BarChart<String, Number> bcProgProd = new BarChart<>(hAxis, vAxis);
		bcProgProd.setTitle("1st Qtr Productivity");

		// Create the series for the chart. 
		XYChart.Series<String, Number> january = new XYChart.Series<>();
		XYChart.Series<String, Number> february = new XYChart.Series<>();
		XYChart.Series<String, Number> march = new XYChart.Series<>();

		// Populate each series with data. 
		january.setName("January");
		january.getData().add(new XYChart.Data<String, Number>("John", 300));
		january.getData().add(new XYChart.Data<String, Number>("Mary", 325));
		january.getData().add(new XYChart.Data<String, Number>("Terry", 247));

		february.setName("February");
		february.getData().add(new XYChart.Data<String, Number>("John", 242));
		february.getData().add(new XYChart.Data<String, Number>("Mary", 183));
		february.getData().add(new XYChart.Data<String, Number>("Terry", 354));

		march.setName("March");
		march.getData().add(new XYChart.Data<String, Number>("John", 53));
		march.getData().add(new XYChart.Data<String, Number>("Mary", 224));
		march.getData().add(new XYChart.Data<String, Number>("Terry", 288));

		// Add the series to the chart. 
		bcProgProd.getData().add(january);
		bcProgProd.getData().add(february);
		bcProgProd.getData().add(march);

		// Add the chart to the scene.  
		rootNode.getChildren().add(bcProgProd);

		// Show the stage and its scene.  
		myStage.show();
	}
}
