package com.java.api.oops.concepts.interfaces;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInterfaceConcepts implements TestInterface, PublicAPITestInterface {
	
	final Logger logger = LoggerFactory.getLogger(TestInterfaceConcepts.class);
	
	/**
	 * Default methods should to be overridden in implementing classes if method
	 * exists in more than one Interfaces with at least one interface having it as
	 * default method (i.e with different default implementations)
	 */
	@Override
	public void defaultTestMethod() {
		// TODO Auto-generated method stub
		PublicAPITestInterface.super.defaultTestMethod();
	}
	
	@Test
	public void testInterfaceStaticMethodInheritance() {
	
		// Compilation error trying to invoke a parentTestInterface method through TestInterface (As Static methods in Interface are not inherited)
		// TestInterface.parentTestInterfaceStaticMethod();
		
		// Compilation error trying to invoke a static TestInterface method even in sub class (As Static methods in Interface are not inherited)
		// this.testStaticMethodTestInterface();

		// Accessing static method directly using Interface name
		ParentTestInterface.parentTestInterfaceStaticMethod();
		
		// Indirect access to Interface static methods, accessing default methods and static method can be called in default methods in interfaces
		this.defaultTestMethod();
		
	
	}
	

	@Override
	public void parentTestInterfaceMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void publicInterfaceMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testMethod() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void testAbstractMethod() {
		// TODO Auto-generated method stub
		
	}


}
