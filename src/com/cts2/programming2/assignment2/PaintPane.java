package com.cts2.programming2.assignment2;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PaintPane extends GridPane {
    private final static int ROW_COUNT = 16;
    private final static int COL_COUNT = 16;
    private final static int PIXEL_COUNT = ROW_COUNT * COL_COUNT;

    private final static double H_GAP = 2;
    private final static double V_GAP = 2;

    private final static double PIXEL_WIDTH = 40;
    private final static double PIXEL_HEIGHT = 40;

    private final static Color INIT_COLOR = Color.WHITE;
    private final static Color PAINT_COLOR = Color.BLACK;

    private final static Pixel[][] PIXEL_MATRIX = new Pixel[ROW_COUNT][COL_COUNT];
    private final static Pixel[] PIXEL_VECTOR = new Pixel[PIXEL_COUNT];
    private final static double[][] MATRIX = new double[ROW_COUNT][COL_COUNT];
    private final static double[] VECTOR = new double[PIXEL_COUNT];

    private Controller controller;

    public PaintPane() {
        // Set vertical and horizontal gaps between controls.
        setVgap(V_GAP);
        setHgap(H_GAP);
        // Initialize pixels.
        fillRoot();
        // Add EventHandler
        addEventHandler(MouseEvent.ANY, getMouseEventHandler()); //TODO Move this statement into the constructor of the PaintPane?
    }

    // Root filler method
    private void fillRoot() {
        // All the pixels of the rootPane creation in the loop to fill them by "INIT_COLOR" = initialize them
        for (int col = 0; col < COL_COUNT; col++) {
            for (int row = 0; row < ROW_COUNT; row++) {
                // A new pixel addition
                addNewPixel(row, col, INIT_COLOR);
            }
        }
    }

    // Paint method
    private void paintByMouse(MouseEvent mouseEvent, Color color) {
        // Column, row of pixel to paintByMouse initialization
        int col = getPixelPositionIndex(mouseEvent.getX(), H_GAP, getPadding().getLeft(), PIXEL_WIDTH);
        int row = getPixelPositionIndex(mouseEvent.getY(), V_GAP, getPadding().getTop(), PIXEL_HEIGHT);
        // Create the painted pixel, put it in the appropriate position (if it exists) in the rootPane
        if (col >= 0 && col < COL_COUNT && row >= 0 && row < ROW_COUNT) {
            // A new pixel addition
            addNewPixel(row, col, color);
        }
    }

    // A new pixel addition method
    private void addNewPixel(int row, int col, Color color) {
        Pixel pixel = new Pixel(this, PIXEL_WIDTH, PIXEL_HEIGHT, color, row, col);
        add(pixel, col, row);
//        PIXEL_MATRIX[row][col] = pixel;
//        PIXEL_VECTOR[pixel.seqNum] = pixel;
        if (color == INIT_COLOR) {
            MATRIX[row][col] = 0;
            VECTOR[pixel.seqNum] = 0;
        } else {
            MATRIX[row][col] = 1;
            VECTOR[pixel.seqNum] = 1;
        }
    }

    // Position index getting method
    private int getPixelPositionIndex(double coordinate, double gap, double inset, double pixelSize) {
        // Position index calculation
        return (int) ((coordinate + gap / 2 - inset) / (pixelSize + gap));
    }

    // MouseEventHandler: events initialization for the left and right mouse buttons
    EventHandler<MouseEvent> getMouseEventHandler() {
        return mouseEvent -> {
            // in case of PRIMARY BUTTON - paintByMouse
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                paintByMouse(mouseEvent, PAINT_COLOR);
            }
            // in case of SECONDARY BUTTON - clear
            else if (mouseEvent.getButton() == MouseButton.SECONDARY) {
                fillRoot();
            }
            controller.renewBarChart(controller.getBarChart().getData().get(0)); // TODO The only one call renewBarChart() from outside the Controller. Fix it.
            // TODO In which place of the code does "renewBarChart()" have to be placed for not to using so many dots? Maybe not in the "Controller"?
        };
    }

    public void paintByMatrix(double[][] matrix) {
        fillRoot();
        if (matrix.length != COL_COUNT) throw new PaintException();
        for (int col = 0; col < COL_COUNT; col++) {
            if (matrix[col].length != ROW_COUNT) throw new PaintException();
            for (int row = 0; row < ROW_COUNT; row++) {
                if (matrix[row][col] == 1) addNewPixel(row, col, PAINT_COLOR); //TODO Optimize "> 0.5"
            }
        }
    }

    public void registerController(Controller controller) {
        this.controller = controller;
    }

    public int getRowCount() {
        return ROW_COUNT;
    }

    public int getColCount() {
        return COL_COUNT;
    }

    public int getPixelCount() {
        return PIXEL_COUNT;
    }

    public double gethGap() {
        return H_GAP;
    }

    public double getvGap() {
        return V_GAP;
    }

    public double getPixelWidth() {
        return PIXEL_WIDTH;
    }

    public double getPixelHeight() {
        return PIXEL_HEIGHT;
    }

    public double[] getVector() {
        return VECTOR;
    }
}
