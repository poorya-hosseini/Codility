package com.practice.codility.timecomplexity;

/**
 * <p>
 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
 * </p>
 * <p>
 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts:
 * A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
 * The difference between the two parts is the value of:
 * |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
 * </p>
 * <p>
 * For example, consider array A such that:
 * </p>
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * </p>
 * We can split this tape in four places:
 * </p>
 * <p>
 * P = 1, difference = |3 − 10| = 7
 * P = 2, difference = |4 − 9| = 5
 * P = 3, difference = |6 − 7| = 1
 * P = 4, difference = |10 − 3| = 7
 * </p>
 * <p>
 * Write a function that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
 * </p>
 * <p>
 * For example, given:
 * </p>
 * <p>
 * A[0] = 3
 * A[1] = 1
 * A[2] = 2
 * A[3] = 4
 * A[4] = 3
 * </p>
 * <p>
 * the function should return 1, as explained above.
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [2..100,000];
 * each element of array A is an integer within the range [−1,000..1,000].
 * </p>
 */
public class TapeEquilibrium {

	private TapeEquilibrium() {
	}

	public static int equilibrium(int[] array) {
		int[] leftSum = new int[array.length];
		int[] rightSum = new int[array.length];
		int left = 0;
		int right = 0;

		int n = array.length;
		for (int i = 0; i < array.length; i++) {
			left += array[i];
			leftSum[i] = left;
			right += array[n - 1 - i];
			rightSum[n - 1 - i] = right;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length - 1; i++) {
			int sub = Math.abs(leftSum[i] - rightSum[i + 1]);
			if (sub < min) {
				min = sub;
			}
		}
		return min;
	}
}
