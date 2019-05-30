package ver1;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasChart extends Canvas {
    private static final int width = 200;
    private static final int height = 500;
    private final GraphicsContext gc = getGraphicsContext2D();
    private static final int number = 10;
    private static final int low = 3;
    private static final double high = 2;
    private static final int barGap = 12;
    private static final int barWidth = 12;
    private final double[] ov;

    CanvasChart(double[] ov) {
        super(width, height);
        this.ov = ov;
        int row = 0;
        for (; row < number; row++) {
            double y = getY(row);
            gc.strokeLine(0, y, width, y);
        }

        gc.fillText("    A     B     C     D     E     F     G     H  ", 0, getY(row));

        int x = barGap;
        for (double col : ov) {
            gc.fillRect(x, 420-col,
                        barWidth, col);
            x += barWidth + barGap;
        }
    }

    private double getY(int i) {
        return (i + high) * height / (number + low);
    }
}
