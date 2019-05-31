package ver2;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class CanvasChart extends Canvas {

    private static final double width = 200;
    private static final double height = 500;
    private static GraphicsContext gc;
    private static int linesNum = 10;
    private int low = 3;
    private double high = 2;
    private double[] output = new double[Main.rightPane.pixelCount];
    private static final int barGap = 12;
    private static final int leftGap = 10;
    private static double linesHeight = height / linesNum;
    private static final int barWidth = 12;

    public CanvasChart() {
        super(width, height);
        gc = this.getGraphicsContext2D();
//        Main.leftPane.net = LeftPane.getNewNet(); // TODO create a new net for getting an output
        drawCanvasChart(output);
    }

    public static void initCanvasChart() {
        gc.clearRect(0,0,width,height);
        double[] output = Main.leftPane.getOutput();
        drawCanvasChart(output);
    }

    public static void drawCanvasChart(double[] output) {
        for (int i = 0; i < 11; i++) {
            gc.strokeLine(leftGap, i* linesHeight, width, i* linesHeight);
        }
        gc.fillText("    A     B     C     D     E     F     G     H  ", 0, 480);
        int x = barGap;
        for (double col : output) {
            gc.fillRect(x, 450 - col*400, barWidth, col*400);
            x += barWidth + barGap;
        }
    }

    private double getY(int i) {
        return (i + high) * height / (linesNum + low);
    }

}
