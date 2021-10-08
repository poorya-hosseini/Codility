package com.practice.codility.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CyclicRotationTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void cyclicRotationTest(int[] array, int k, int[] expected) {
		assertArrayEquals(expected, CyclicRotation.cyclicRotation(array, k));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(new int[] { 3, 8, 9, 7, 6 }, 1, new int[] { 6, 3, 8, 9, 7 }),
			arguments(new int[] { 3, 8, 9, 7, 6 }, 3, new int[] { 9, 7, 6, 3, 8 }),
			arguments(new int[] { 1, 2, 3, 4 }, 4, new int[] { 1, 2, 3, 4 }),
			arguments(new int[] { 0, 0, 0 }, 1, new int[] { 0, 0, 0 })
		);
	}
}