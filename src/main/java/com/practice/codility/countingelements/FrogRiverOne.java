package com.practice.codility.countingelements;

/**
 * <p>
 * A small frog wants to get to the other side of a river. The frog is initially located on one bank of the river
 * (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from a tree onto the surface of the
 * river.
 * </p>
 * <p>
 * You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where
 * one leaf falls at time K, measured in seconds.
 * </p>
 * <p>
 * The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only
 * when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when
 * all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is
 * negligibly small, i.e. the leaves do not change their positions once they fall in the river.
 * </p>
 * <p>
 * For example, you are given integer X = 5 and array A such that:
 * </p>
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * </p>
 * <p>
 * In second 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the
 * river.
 * </p>
 * <p>
 * Write a function that, given a non-empty array A consisting of N integers and integer X, returns the earliest time
 * when the frog can jump to the other side of the river.
 * </p>
 * <p>
 * If the frog is never able to jump to the other side of the river, the function should return −1.
 * </p>
 * <p>
 * For example, given X = 5 and array A such that:
 * </p>
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 1
 * A[3] = 4
 * A[4] = 2
 * A[5] = 3
 * A[6] = 5
 * A[7] = 4
 * </p>
 * <p>
 * the function should return 6, as explained above.
 * </p>
 * <p>
 * Write an efficient algorithm for the following assumptions:
 * </p>
 * <p>
 * N and X are integers within the range [1..100,000];
 * each element of array A is an integer within the range [1..X].
 * </p>
 */
public class FrogRiverOne {

	private FrogRiverOne() {
	}

	public static int frogRiverOne(int x, int[] array) {
		boolean[] path = new boolean[x];
		for (int i = 0; i < x; i++) {
			path[i] = false;
		}
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			if (!path[array[i] - 1]) {
				path[array[i] - 1] = true;
				sum++;
				if (sum == x) {
					return i;
				}
			}
		}
		return -1;
	}
}
