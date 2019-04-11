package com.java.api.forloop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BreakStmtTest {

	int[] test = { 1, 2, 3 };
	
	int iUptoDate = 0;
	int jUptoDate = 0;

	void iterateTestArray() {
		label: for (int i : test) {
			this.iUptoDate = i;
			for (int j : test) {
				this.jUptoDate = j;
				if (i == 2)
					break label;
			}
		}
	}
	
	@Test
	void testBreakStmtInnerLoop () {
		iterateTestArray();
		assertEquals(2, this.iUptoDate);
		assertEquals(1, this.jUptoDate);
		System.out.println("This test asserts the functionality of break statement over Iterating an Array");
	}
	

}