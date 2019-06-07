package com.cts2.programming2.assignment2;

import ffbp.FFBP;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.util.Random;

import static com.cts2.programming2.assignment2.Patterns.matricesArray;

public class Controller extends VBox {
    private static final double LOWER_BOUND = -0.1;
    private static final double UPPER_BOUND = +0.1;
    private static final double ETA = 0.5;
    private static final double ALPHA = 0.5;
    private static final int HIDDEN_LAYER_VECTOR_LENGTH = 16;
    private static final int CYCLES_TO_LEARN = 500;
    private static final int PREF_WIDTH = 300;
    private static final int BUTTON_MAX_HEIGHT = 20;
    private static final char FIRST_BUTTON_NAME_CHAR = 'A';

    private Button newNetBtn;
    private ToggleButton noiseBtn;
    private Button learnBtn;
    private Separator separator1 = new Separator();
    private Button[] alphabetButtonsArray;
    private Separator separator2 = new Separator();
    private FFBP net;
//    private double[] output;

    private BarChart<String, Number> barChart;
    private XYChart.Series<String, Number> dataSeries;

    private PaintPane paintPane;

    Controller(PaintPane paintPane) {
        super(10);
        this.paintPane = paintPane;
//        setPrefSize(PREF_WIDTH, (paintPane.getPixelHeight() + paintPane.getHgap()) * paintPane.getRowCount());
        setPrefSize(PREF_WIDTH, paintPane.getHeight());
        net = getNewNet();
//        output = getOutput();
        paintPane.registerController(this);

        createLeftPaneButtons();
        createSetOnMouseClickedEventHandlers();
        addButtons();

        createAndAddBarChart();
    }

    private void createAndAddBarChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        // Create a BarChart
        barChart = new BarChart<String, Number>(xAxis, yAxis);
        barChart.setAnimated(false); //TODO Does it needed to be done?

        // Create series
        dataSeries = new XYChart.Series<String, Number>();

        renewBarChart(dataSeries);

        // Add Series to BarChart.
        barChart.getData().add(dataSeries); //TODO Uncomment this line?
//        barChart.getData().get(0);

        barChart.setBarGap(0);
        barChart.setLegendVisible(false);
//        barChart.setPrefHeight(300);
//        barChart.setPrefHeight(paintPane.getHeight() - );

        getChildren().add(barChart);
    }

    void renewBarChart(XYChart.Series<String, Number> dataSeries) {
        for (char ch = FIRST_BUTTON_NAME_CHAR; ch < FIRST_BUTTON_NAME_CHAR + alphabetButtonsArray.length; ch++) { //TODO Loop through the chars
            dataSeries.getData().add(new XYChart.Data<String, Number>(String.valueOf(ch), getOutput()[ch - FIRST_BUTTON_NAME_CHAR]));
        }
    }

    private void createLeftPaneButtons() {
        newNetBtn = new Button("New Net");
        noiseBtn = new ToggleButton("Noise");
        learnBtn = new Button("Learn 500 Cycles");
        newNetBtn.setMaxSize(PREF_WIDTH, BUTTON_MAX_HEIGHT);
        noiseBtn.setMaxSize(PREF_WIDTH, BUTTON_MAX_HEIGHT);
        learnBtn.setMaxSize(PREF_WIDTH, BUTTON_MAX_HEIGHT);
        createAlphabetButtons();
    }

    private void createAlphabetButtons() {
        alphabetButtonsArray = new Button[matricesArray.length];
        for (char ch = FIRST_BUTTON_NAME_CHAR; ch < FIRST_BUTTON_NAME_CHAR + alphabetButtonsArray.length; ch++) { //TODO Loop through the chars
            alphabetButtonsArray[ch - FIRST_BUTTON_NAME_CHAR] = new Button(String.valueOf(ch));
            alphabetButtonsArray[ch - FIRST_BUTTON_NAME_CHAR].setMaxSize(PREF_WIDTH, BUTTON_MAX_HEIGHT);
        }
    }

    private void createSetOnMouseClickedEventHandlers() {
        newNetBtn.setOnMouseClicked(event -> {
            net = getNewNet();
            renewBarChart(dataSeries);
        });

        noiseBtn.setOnMousePressed(event -> {
            // TODO Apply noise for the currently drown picture
            renewBarChart(dataSeries);
        });

        learnBtn.setOnMouseClicked(event -> {
            learn(CYCLES_TO_LEARN); // output = getOutput();
            renewBarChart(dataSeries);
        });
        createAlphabetButtonsSetOnMouseClickedEventHandlers();
    }

    private void createAlphabetButtonsSetOnMouseClickedEventHandlers() {
        for (int i = 0; i < alphabetButtonsArray.length; i++) {
            int finalI = i;
            alphabetButtonsArray[i].setOnMouseClicked(ae -> {
                paintPane.paintByMatrix(getMatrixWithNoise(matricesArray[finalI])); //TODO alphabetButtonsArray.length =!= matricesArray. How to connect these two arrays? // TODO Hint: (key -> value)
                renewBarChart(dataSeries);
            });
        }
    }

    private void addButtons() {
        getChildren().addAll(newNetBtn, noiseBtn, learnBtn, separator1);
        for (Button button : alphabetButtonsArray) getChildren().add(button);
        getChildren().add(separator2);
    }

    private void learn(int cyclesToLearn) {
        Random r = new Random();
        for (int cycleNum = 0; cycleNum <= cyclesToLearn; ++cycleNum) {
            int letterNumber = r.nextInt(matricesArray.length);
            double[][] matrixElementToLearn = noiseBtn.isSelected() ?
                    getMatrixWithNoise(matricesArray[letterNumber]) :
                    matricesArray[letterNumber];
            net.activateInputAndFeedForward(Patterns.getVector(matrixElementToLearn));
            net.applyDesiredOutputAndPropagateBack(Patterns.ovArray[letterNumber]);
        }
    }

    public double[] getOutput() {
        net.activateInputAndFeedForward(paintPane.getVector());
        return net.getOutput();
    }

    private FFBP getNewNet() {
        int ivLength = matricesArray[0].length * matricesArray[0][0].length;
        int[] layout = {ivLength, HIDDEN_LAYER_VECTOR_LENGTH, Patterns.ovArray.length}; //TODO "Main.paintPane.DOUBLES_VECTOR.length"=8 instead of "alphabetButtonsArray.length", "Patterns.matricesArray.length" gives NPE
        FFBP net = new FFBP(layout);
        net.randomize(LOWER_BOUND, UPPER_BOUND);
        net.setEta(ETA);
        net.setAlpha(ALPHA);
        return net;
    }

    private double[][] getMatrixWithNoise(double[][] matrix) {
        if (noiseBtn.isSelected())
            return applyNoise(matrix); //TODO If button Noise is pressed, learning WITH or WITHOUT noise?
        else return matrix;
    }

    private double[][] applyNoise(double[][] matrix) {
        double[][] result = new double[paintPane.getRowCount()][paintPane.getColCount()];
        Random random = new Random();
        for (int col = 0; col < paintPane.getColCount(); col++) {
            for (int row = 0; row < paintPane.getRowCount(); row++) {
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
//                if (DOUBLES_VECTOR[seqNum] == 0) resultVector[seqNum] = 1; //TODO Optimize "< 0.5"
                resultVector[seqNum] = (vector[seqNum] == 0) ? 1 : 0; //TODO Optimize "< 0.5"
//                else resultVector[seqNum] = 0;
            } else resultVector[seqNum] = vector[seqNum];
//            }
        }
        return resultVector;
    }

    public BarChart<String, Number> getBarChart() {
        return barChart;
    }
}
