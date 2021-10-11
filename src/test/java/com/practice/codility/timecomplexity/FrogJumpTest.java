package com.practice.codility.timecomplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FrogJumpTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void frogJumpTest(int x, int y, int d, int expected) {
		assertEquals(expected, FrogJump.frogJump(x, y, d));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(10, 85, 30, 3)
		);
	}
}