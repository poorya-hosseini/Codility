package com.practice.codility.countingelements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PermCheckTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void permCheckTest(int[] array, int expected) {
		assertEquals(expected, PermCheck.permCheck(array));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(new int[] { 4, 1, 3 }, 0),
			arguments(new int[] { 4, 1, 3, 2 }, 1),
			arguments(new int[] { 1, 2, 3, 5 }, 0),
			arguments(new int[] { 5, 4, 3, 2 }, 0),
			arguments(new int[] { 1 }, 1)
		);
	}
}