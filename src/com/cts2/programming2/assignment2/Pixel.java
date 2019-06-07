package com.cts2.programming2.assignment2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {

    private PaintPane parent;
    int seqNum;

    public Pixel(PaintPane parent, double width, double height, Color color, int row, int col) {
        // Parent initialization
        this.parent = parent;
        // Sequence number initialization
        this.seqNum = row * parent.getColCount() + col;
        // Setting a geometric parameters of the pixel
        setWidth(width);
        setHeight(height);
        // Setting a color of the pixel
        setFill(color);
    }
}
