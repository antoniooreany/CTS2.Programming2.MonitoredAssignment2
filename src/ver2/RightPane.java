package ver2;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import ver1.PaintException;

class RightPane extends GridPane {
    // TODO Do we need all of these fields?
    // TODO If not, than How to avoid creating these fields?
    private final int rowCount;
    private final int colCount;
    public final int pixelCount;
    private final double hGap;
    private final double vGap;
    private final double pixelWidth;
    private final double pixelHeight;
    private final Color initColor;
    private final Color paintColor;
    private Pixel[][] pixelArray2D;
    private Pixel[] pixelArray;
    private double[][] colorArray2d;
    public double[] colorArray;

    RightPane(int colCount, int rowCount,
              double hGap, double vGap,
              double pixelWidth, double pixelHeight,
              Color initColor, Color paintColor) {
        // Initialize fields
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.pixelCount = rowCount * colCount;
        this.hGap = hGap;
        this.vGap = vGap;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.initColor = initColor;
        this.paintColor = paintColor;
        this.pixelArray2D = new Pixel[rowCount][colCount];
        this.pixelArray = new Pixel[pixelCount];
        this.colorArray2d = new double[rowCount][colCount];
        this.colorArray = new double[pixelCount];
        // Set vertical and horizontal gaps between controls.
        setVgap(vGap);
        setHgap(hGap);
        // Initialize pixels.
        fillRoot();

    }

    // Root filler method
    private void fillRoot() {
        // All the pixels of the rootPane creation in the loop to fill them by "initColor" = initialize them
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                // A new pixel addition
                addNewPixel(row, col, initColor);
            }
        }
    }

    // Paint method
    private void paintByMouse(MouseEvent mouseEvent, Color color) {
        // Column, row of pixel to paintByMouse initialization
        int col = getPixelPositionIndex(mouseEvent.getX(), hGap, getPadding().getLeft(), pixelWidth);
        int row = getPixelPositionIndex(mouseEvent.getY(), vGap, getPadding().getTop(), pixelHeight);
        // Create the painted pixel, put it in the appropriate position (if it exists) in the rootPane
        if (col >= 0 && col < colCount
                && row >= 0 && row < rowCount) {
            // A new pixel addition
            addNewPixel(row, col, color);
        }
    }

    // A new pixel addition method
    private void addNewPixel(int row, int col, Color color) {
        Pixel pixel = new Pixel(pixelWidth, pixelHeight, color, row, col);
        add(pixel, col, row);
        pixelArray2D[row][col] = pixel;
        pixelArray[pixel.seqNum] = pixel;
        if (color == initColor) {
            colorArray2d[row][col] = 0;
            colorArray[pixel.seqNum] = 0;
        } else {
            colorArray2d[row][col] = 1;
            colorArray[pixel.seqNum] = 1;
        }
//        CanvasChart.initCanvasChart(); // TODO How to redraw the Canvas chart when adding the pixel?

        //TODO  readColorArray[256],
        //TODO  put it into nn, getOutput()
        //TODO  nn.take output[8],
        //TODO  draw output[8] in BarChart

//        Main.leftPane.net = LeftPane.getNewNet();
//        Main.leftPane.output = Main.leftPane.getOutput();
//
//        double[] output = Main.leftPane.getOutput(); //TODO NPE
//        CanvasChart.drawCanvasChart(output);

    }

    // Position index getting method
    private int getPixelPositionIndex(double coordinate, double gap, double inset, double pixelSize) {
        // Position index calculation
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

    // MouseEventHandler: events initialization for the left and right mouse buttons
    EventHandler<MouseEvent> getMouseEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // in case of PRIMARY BUTTON - paintByMouse
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    paintByMouse(mouseEvent, paintColor);
                }
                // in case of SECONDARY BUTTON - clear
                else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    fillRoot();
                }
            }
        };
    }

    public void paintByPattern(double[][] iv) {
        fillRoot();
        if (iv.length != colCount) throw new PaintException();
        for (int col = 0; col < colCount; col++) {
            if (iv[col].length != rowCount) throw new PaintException();
            for (int row = 0; row < rowCount; row++) {
                if (iv[row][col] == 1) addNewPixel(row, col, paintColor); //TODO Optimize "> 0.5"
            }
        }
    }

}
