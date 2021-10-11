package com.practice.codility.timecomplexity;

/**
 * <p>
 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which
 * means that exactly one element is missing.
 * </p>
 * <p>
 * Your goal is to find that missing element.
 * </p>
 * <p>
 * Write a function that, given an array A, returns the value of the missing element.
 * </p>
 * <p>
 * For example, given array A such that:
 * </p>
 * <p>
 * A[0] = 2
 * A[1] = 3
 * A[2] = 1
 * A[3] = 5
 * the function should return 4, as it is the missing element.
 * </p>
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * </p>
 * <p>
 * N is an integer within the range [0..100,000];
 * the elements of A are all distinct;
 * each element of array A is an integer within the range [1..(N + 1)].
 * </p>
 */
public class PermMissingElem {

	private PermMissingElem() {
	}

	public static int permMissingElem(int[] a) {
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum ^= a[i] ^ (i + 1);
		}
		return sum ^ (a.length + 1);
	}

}
