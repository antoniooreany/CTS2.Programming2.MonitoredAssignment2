package com.cts2.programming2.assignment2;

import ffbp.FFBP;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.util.Random;

public class LeftPane extends VBox {
    private static final double lowerBound = -0.1;
    private static final double upperBound = +0.1;
    private static final double eta = 0.5;
    private static final double alpha = 0.5;
    private static final int hiddenLayerVectorLength = 16;
    private final int cyclesToLearn = 500;
    public final Button newNetBtn = new Button("New Net");
    public final ToggleButton noiseBtn = new ToggleButton("Noise");
    public final Button learnBtn = new Button("Learn 500 Cycles");
    public final Separator separator1 = new Separator();
    public Button[] btnAlphabetArray;
    public final Separator separator2 = new Separator();
    public CanvasChart canvasChart = new CanvasChart(); //TODO Do it with BarChart. setAnimation(off)
    public FFBP net;
    public double[] output;
    public static int rawCount = Main.ROW_COUNT; //TODO
    public static int colCount = Main.COL_COUNT; //TODO
    private final int AlphabetButtonsAmount = Patterns.matricesArray.length;

    public LeftPane() {
        char firstButtonName = 'A';
        btnAlphabetArray = new Button[AlphabetButtonsAmount];
        for (int i = 0; i < AlphabetButtonsAmount; i++) {
            btnAlphabetArray[i] = new Button(String.valueOf((char)(firstButtonName + i)));
        }
        getChildren().addAll(newNetBtn, noiseBtn, learnBtn, separator1);
        for (int i = 0; i < AlphabetButtonsAmount; i++) getChildren().add(btnAlphabetArray[i]);
        getChildren().addAll(separator2, canvasChart);


        net = getNewNet();
        output = getOutput();

        newNetBtn.setOnMouseClicked(event -> {
            net = getNewNet();
            CanvasChart.initCanvasChart();
        });

        learnBtn.setOnMouseClicked(event -> {
            learn(cyclesToLearn); // output = getOutput();
            CanvasChart.initCanvasChart();
        });

//        for (Button btn : btnAlphabetArray) {
        for (int i = 0; i < Patterns.matricesArray.length; i++) {
            int finalI = i;
            btnAlphabetArray[i].setOnMouseClicked(ae -> {
                Main.rightPane.paintByMatrix(getMatrixWithNoise(Patterns.matricesArray[finalI]));
                CanvasChart.initCanvasChart();
            });
        }
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

    public double[] getOutput() {
        net.activateInputAndFeedForward(Main.rightPane.vector);
        return net.getOutput();
    }

    public FFBP getNewNet() {
        int ivLength = Patterns.matricesArray[0].length * Patterns.matricesArray[0][0].length;
//        int[] layout = {256, 16, 8};
        int[] layout = {ivLength, hiddenLayerVectorLength, Patterns.ovArray.length}; //TODO "Main.rightPane.vector.length"=8 instead of "btnAlphabetArray.length", "Patterns.matricesArray.length" gives NPE
        FFBP net = new FFBP(layout);
        net.randomize(lowerBound, upperBound);
        net.setEta(eta);
        net.setAlpha(alpha);
        return net;
    }

    public double[][] getMatrixWithNoise(double[][] matrix) {
        if (noiseBtn.isSelected())
            return applyNoise(matrix); //TODO If button Noise is pressed, learning WITH or WITHOUT noise?
        else return matrix;
    }

    public static double[][] applyNoise(double[][] matrix) {
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
}
