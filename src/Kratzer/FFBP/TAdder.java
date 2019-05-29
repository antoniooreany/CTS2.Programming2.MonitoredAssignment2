package Kratzer.FFBP;

import java.util.Random;

import ffbp.*;

public class TAdder {

	public static void main(String[] args) {
		
		int[] layout = {6, 15, 4};
		FFBP nn = new FFBP(layout);
		nn.randomize(-0.05, +0.05);
		nn.setEta(0.3);
		nn.setAlpha(0.8);
		
		Random r = new Random();
		
		for (int i = 0; i <= 1000000; ++i) {
			int addend1 = r.nextInt(8);
			int addend2 = r.nextInt(8);
			double[] v1 = intToVector(addend1, 3);
			double[] v2 = intToVector(addend2, 3);
			double[] iv = concatenateVectors(v1, v2);
			nn.activateInputAndFeedForward(iv);
			int sum = addend1 + addend2;
			double[] ov = intToVector(sum, 4);
			nn.applyDesiredOutputAndPropagateBack(ov);
			if (i % 5000 != 0) continue;
			Terminal.put("-------------------\n"+ i + " cycles:");
			int errors = 0;
			for (addend1 = 0; addend1 < 8; ++addend1)
				for (addend2 = 0; addend2 < 8; ++addend2) {
					v1 = intToVector(addend1, 3);
					v2 = intToVector(addend2, 3);
					iv = concatenateVectors(v1, v2);
					nn.activateInputAndFeedForward(iv);
					int result = (nn.getOutput()[0] > 0.5 ? 1 : 0) * 1 +
							(nn.getOutput()[1] > 0.5 ? 1 : 0) * 2 +
							(nn.getOutput()[2] > 0.5 ? 1 : 0) * 4 +
							(nn.getOutput()[3] > 0.5 ? 1 : 0) * 8;
					Terminal.put(addend1 + " + " + addend2 + " = " + result +
							(result == addend1 + addend2 ? "" : "   *"));
					errors += (result == addend1 + addend2 ? 0 : 1);
				}
			Terminal.put("Errors: " + errors);
			if (Terminal.getString("Continue ?").length() > 0) break;
			
		}
	}
	
	private static double[] intToVector(int value, int dim) {
		
		double[] result = new double[dim];
		
		for (int i = 0; i < dim; ++i) {
			result[i] = (value % 2 == 1) ? 1.0 : 0.0;
			value /= 2;
		}
		
		return result;
	}
	
	private static double[] concatenateVectors(double[] v1, double[] v2) {

		double[] result = new double[v1.length + v2.length];
		
		int i = 0;
		
		for (int j = 0; j < v1.length; ++i, ++j) {
			result[i] = v1[j];
		}
				
		for (int j = 0; j < v2.length; ++i, ++j) {
			result[i] = v2[j];
		}

		return result;
			
	}
	
}
