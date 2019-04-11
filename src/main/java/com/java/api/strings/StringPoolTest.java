package com.java.api.strings;

import org.junit.jupiter.api.Test;

public class StringPoolTest {

	@Test
	public void testStringObject() {

		String testLiteral = "Test";
		String anotherTestLiteral = "Test";
		String testStringViaNew = new String("Test");
		String differentTest = "Different Test";

		String sameAsDifferentTestLiteral = "Different " + "Test";

		String runtimeTestLiteral = "Different " + testLiteral;

		final String anotherTest = "Test";

		String anotherDifferentTestLiteral = "Different " + anotherTest;

		System.out.println("Here is the comparision of testLiteral and anotherTestLiteral: "
				+ (testLiteral == anotherTestLiteral));
		System.out
				.println("Here is the comparision of testLiteral and differentTest: " + (testLiteral == differentTest));
		System.out.println(
				"Here is the comparision of testLiteral and testStringViaNew: " + (testLiteral == testStringViaNew));

		// Intern() in the method used internally every time you create a String object
		System.out.println("Here is the comparision of testLiteral and testStringViaNew Interning: "
				+ (testLiteral == testStringViaNew.intern()));

		System.out.println("Here is the comparision of differentTest with sameAsDifferentTestLiteral: "
				+ (sameAsDifferentTestLiteral == differentTest));

		System.out.println("Here is the comparision of differentTest with anotherDifferentTestLiteral: "
				+ (sameAsDifferentTestLiteral == anotherDifferentTestLiteral));

		// Below comparison returns false because runtimeTestLiteral value is not known
		// at compile time
		System.out.println("Here is the comparision of differentTest with runtimeTestLiteral: "
				+ (runtimeTestLiteral == differentTest));
	}
}
