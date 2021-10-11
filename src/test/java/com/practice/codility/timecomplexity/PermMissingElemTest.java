package com.practice.codility.timecomplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PermMissingElemTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void permMissingElem(int[] elements, int expected) {
		assertEquals(expected, PermMissingElem.permMissingElem(elements));

	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(new int[] { 1, 7, 4, 3, 2, 9, 8, 6 }, 5)
		);
	}
}