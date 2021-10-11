package com.practice.codility.countingelements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FrogRiverOneTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void frogRiverOneTest(int x, int[] array, int expected) {
		assertEquals(expected, FrogRiverOne.frogRiverOne(x, array));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }, 6)
		);
	}
}