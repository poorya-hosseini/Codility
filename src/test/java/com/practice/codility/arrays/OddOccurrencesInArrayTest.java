package com.practice.codility.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OddOccurrencesInArrayTest {

	@ParameterizedTest
	@MethodSource("testSource")
	void oddOccurrencesInArrayTest(int[] intArray, int expected) {
		assertEquals(expected, OddOccurrencesInArray.oddOccurrencesInArray(intArray));
	}

	private static Stream<Arguments> testSource() {
		return Stream.of(
			arguments(new int[] { 9, 3, 9, 3, 9, 7, 9 }, 7)
		);
	}
}