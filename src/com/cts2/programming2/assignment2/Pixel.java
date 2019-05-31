package com.cts2.programming2.assignment2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Pixel extends Rectangle {
    private int row;
    private int col;
    public int seqNum;
    Pixel(double width, double height, Color color, int row, int col) {
        this.row = row;
        this.col = col;
        this.seqNum = row * Main.COL_COUNT + col;
        // Setting a geometric parameters of the pixel
        setWidth(width);
        setHeight(height);
        // Setting a color of the pixel
        setFill(color);
    }
}
