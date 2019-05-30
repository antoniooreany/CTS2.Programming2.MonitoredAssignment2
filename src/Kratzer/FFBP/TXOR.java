package Kratzer.FFBP;

import java.util.Random;

import ffbp.*;

public class TXOR {

	public static void main(String[] args) {
		
		int[] layout = {2, 2, 1};
		FFBP nn = new FFBP(layout);
		nn.randomize(-0.33, +0.33);
		nn.setEta(0.3);
		nn.setAlpha(0.8);
		double[] iv0 = {0.0, 0.0}; 
		double[] iv1 = {0.0, 1.0}; 
		double[] iv2 = {1.0, 0.0}; 
		double[] iv3 = {1.0, 1.0};

		double[] ov0 = {0.0}; 
		double[] ov1 = {1.0}; 
		double[] ov2 = {1.0}; 
		double[] ov3 = {0.0}; 
		
		Random r = new Random();
		
		for (int i = 0; i <= 100000; ++i) {
			switch (r.nextInt(4)) {
			case 0: 
				nn.activateInputAndFeedForward(iv0);
				nn.applyDesiredOutputAndPropagateBack(ov0);
				break;
			case 1: 
				nn.activateInputAndFeedForward(iv1);
				nn.applyDesiredOutputAndPropagateBack(ov1);
				break;
			case 2: 
				nn.activateInputAndFeedForward(iv2);
				nn.applyDesiredOutputAndPropagateBack(ov2);
				break;
			case 3: 
				nn.activateInputAndFeedForward(iv3);
				nn.applyDesiredOutputAndPropagateBack(ov3);
				break;
			}
			if (i % 500 != 0) continue;
			Terminal.put("-------------------\n"+ i + " cycles:");
			nn.activateInputAndFeedForward(iv0);
			Terminal.put("0 / 0  >>  " + nn.getOutput()[0]);
			nn.activateInputAndFeedForward(iv1);
			Terminal.put("0 / 1  >>  " + nn.getOutput()[0]);
			nn.activateInputAndFeedForward(iv2);
			Terminal.put("1 / 0  >>  " + nn.getOutput()[0]);
			nn.activateInputAndFeedForward(iv3);
			Terminal.put("1 / 1  >>  " + nn.getOutput()[0]);
			if (Terminal.getString("").length() != 0) break;
		}
	}
}
