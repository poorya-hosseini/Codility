package com.practice.codility.arrays;

/**
 * <p>
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by
 * one index, and the last element of the array is moved to the first place. For example, the rotation of array
 * A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * </p>
 *
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * </p>
 *
 * <p>
 * Write a function that, given an array A consisting of N integers and an integer K, returns the array A rotated
 * K times.
 * </p>
 *
 * <p>
 * For example, given
 * </p>
 *
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * </p>
 *
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * </p>
 *
 * <p>
 * For another example, given
 * </p>
 *
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * </p>
 *
 * <p>
 * Given
 * </p>
 *
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * </p>
 *
 * <p>
 * Assume that:
 * </p>
 *
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * </p>
 *
 *
 * @author Pooria Hossein
 */
public class CyclicRotation {

	private CyclicRotation() {
	}

	public static int[] cyclicRotation(int[] array, int k) {
		int[] result = new int[array.length];
		if (array.length == 0 || k == 0) {
			return array;
		}
		int shr = k % array.length;
		for (int i = 0; i < array.length; i++) {
			result[i] = array[(array.length - shr + i) % array.length];
		}
		return result;
	}

}
