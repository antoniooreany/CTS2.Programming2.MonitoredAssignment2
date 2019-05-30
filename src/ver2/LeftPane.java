package ver2;

import ffbp.FFBP;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.util.Random;

public class LeftPane extends VBox {
    public final Button newNetBtn;
    public final ToggleButton noiseBtn;
    public final Button learn500CyclesBtn;
    public final Separator separator1;
    public final Button aBtn;
    public final Button bBtn;
    public final Button cBtn;
    public final Button dBtn;
    public final Button eBtn;
    public final Button fBtn;
    public final Button gBtn;
    public final Button hBtn;
    public final Separator separator2;
    public CanvasChart canvasChart;
    public FFBP net;
    public double[] output;


    public LeftPane() {
        newNetBtn = new Button("New Net");
        noiseBtn = new ToggleButton("Noise");
        learn500CyclesBtn = new Button("Learn 500 Cycles");
        separator1 = new Separator();
        aBtn = new Button("A");
        bBtn = new Button("B");
        cBtn = new Button("C");
        dBtn = new Button("D");
        eBtn = new Button("E");
        fBtn = new Button("F");
        gBtn = new Button("G");
        hBtn = new Button("H");
        separator2 = new Separator();
        canvasChart = new CanvasChart();
        getChildren().addAll(newNetBtn, noiseBtn, learn500CyclesBtn, separator1,
                aBtn, bBtn, cBtn, dBtn, eBtn, fBtn, gBtn, hBtn, separator2, canvasChart);
        net = getNewNet();
        output = getOutput();

        newNetBtn.setOnMouseClicked(event -> {
            net = getNewNet();
            CanvasChart.initCanvasChart();
        });

        learn500CyclesBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                learn(500); // output = getOutput();
                CanvasChart.initCanvasChart();
            }
        });

        aBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DA)));
        bBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DB)));
        cBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DC)));
        dBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DD)));
        eBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DE)));
        fBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DF)));
        gBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DG)));
        hBtn.setOnMouseClicked(ae -> Main.rightPane.paintByPattern(getPixelsRowCol(Patterns.pattern2DH)));
    }

    private void learn(int cyclesAmount) {

//        net = getNewNet(); //TODO Might be only in the launching application or by clicking "New net button"

        Random r = new Random();

        for (int cycleNum = 0; cycleNum <= cyclesAmount; ++cycleNum) {
            switch (r.nextInt(8)) {
                case 0:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DA));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovA);
                    break;
                case 1:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DB));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovB);
                    break;
                case 2:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DC));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovC);
                    break;
                case 3:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DD));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovD);
                    break;
                case 4:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DE));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovE);
                    break;
                case 5:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DF));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovF);
                    break;
                case 6:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DG));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovG);
                    break;
                case 7:
                    net.activateInputAndFeedForward(Patterns.getIV(Patterns.pattern2DH));
                    net.applyDesiredOutputAndPropagateBack(Patterns.ovH);
                    break;
            }
        }
    }

    public double[] getOutput() {
        net.activateInputAndFeedForward(Main.rightPane.colorArray);
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


    public static double[][] getPixelsRowCol(double[][] pattern) {
        if (Main.leftPane.noiseBtn.isSelected())
            return applyNoise(pattern); //TODO If button Noise is pressed, learning with or without noise?
        else return pattern;
    }

    public static double[][] applyNoise(double[][] pattern) {
        double[][] result = new double[ver1.Main.ROW_COUNT][ver1.Main.COL_COUNT];
        Random random = new Random();
        for (int col = 0; col < Main.COL_COUNT; col++) {
            for (int row = 0; row < Main.ROW_COUNT; row++) {
                result[row][col] = pattern[row][col];
                if (random.nextDouble() < 0.1) {
                    if (pattern[row][col] == 0) result[row][col] = 1; //TODO Optimize "< 0.5"
                    else result[row][col] = 0;
                }
            }
        }
        return result;
    }
}
