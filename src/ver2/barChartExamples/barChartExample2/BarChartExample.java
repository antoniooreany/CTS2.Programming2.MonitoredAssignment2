package ver2.barChartExamples.barChartExample2;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BarChartExample extends Application {

    final static String project = "Project - 20%";
    final static String quiz = "Quiz - 10%";
    final static String midterm = "Midterm - 30%";
    final static String finalexam = "Final - 40%";

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Change Bar Color Example");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart = new BarChart<String, Number>(xAxis, yAxis);
        xAxis.setLabel("Assignment Type");
        yAxis.setLabel("Percentage");

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(project, 20));
        series.getData().add(new XYChart.Data(quiz, 10));
        series.getData().add(new XYChart.Data(midterm, 30));
        series.getData().add(new XYChart.Data(finalexam, 40));
        barChart.getData().add(series);


        Node n = barChart.lookup(".data0.chart-bar");
        n.setStyle("-fx-bar-fill: red");
        n = barChart.lookup(".data1.chart-bar");
        n.setStyle("-fx-bar-fill: blue");
        n = barChart.lookup(".data2.chart-bar");
        n.setStyle("-fx-bar-fill: green");
        n = barChart.lookup(".data3.chart-bar");
        n.setStyle("-fx-bar-fill: orange");


        barChart.setLegendVisible(false);
        VBox vbox = new VBox(barChart);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}