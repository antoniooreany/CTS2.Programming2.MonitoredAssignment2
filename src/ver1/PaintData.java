package ver1;

import java.util.Random;

public class PaintData {

    public static double[][] getPixelsRowCol(double[][] pattern) {
        if (Main.leftSide.netLearnButtonPane.NOISE_BTN.isSelected()) return applyNoise(pattern);
        else return pattern;
    }

    public static double[][] applyNoise(double[][] pattern) {
        double[][] result = new double[Main.ROW_COUNT][Main.COL_COUNT];
        Random random = new Random();
        for (int col = 0; col < Main.rightSide.colCount; col++) {
            for (int row = 0; row < Main.rightSide.rowCount; row++) {
                result[row][col] = pattern[row][col];
                if (random.nextDouble() < 0.1) {
                    if (pattern[row][col] == 0) result[row][col] = 1; //TODO Optimize "< 0.5"
                    else result[row][col] = 0;
                }
            }
        }
        return result;
    }

    public static double[] getPixelsSequenceNumbers(double[][] pattern) {
        double[] result = new double[pattern.length * pattern[0].length]; //TODO NPE
        for (int col = 0; col < pattern.length; col++) {
            for (int row = 0; row < pattern[col].length; row++) {
                result[row * Main.ROW_COUNT + col] = pattern[row][col];
            }
        }
        return result;
    }

}
