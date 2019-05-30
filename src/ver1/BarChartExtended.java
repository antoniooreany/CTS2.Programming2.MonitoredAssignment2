package ver1;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;

public class BarChartExtended extends BarChart {
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

    private static final CategoryAxis xAxis = new CategoryAxis();
    private static final NumberAxis yAxis = new NumberAxis();
    private static final BarChart<String, Number> bc = new BarChart<>(xAxis, yAxis);
    private static final ObservableList<Series<String,Number>> OBSERVABLE_LIST = getObservableList();

    public BarChartExtended() {
        super(xAxis, yAxis, OBSERVABLE_LIST /*getObservableList()*/);

        xAxis.setLabel(CHARACTER);
        yAxis.setLabel(VALUE);

//        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(); // TODO Add a parameter
//        stage.setScene(scene);
//        stage.show();
    }

    public static ObservableList<Series<String,Number>> getObservableList() {
        Series series = new Series();
        series.getData().add(new Data(A, 25601.34));
        series.getData().add(new Data(B, 20148.82));
        series.getData().add(new Data(C, 10000));
        series.getData().add(new Data(D, 35407.15));
        series.getData().add(new Data(E, 12000));
        series.getData().add(new Data(F, 12000));
        series.getData().add(new Data(G, 12000));
        series.getData().add(new Data(H, 12000));
        return new ObservableListBase<Series<String, Number>>() {
            @Override
            public Series<String, Number> get(int index) {
                return null
                        ;
            }

            @Override
            public int size() {
                return 0;
            }
        };
    }
}