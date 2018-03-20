package me.practice.algo;

public class RainWaterFillingProblem {

	private final int[] xDirection;
	private final int[] yDirection;
	private final int[] inputArr;

	public RainWaterFillingProblem(int[] val) {
		this.inputArr = val;
		this.xDirection = new int[val.length];
		this.yDirection = new int[val.length];
	}

	public int[] solve() {
		int[] result = new int[inputArr.length];
		xDirection[0] = inputArr[0];
		yDirection[inputArr.length - 1] = inputArr[inputArr.length - 1];
		for (int i = 1; i < inputArr.length; i++)
			xDirection[i] = Math.max(xDirection[i - 1], inputArr[i]);

		for (int i = inputArr.length - 2; i >= 0; i--)
			yDirection[i] = Math.max(yDirection[i + 1], inputArr[i]);

		for (int i = 0; i < inputArr.length; i++) {
			result[i] = Math.min(xDirection[i], yDirection[i]) - inputArr[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int[] result = new RainWaterFillingProblem(arr).solve();
		int r = 0;
		for(int i =0;i<result.length;i++) {
			System.out.print(result[i] + " , ");
			r += result[i];
		}
		System.out.println("");
		System.out.println("Water accumulated : " + r);
	}

}
