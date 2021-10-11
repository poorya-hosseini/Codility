package com.practice.codility.countingelements;

/**
 * <p>
 * A non-empty array A consisting of N integers is given. A permutation is a sequence containing each element
 * from 1 to N once, and only once.
 * </p>
 * <p>
 * For example, array A such that:
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * </p>
 * <p>
 * is a permutation, but array A such that:
 * </p>
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * </p>
 * <p>
 * is not a permutation, because value 2 is missing.
 * </p>
 * <p>
 * The goal is to check whether array A is a permutation.
 * <p>
 * Write a function that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
 * </p>
 * <p>
 * For example, given array A such that:
 * </p>
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * </p>
 * the function should return 1.
 * </p>
 * <p>
 * Given array A such that:
 * </p>
 * <p>
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * the function should return 0.
 * </p>
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * </p>
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [1..1,000,000,000].
 * </p>
 */
public class PermCheck {

	private PermCheck() {
	}

	public static int permCheck(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum ^= array[i] ^ (i + 1);
		}
		if (sum == 0) {
			return 1;
		}
		return 0;
	}
}
