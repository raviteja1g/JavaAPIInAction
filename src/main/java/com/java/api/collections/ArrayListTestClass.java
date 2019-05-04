package com.java.api.collections;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArrayListTestClass {

	public static final Logger logger = LoggerFactory.getLogger(ArrayListTestClass.class);

	// ConcurrentModificationException

	@Test
	public void testArraySubList() {

		/**
		 * Array List is a resizable array -- Default size is 10 and increases by 50% --
		 * You can specify the size or invoke ensureCapacity()
		 * 
		 */

		List<Integer> originalTestList = new ArrayList<Integer>();

		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> accessIndexBeyondDefaultSize(originalTestList));

		originalTestList.add(1);
		originalTestList.add(2);
		originalTestList.add(3);
		originalTestList.add(4);
		originalTestList.add(5);
		originalTestList.add(6);

		List<Integer> testSubList = originalTestList.subList(2, 4);

		// Cannot make any structural changes to the original list

		Assertions.assertThrows(ConcurrentModificationException.class, () -> {
			originalTestList.add(2, 20);
			System.out.println("Original List and Sub list created from it " + originalTestList + testSubList);
		});

		
		// Removing the element from an ArrayList within the same Iteration using forEach can throw ConcurrentModification Exception
		Assertions.assertThrows(ConcurrentModificationException.class, () -> {
			for (Integer test : originalTestList) {
				if (test == 4) {
					originalTestList.remove(test);
				}
			}
		});
		
		// ConcurrentModification Exception is not always guaranteed and below is the example while removing the element at index of (length of list - 1)
		Assertions.assertDoesNotThrow(() -> {
			for (Integer test : originalTestList) {
				if (test == 5) {
					originalTestList.remove(test);
				}
			}
		});

	}

	public void accessIndexBeyondDefaultSize(List<Integer> testList) {
		testList.subList(0, 1);
	}

}
