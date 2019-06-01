package com.cts2.programming2.assignment2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Chart extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create a BarChart
        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

        // Series 1 - Data of 2014
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<String, Number>();

        dataSeries.getData().add(new XYChart.Data<String, Number>("A", 20.973));
        dataSeries.getData().add(new XYChart.Data<String, Number>("B", 4.429));
        dataSeries.getData().add(new XYChart.Data<String, Number>("C", 2.792));
        dataSeries.getData().add(new XYChart.Data<String, Number>("D", 2.792));
        dataSeries.getData().add(new XYChart.Data<String, Number>("E", 2.792));
        dataSeries.getData().add(new XYChart.Data<String, Number>("F", 2.792));
        dataSeries.getData().add(new XYChart.Data<String, Number>("G", 2.792));
        dataSeries.getData().add(new XYChart.Data<String, Number>("H", 2.792));

        // Add Series to BarChart.
        barChart.getData().add(dataSeries);

        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(400);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}