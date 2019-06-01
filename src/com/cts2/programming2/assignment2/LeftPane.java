package com.cts2.programming2.assignment2;

import ffbp.FFBP;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.Random;

public class LeftPane extends VBox {
    private static final double lowerBound = -0.1;
    private static final double upperBound = +0.1;
    private static final double eta = 0.5;
    private static final double alpha = 0.5;
    private static final int hiddenLayerVectorLength = 16;
    private final int cyclesToLearn = 500;
    private int buttonMaxWidth = 300;
    private final int buttonMaxHeight = 20;
    private Button newNetBtn = new Button("New Net");
    private ToggleButton noiseBtn = new ToggleButton("Noise");
    private Button learnBtn = new Button("Learn 500 Cycles");
    private Separator separator1 = new Separator();
    private Button[] alphabetButtonsArray;
    private Separator separator2 = new Separator();
    //    private CanvasChart canvasChart; //TODO Do it with BarChart. setAnimation(off)
    //        public CanvasChart canvasChart = new BarChart<>(); //TODO Do it with BarChart. setAnimation(off)
    private FFBP net;
    private double[] output;
    private static int rawCount = Main.ROW_COUNT; //TODO
    private static int colCount = Main.COL_COUNT; //TODO
    private final char firstButtonNameChar = 'A';
    BarChart<String, Number> barChart;
    XYChart.Series<String, Number> dataSeries;


    LeftPane() {
        net = getNewNet();
        output = getOutput();

        createLeftPaneButtons();
        createSetOnMouseClickedEventHandlers();
        addButtons();

//        createAndAddCanvasChart();

        createAndAddBarChart();
        this.setOpaqueInsets(new Insets(10,10,10,10)); // TODO Add gaps between buttons

    }

//    private void createAndAddCanvasChart() {
//        canvasChart = new CanvasChart(); //TODO Do it with BarChart. setAnimation(off)
//        getChildren().add(canvasChart);
//    }

    private void createAndAddBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create a BarChart
        barChart = new BarChart<String, Number>(xAxis, yAxis);
        barChart.setAnimated(false); //TODO Does it needed to be done?

        // Series 1 - Data of 2014
        dataSeries = new XYChart.Series<String, Number>();

        renewBarChart(barChart, dataSeries);
//        Main.leftPane.renewBarChart(Main.leftPane.barChart, Main.leftPane.dataSeries);

        // Add Series to BarChart.
        barChart.getData().add(dataSeries); //TODO Uncomment this line?

        barChart.setBarGap(0);
        barChart.setLegendVisible(false);

        getChildren().add(barChart);


    }

    void renewBarChart(BarChart<String, Number> barChart, XYChart.Series<String, Number> dataSeries) {

        for (char ch = firstButtonNameChar; ch < firstButtonNameChar + alphabetButtonsArray.length; ch++) { //TODO Loop through the chars
            dataSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(ch), getOutput()[ch - firstButtonNameChar]));
        }

//        barChart.getData().add(dataSeries); //TODO Uncomment this line?

//        getChildren().add(barChart);
    }

    private void createLeftPaneButtons() {
        newNetBtn = new Button("New Net");
        noiseBtn = new ToggleButton("Noise");
        learnBtn = new Button("Learn 500 Cycles");
        newNetBtn.setMaxSize(buttonMaxWidth, buttonMaxHeight);
        noiseBtn.setMaxSize(buttonMaxWidth, buttonMaxHeight);
        learnBtn.setMaxSize(buttonMaxWidth, buttonMaxHeight);
        createAlphabetButtons();
    }

    private void createAlphabetButtons() {
        alphabetButtonsArray = new Button[Patterns.matricesArray.length];
        for (char ch = firstButtonNameChar; ch < firstButtonNameChar + alphabetButtonsArray.length; ch++) { //TODO Loop through the chars
            alphabetButtonsArray[ch - firstButtonNameChar] = new Button(String.valueOf(ch));
            alphabetButtonsArray[ch - firstButtonNameChar].setMaxSize(buttonMaxWidth, buttonMaxHeight);
        }
    }

    private void createSetOnMouseClickedEventHandlers() {
        newNetBtn.setOnMouseClicked(event -> {
            net = getNewNet();
//            CanvasChart.initCanvasChart(); //TODO UNCOMMENT THIS!
            renewBarChart(barChart, dataSeries);
//            Main.leftPane.renewBarChart(Main.leftPane.barChart, Main.leftPane.dataSeries);

        });

        noiseBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // TODO Apply noise for the currently drown picture
//                double[] vector = applyNoise(Main.rightPane.vector);
//                double[] vector = applyNoise(output);
//                double[] vector = applyNoise();
//                output = getOutput();

                renewBarChart(barChart, dataSeries);
//            Main.leftPane.renewBarChart(Main.leftPane.barChart, Main.leftPane.dataSeries);

            }
        });

        learnBtn.setOnMouseClicked(event -> {
            LeftPane.this.learn(cyclesToLearn); // output = getOutput();
//            CanvasChart.initCanvasChart();  //TODO UNCOMMENT THIS!
            renewBarChart(barChart, dataSeries);
//            Main.leftPane.renewBarChart(Main.leftPane.barChart, Main.leftPane.dataSeries);
        });
        createAlphabetButtonsSetOnMouseClickedEventHandlers();
    }

    private void createAlphabetButtonsSetOnMouseClickedEventHandlers() {
        for (int i = 0; i < alphabetButtonsArray.length; i++) {
            int finalI = i;
            alphabetButtonsArray[i].setOnMouseClicked(ae -> {
                Main.rightPane.paintByMatrix(getMatrixWithNoise(Patterns.matricesArray[finalI])); //TODO alphabetButtonsArray.length =!= matricesArray. How to connect these two arrays?
//                CanvasChart.initCanvasChart();  //TODO UNCOMMENT THIS!                                                      // TODO Hint: (key -> value)
                renewBarChart(barChart, dataSeries);
//                Main.leftPane.renewBarChart(Main.leftPane.barChart, Main.leftPane.dataSeries);

            });
        }
    }

    private void addButtons() {
        getChildren().addAll(newNetBtn, noiseBtn, learnBtn, separator1);
        for (int i = 0; i < alphabetButtonsArray.length; i++) getChildren().add(alphabetButtonsArray[i]);
//        getChildren().addAll(separator2, canvasChart);
        getChildren().add(separator2);
    }

    private void learn(int cyclesToLearn) {
//        net = getNewNet(); //TODO Might be only in the launching application or by clicking "New net button"
        Random r = new Random();
        for (int cycleNum = 0; cycleNum <= cyclesToLearn; ++cycleNum) {
            int letterNumber = r.nextInt(Patterns.matricesArray.length);
            net.activateInputAndFeedForward(Patterns.getVector(Patterns.matricesArray[letterNumber]));
            net.applyDesiredOutputAndPropagateBack(Patterns.ovArray[letterNumber]);
        }
    }

    double[] getOutput() {
        net.activateInputAndFeedForward(Main.rightPane.vector);
        return net.getOutput();
    }

    private FFBP getNewNet() {
        int ivLength = Patterns.matricesArray[0].length * Patterns.matricesArray[0][0].length;
//        int[] layout = {256, 16, 8};
        int[] layout = {ivLength, hiddenLayerVectorLength, Patterns.ovArray.length}; //TODO "Main.rightPane.vector.length"=8 instead of "alphabetButtonsArray.length", "Patterns.matricesArray.length" gives NPE
        FFBP net = new FFBP(layout);
        net.randomize(lowerBound, upperBound);
        net.setEta(eta);
        net.setAlpha(alpha);
        return net;
    }

    private double[][] getMatrixWithNoise(double[][] matrix) {
        if (noiseBtn.isSelected())
            return applyNoise(matrix); //TODO If button Noise is pressed, learning WITH or WITHOUT noise?
        else return matrix;
    }

    private static double[][] applyNoise(double[][] matrix) {
        double[][] result = new double[rawCount][colCount];
        Random random = new Random();
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rawCount; row++) {
                result[row][col] = matrix[row][col];
                if (random.nextDouble() < 0.1) {
                    if (matrix[row][col] == 0) result[row][col] = 1; //TODO Optimize "< 0.5"
                    else result[row][col] = 0;
                }
            }
        }
        return result;
    }

    private static double[] applyNoise(double[] vector) {
        double[] resultVector = new double[vector.length];
        Random random = new Random();
//        for (int col = 0; col < colCount; col++) {
        for (int seqNum = 0; seqNum < resultVector.length; seqNum++) {
            if (random.nextDouble() < 0.1) {
//                if (vector[seqNum] == 0) resultVector[seqNum] = 1; //TODO Optimize "< 0.5"
                resultVector[seqNum] = (vector[seqNum] == 0) ? 1 : 0; //TODO Optimize "< 0.5"
//                else resultVector[seqNum] = 0;
            } else resultVector[seqNum] = vector[seqNum];
//            }
        }
        return resultVector;
    }
}
