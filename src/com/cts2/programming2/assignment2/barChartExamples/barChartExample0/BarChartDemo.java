package com.cts2.programming2.assignment2.barChartExamples.barChartExample0;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setLabel("A    B   C   D   E   F   G   H");

        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Percent");

        // Create a BarChart
        BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);

        // Series 1 - Data of 2014
        XYChart.Series<String, Number> dataSeries1 = new XYChart.Series<String, Number>();
//        dataSeries1.setName("2014");

        dataSeries1.getData().add(new XYChart.Data<String, Number>("A", 20.973));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("B", 4.429));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("C", 2.792));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("D", 2.792));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("E", 2.792));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("F", 2.792));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("G", 2.792));
        dataSeries1.getData().add(new XYChart.Data<String, Number>("H", 2.792));

        // Series 2 - Data of 2015
//        XYChart.Series<String, Number> dataSeries2 = new XYChart.Series<String, Number>();
//        dataSeries2.setName("2015");
//
//        dataSeries2.getData().add(new XYChart.Data<String, Number>("Java", 26.983));
//        dataSeries2.getData().add(new XYChart.Data<String, Number>("C#", 6.569));
//        dataSeries2.getData().add(new XYChart.Data<String, Number>("PHP", 6.619));

        // Add Series to BarChart.
        barChart.getData().add(dataSeries1);
//        barChart.getData().add(dataSeries2);

//        barChart.setTitle("A    B   C   D   E   F   G   H");

        VBox vbox = new VBox(barChart);

//        primaryStage.setTitle("JavaFX BarChart (o7planning.org)");
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