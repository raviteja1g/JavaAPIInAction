package com.java.api.arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysTest {
	
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
		
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			data[6] = 'l';
		});
		
	}

}
