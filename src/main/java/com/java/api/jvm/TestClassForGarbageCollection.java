package com.java.api.jvm;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.Apartment;
import com.java.api.model.House;

/**
 * Pass below VM arguments to observe the details printed to the console.
 * -Xms13m -Xmx15m -XX:+PrintGCDetails -XX:+UseSerialGC
 *
 */
public class TestClassForGarbageCollection {
	
	public static final Logger logger = LoggerFactory.getLogger(TestClassForGarbageCollection.class);
	
	//Abandoned Objects --> Any objects that do not have any active reference are eligible for Garbage collection
	
	/**
	 * Once testMethod completes execution, apt object is ready for GC because of its scope
	 */
	public void testObjScope() {
		Apartment apt = new Apartment();
	}
	
	static int[] testArray = new int[1024 * 1024 * 2]; // 8.4 MB approx (2M entries * 4b)
	
	/*
	 * Apartment object assigned to house variable is no more referenced after house variable is assigned a new house object and ready for GC
	 * Apartment object assigned to apt variable is is no more referenced and ready for GC after apt variable is assigned null
	 * 
	 */
	@Test
	public void testMethod() {
		
		House house = new Apartment();
		house = new House();  
		
		Apartment apt = new Apartment();
		apt = null;
	}
	
	
	

}
