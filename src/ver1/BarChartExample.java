package ver1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class BarChartExample extends Application {
    private static final String A = "A";
    private static final String B = "B";
    private static final String C = "C";
    private static final String D = "D";
    private static final String E = "E";
    private static final String F = "F";
    private static final String G = "G";
    private static final String H = "H";
    private static final String CHARACTER = "Character";
    private static final String VALUE = "Value";
    private static final String bar_chart_sample = "Bar Chart Sample";


    @Override
    public void start(Stage stage) {
        stage.setTitle(bar_chart_sample);
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
        xAxis.setLabel(CHARACTER);
        yAxis.setLabel(VALUE);

        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data(A, 25601.34));
        series.getData().add(new XYChart.Data(B, 20148.82));
        series.getData().add(new XYChart.Data(C, 10000));
        series.getData().add(new XYChart.Data(D, 35407.15));
        series.getData().add(new XYChart.Data(E, 12000));
        series.getData().add(new XYChart.Data(F, 12000));
        series.getData().add(new XYChart.Data(G, 12000));
        series.getData().add(new XYChart.Data(H, 12000));

        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}