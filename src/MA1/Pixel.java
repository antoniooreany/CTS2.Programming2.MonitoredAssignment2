package MA1;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {
    Pixel(double width, double height, Color color) {
        // Setting a geometric parameters of the pixel
        setWidth(width);
        setHeight(height);
        // Setting a color of the pixel
        setFill(color);
    }
}
