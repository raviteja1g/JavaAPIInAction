package com.java.api.arrays;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.collections.ArrayListTestClass;

public class ArraysTest {
	
	public static final Logger logger = LoggerFactory.getLogger(ArraysTest.class);
	
	@Test
	public void testArrayInitialization() {
		
		//Array initialization using new
		int[] testIntArray = new int[5];
		//Array initialization using literals
		double[] testDoubleArray = {1.0, 2.5, 3.5};		
		
	}
	
	@Test
	public void testArrayExceptions() {
		char[] data = {'h', 'e', 'l', 'l', 'o'};
		
		String i = "10";
		
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			data[6] = 'l';
		});
		
	}
	
	@Test
	public void testArraySorting() {
		
		int[] testIntArray = new int[]{234, 4353, 234, 232, 123};
		
		Arrays.parallelSort(testIntArray); // From java 8, This parallel sorting is useful if you are dealing with large arrays (of size more than 8912)
		
		logger.debug("testIntArray after sorting: {} ", testIntArray);
		
	}
	
	

}
