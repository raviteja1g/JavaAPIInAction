package com.java.api.oops.concepts.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Interfaces can only have default (only inside package) or public modifiers
//From Java 8 Interfaces can have default, static methods
//Interfaces can include nested types, i.e Nested classes, Nested Interfaces
public interface TestInterface extends ParentTestInterface {

	static final Logger logger = LoggerFactory.getLogger(TestInterface.class);

	// Interface variables are by default public, static and final
	int testVariable = 10;

	/**
	 * This method shows that From Java 8 Interfaces can also have main method as
	 * static methods are allowed
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		logger.debug("Execution of main method of an interface");
	}

	// Interface methods can only be public and all methods are public and abstract
	// by default
	public void testMethod();

	public static void testStaticMethodTestInterface() {
		logger.debug("Static testStaticMethoTestInterface implementation from TestInterface");
	}

	public abstract void testAbstractMethod();

	/**
	 * This method provides default implementation and default methods cannot be
	 * final and also cannot have synchronized modifier
	 */
	public default void defaultTestMethod() {
		// You cannot access Parent interface default implementation from a child
		// interface using super
		// ParentTestInterface.super.defaultTestMethod();
		logger.debug("Default defaultTestMethod implementation from TestInterface");

		// Invoking static method here
		testStaticMethodTestInterface();
	}

	public default void defaultAnotherTestMethod() {
		logger.debug("Default defaultAnotherTestMethod implementation from TestInterface");
	}

	// Nested class in Interface
	public class nestedTestClass {

	}

	// Nested class in Interface
	public interface nestedTestInterface {

	}

}
