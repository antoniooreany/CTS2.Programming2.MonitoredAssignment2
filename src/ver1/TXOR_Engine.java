package ver1;

import ffbp.FFBP;

public class TXOR_Engine {

    private static int cyclesCount = 500;

    public static double[] run(double[] iv) {
        double[] ov = new double[8];
        int[] layout = {256, 16, 8};
        FFBP nn = new FFBP(layout);
        nn.randomize(-0.1, +0.1);
        nn.setEta(0.5);
        nn.setAlpha(0.5);

//        Random r = new Random();

        for (int cycle = 0; cycle <= cyclesCount; ++cycle) {
            for (int sequenceNumber = 0; sequenceNumber < Main.ROW_COUNT * Main.COL_COUNT; sequenceNumber++) {
                nn.activateInputAndFeedForward(iv); //TODO NPE
                nn.applyDesiredOutputAndPropagateBack(ov);
            }
        }
        return nn.getOutput();

    }
}
