package ver1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {

    private final int row;
    private final int col;
    private final int sequenceNumber;

    Pixel(double width, double height, Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.sequenceNumber = row * Main.ROW_COUNT + col;
        System.out.println("sequenceNumber="+ sequenceNumber);
        // Setting a geometric parameters of the pixel
        setWidth(width);
        setHeight(height);
        // Setting a color of the pixel
        setFill(color);
    }
}
