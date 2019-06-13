package com.java.api.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.Apartment;
import com.java.api.model.House;

public class GenericsTestClass<T> {

	static final Logger logger = LoggerFactory.getLogger(GenericsTestClass.class);

	@Test
	public void testUnboundedWildCardTypes() {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5); // asList methods accepts varargs
	}

	public static void testMethodWithUnboundedWildCard(List<?> list1, List<?> list2) {
		for (Object object : list2) {
			if (list1.contains(object)) {
				logger.debug("{} element is common element in both lists", object);
			}
		}
	}

	@Test
	public void testGenericsInvariance() {

		House house1 = new House();
		House house2 = new House();
		Apartment apt1 = new Apartment();
		Apartment apt2 = new Apartment();

		List testList1 = new ArrayList();
		testList1.add(house1);
		testList1.add(house2);
		List testList2 = new ArrayList();
		testList2.add(apt1);
		testList2.add(apt2);
		testList1 = testList2;
		
		logger.debug("Here is the value of testList1 after assinging testList2: {} ", testList1);

		List<House> testList3 = new ArrayList<House>();
		testList3.add(house1);
		testList3.add(house2);

		List<Apartment> testList4 = new ArrayList<Apartment>();
		testList4.add(apt1);
		testList4.add(apt2);
		
		// Observe that below statement is not allowed and causes compilation error, because of Generic Invariance property
		// testList3 = testList4;
	}
	
	@Test
	public void testArgumentTypeInference() {
		testGenericMethodInvocation(3.0); // Parameter will be inferred as Double in this case
		testGenericMethodInvocation(3); // Parameter will be inferred as Integer in this case
		testGenericMethodInvocation("3"); // Parameter will be inferred as String in this case
		
		// Explicit Type inference
		this.<Double>testGenericMethodInvocation(3.0);
		
	}
	
	
	<E> void testGenericMethodInvocation(E testValue) {
		logger.debug("Value of the paramater passed: {} and its Type: {}", testValue, testValue.getClass());
	}
	
	// Using Class Type Parameter in method parameters
	void anotherTestGenericMethodInvocation(T testValue) {
		
	}
	
}
