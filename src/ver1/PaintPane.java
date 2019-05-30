package ver1;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PaintPane extends GridPane {
    // TODO Do we need all of these fields?
    // TODO If not, than How to avoid creating these fields?
    public int colCount;
    public int rowCount;
    public double hGap;
    public double vGap;
    public double pixelWidth;
    public double pixelHeight;
    public Color initColor;
    public Color paintColor;
    public Pixel[][] pixels;
    public double[][] pattern;
    public double[] sequencePattern;

    public PaintPane(int colCount, int rowCount,
                     double hGap, double vGap,
                     double pixelWidth, double pixelHeight,
                     Color initColor, Color paintColor) {
        // Initialize pixels.
        fillRoot();
        // Initialize fields
        this.colCount = colCount;
        this.rowCount = rowCount;
        this.hGap = hGap;
        this.vGap = vGap;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.initColor = initColor;
        this.paintColor = paintColor;
//        this.pixels = new ver1.Pixel[rowCount][colCount]; //TODO pixels
        this.pattern = getPixelsColorArray(); //TODO NPE
        this.sequencePattern = PaintData.getPixelsSequenceNumbers(pattern); //TODO NPE
        // Set vertical and horizontal gaps between controls.
        setVgap(vGap);
        setHgap(hGap);
    }


    // A new pixel addition method
    private void addNewPixel(int row, int col, Color color) {
        Pixel pixel = new Pixel(pixelWidth, pixelHeight, color, row, col);
        add(pixel, col, row); //TODO Everywhere in the app I use (row, col), not (col, row)
        pixels[row][col] = pixel;
//        pixels = new ver1.Pixel[rowCount][colCount];

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
    private void paint(MouseEvent mouseEvent, Color color) {
        // Column, row of pixel to paint initialization
        int col = getPixelPositionIndex(mouseEvent.getX(), hGap, getPadding().getLeft(), pixelWidth);
        int row = getPixelPositionIndex(mouseEvent.getY(), vGap, getPadding().getTop(), pixelHeight);
        // Create the painted pixel, put it in the appropriate position (if it exists) in the rootPane
        if (col >= 0 && col < colCount
                && row >= 0 && row < rowCount) {
            // A new pixel addition
            addNewPixel(row, col, color);
        }
    }


    // Position index getting method
    private int getPixelPositionIndex(double coordinate, double gap, double inset, double pixelSize) {
        // Position index calculation
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

    // MouseEventHandler: events initialization for the left and right mouse buttons
    public EventHandler<MouseEvent> getMouseEventHandler() {
        return new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                // in case of PRIMARY BUTTON - paint
                if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                    paint(mouseEvent, paintColor);
                }
                // in case of SECONDARY BUTTON - clear
                else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                    fillRoot();
                } else if (mouseEvent.getButton() == MouseButton.MIDDLE) {
                    paint(mouseEvent, initColor);
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

    public double[][] getPixelsColorArray() {
        double[][] result = new double[rowCount][colCount];
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {
                Paint fill = pixels[row][col].getFill(); //TODO NPE
                if (fill == initColor) result[row][col] = 0;
                else if (fill == paintColor) result[row][col] = 1;
            }
        }
        return result;
    }

    public void flipColor(int row, int col) {
        Pixel pixel = pixels[row][col];
        Paint fill = pixel.getFill();
        if (fill == initColor) pixel.setFill(paintColor);
        else pixel.setFill(initColor);
    }

}
