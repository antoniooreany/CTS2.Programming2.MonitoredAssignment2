package com.cts2.programming2.assignment2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class __CanvasChart extends Canvas {
    private static int width = 200;
    private static int height = 500;
    private GraphicsContext gc = getGraphicsContext2D();
    private int linesNum = 10;
    private int low = 3;
    private double high = 2;
    private int barGap = 12;
    private int barWidth = 12;
    private double[] output;

    __CanvasChart(double[] output) {
        super(width, height);
        this.output = output;
        int row = 0;
        for (; row < linesNum; row++) {
            double y = getY(row);
            gc.strokeLine(0, y, width, y);
        }

        gc.fillText("    A     B     C     D     E     F     G     H  ", 0, getY(row));

        int x = barGap;
        for (double col : output) {
            gc.fillRect(x, 420 - col,
                    barWidth, col);
            x += barWidth + barGap;
        }
    }

    private double getY(int i) {
        return (i + high) * height / (linesNum + low);
    }
}
