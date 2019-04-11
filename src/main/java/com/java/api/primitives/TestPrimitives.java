package com.java.api.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class TestPrimitives {

	int x = 1;

	int y = x + 1;
	
	@Test
	public void testBoxPrimitiveComparision () {
		
		Integer i = new Integer(3);
		Integer j = 3;
		
		Integer k = new Integer(3);
		
		assertEquals(i, k);
		
		System.out.println("Comparision of Box primitives: " + (i == k));
		System.out.println("Comparision of Box primitives using equals: " + (i.equals(k)));
	}

	@Test
	public void testPrimitives() {
		
		final int testVariable;
		
		// Final variables cannot be used without initialization, Uncomment the below line to see a compile Error		
		// System.out.println("Value of final variable which is primitive and not initialized: " + testVariable);

		// Arithmetic operators precedence, Unicode (UTF-16) of a is 97
		double x = 9 * 5 - 'a' / 5.0;

		System.out.println("Value of char a: " + x);
		System.out.println("Factorial of 3: " + factorial(3));
		System.out.println("Is number 454 palindrome: " + checkIfNumIsPalindrome(454));

		int[] testArray = { 1, 2, 4, 5, 8, 11, 15, 20 };
		int index = searchElement(testArray, 8);
		System.out.println("SearchElement index of 8 in [1, 2, 4, 5, 8, 11, 15, 20]  " + index);
	}

	// Here recursive code is cleaner but slower since on every invocation it has to
	// create stack and it also takes some space
	public int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public boolean checkIfNumIsPalindrome(int number) {

		// Example number : 454
		int origNum = number;
		int reverseNumber = 0;

		while (number > 0) {
			int rem = number % 10;
			reverseNumber = (reverseNumber * 10) + rem;
			number = number / 10;
		}

		if (origNum == reverseNumber) {
			return true;
		} else {
			return false;
		}
	}

	public int binarySearch(int[] testArray, int searchElement, int startIndex, int endIndex) {

		if (startIndex == endIndex) {
			if (searchElement == testArray[startIndex]) {
				return startIndex;
			} else {
				return -1;
			}
		}

		int middleIndex = (startIndex + endIndex) / 2;
		if (searchElement > testArray[middleIndex]) {
			binarySearch(testArray, searchElement, middleIndex, endIndex);
		} else if (searchElement < testArray[middleIndex]) {
			binarySearch(testArray, searchElement, startIndex, middleIndex);
		} else {
			return middleIndex;
		}
		return -1;
	}

	public int searchElement(int[] testArray, int searchElement) {
		// Assuming array is already sorted
		int startIndex = 1;
		int endIndex = testArray.length - 1;
		int searchElementIndex = binarySearch(testArray, searchElement, startIndex, endIndex);
		return searchElementIndex;
	}
}
