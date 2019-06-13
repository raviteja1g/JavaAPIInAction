package com.java.api.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

	}

	@Test
	public void testArrayModifications() {

		List<Integer> originalTestList = new ArrayList<Integer>();

		originalTestList.add(1);
		originalTestList.add(2);
		originalTestList.add(3);
		originalTestList.add(4);
		originalTestList.add(5);
		originalTestList.add(6);

		// Removing the element from an ArrayList within the same Iteration using
		// forEach can throw ConcurrentModification Exception
		Assertions.assertThrows(ConcurrentModificationException.class, () -> {
			for (Integer test : originalTestList) {
				if (test == 4) {
					originalTestList.remove(test);
				}
			}
		});

		// ConcurrentModification Exception is not always guaranteed on remove() and
		// below is the example while removing the element at index of (length of list -
		// 1).
		// Below case happens because underlying Iterator being used did not throw this
		// exception
		Assertions.assertDoesNotThrow(() -> {
			for (Integer test : originalTestList) {
				if (test == 5) {
					originalTestList.remove(test);
				}
			}
		});

		Assertions.assertDoesNotThrow(() -> {
			Iterator<Integer> iterator = originalTestList.iterator();
			while (iterator.hasNext()) {
				int test = iterator.next();
				if (test == 4) {
					iterator.remove();
				}
			}
		});

	}

	@Test
	public void testCreateModifiableArrayListFromArrays() {
		
		int[] testArrayWithPrimitiveInt = {1,5,4,8,};
		
		Integer[] testArray = {1,2,3,4,5};
		
		// Arrays are not auto boxable
		// testArray = testArrayWithPrimitiveInt;
		
		List<Integer> testList = Arrays.asList(testArray); // Returns a fixed size list
		
		testList = new ArrayList<>(testList); // Modifiable list
		
		testList.add(6);
		
		logger.debug("Modified List: {}", testList);
		
	}
	
	@Test
	public void testListIterator() {
		
		List<Integer> originalTestList = new ArrayList<Integer>();

		originalTestList.add(1);
		originalTestList.add(2);
		originalTestList.add(3);
		originalTestList.add(4);
		originalTestList.add(5);
		originalTestList.add(6);
		
		ListIterator<Integer> listIterator = originalTestList.listIterator();

		// For ListIterator, the previous call to remove/set method must be next() or previous() methods
		Assertions.assertThrows(IllegalStateException.class, () -> {
			while (listIterator.hasNext()) {
				int test = listIterator.next();
				if (test == 4) {
					listIterator.add(4);
					// listIterator.remove();
					listIterator.set(0);
				}
			}
		});
		
		logger.debug("Original List after removal of element 4: {}", originalTestList);
	}

	public void accessIndexBeyondDefaultSize(List<Integer> testList) {
		testList.subList(0, 1);
	}
	
	

}
