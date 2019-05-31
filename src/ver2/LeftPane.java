package ver2;

import ffbp.FFBP;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;

import java.util.Random;

public class LeftPane extends VBox {
    public final Button newNetBtn = new Button("New Net");
    public final ToggleButton noiseBtn = new ToggleButton("Noise");
    public final Button learn500CyclesBtn = new Button("Learn 500 Cycles");
    public final Separator separator1 = new Separator();

    public Button[] btnsLetters;

    public final Separator separator2 = new Separator();
    public CanvasChart canvasChart = new CanvasChart(); //TODO Do it with BarChart. setAnimation(off)
    private final int cyclesToLearn = 500;
    public FFBP net;
    public double[] output;
    public static int rawCount = Main.ROW_COUNT; //TODO
    public static int colCount = Main.COL_COUNT; //TODO


    public LeftPane() {

        btnsLetters = new Button[]{
                new Button("A"),
                new Button("B"),
                new Button("C"),
                new Button("D"),
                new Button("E"),
                new Button("F"),
                new Button("G"),
                new Button("H")
        };
//        for (int i = 0; i < 8; i++) {
//            btnsLetters[i] = new Button();
//        }

//        getChildren().addAll(newNetBtn, noiseBtn, learn500CyclesBtn, separator1, aBtn, bBtn, cBtn, dBtn, eBtn, fBtn, gBtn, hBtn, separator2, canvasChart);
        getChildren().addAll(newNetBtn, noiseBtn, learn500CyclesBtn, separator1,
                btnsLetters[0], btnsLetters[1], btnsLetters[2], btnsLetters[3], btnsLetters[4], btnsLetters[5], btnsLetters[6], btnsLetters[7],
                separator2, canvasChart);
        net = getNewNet();
        output = getOutput();

        newNetBtn.setOnMouseClicked(event -> {
            net = getNewNet();
            CanvasChart.initCanvasChart();
        });

        learn500CyclesBtn.setOnMouseClicked(event -> {
            learn(cyclesToLearn); // output = getOutput();
            CanvasChart.initCanvasChart();
        });

//        for (Button btn : btnsLetters) {
        for (int i = 0; i < Patterns.matricesLetter.length; i++) {
            int finalI = i;
            btnsLetters[i].setOnMouseClicked(ae -> {
                Main.rightPane.paintByMatrix(getMatrixWithNoise(Patterns.matricesLetter[finalI]));
                CanvasChart.initCanvasChart();
            });
        }
    }

    private void learn(int cyclesToLearn) {

//        net = getNewNet(); //TODO Might be only in the launching application or by clicking "New net button"

        Random r = new Random();
        for (int cycleNum = 0; cycleNum <= cyclesToLearn; ++cycleNum) {
            int letterNumber = r.nextInt(Patterns.matricesLetter.length);
            net.activateInputAndFeedForward(Patterns.getVector(Patterns.matricesLetter[letterNumber]));
            net.applyDesiredOutputAndPropagateBack(Patterns.ovLetter[letterNumber]);
        }
    }

    public double[] getOutput() {
        net.activateInputAndFeedForward(Main.rightPane.vector);
        return net.getOutput();
    }

    public static FFBP getNewNet() {
        int[] layout = {256, 16, 8};
        FFBP net = new FFBP(layout);
        net.randomize(-0.1, +0.1);
        net.setEta(0.5);
        net.setAlpha(0.5);
        return net;
    }

    public double[][] getMatrixWithNoise(double[][] matrix) {
        if (noiseBtn.isSelected())
            return applyNoise(matrix); //TODO If button Noise is pressed, learning with or without noise?
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
