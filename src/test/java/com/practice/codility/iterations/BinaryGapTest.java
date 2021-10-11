package com.practice.codility.iterations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BinaryGapTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void binaryGapTest(int n, int expected) {
		assertEquals(expected, BinaryGap.binaryGap(n));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(6, 0),
			arguments(9, 2),
			arguments(32, 0),
			arguments(1041, 5),
			arguments(529, 4),
			arguments(-1, 0)
		);
	}
}