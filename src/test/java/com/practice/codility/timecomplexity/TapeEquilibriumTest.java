package com.practice.codility.timecomplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TapeEquilibriumTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void equilibriumTest(int[] array, int expected) {
		assertEquals(expected, TapeEquilibrium.equilibrium(array));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(new int[] { 3, 1, 2, 4, 3 }, 1)
		);
	}

}