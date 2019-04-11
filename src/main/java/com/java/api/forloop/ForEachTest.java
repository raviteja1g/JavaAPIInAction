package com.java.api.forloop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForEachTest {

	/*
	 * ForEach is generally preferred wherever possible for better readability
	 * Traditional for loop is needed when you need access to index, Parallel
	 * iteration and backward iteration, Filtering
	 */

	// Null pointer can occur with for each too

	@Test
	public void testForLoopVariations() {
		Boolean[] testCaseResults = { true, false, true, false };

		// Test case to show that for each also throws null pointer exception when array
		// is null
		try {
			testForEach(testCaseResults);
		} catch (Exception ex) {
			System.out.println("Exception caught while executing forEach");

		}

		// Test case to show that Traditional for loop throws null pointer exception
		// when array is null
		try {
			testTraditionalForLoop(testCaseResults);
		} catch (Exception ex) {
			System.out.println("Exception caught while executing traditional for loop");
		}

		Assertions.assertThrows(NullPointerException.class, () -> {
			Boolean[] testResults = null;
			testForEach(testResults);
		});

		Assertions.assertThrows(NullPointerException.class, () -> {
			Boolean[] testResults = null;
			testTraditionalForLoop(testResults);
		});
	}

	public void testForEach(Boolean[] testCaseResults) {
		for (Boolean eachTest : testCaseResults) {
			System.out.println(eachTest);
		}
	}

	public void testTraditionalForLoop(Boolean[] testCaseResults) {
		for (int i = 0; i < testCaseResults.length; i++) {
			System.out.println(testCaseResults[i]);
		}
	}

}
