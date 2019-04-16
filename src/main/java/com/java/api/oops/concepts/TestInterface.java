package com.java.api.oops.concepts;

//Interfaces can only have default (only inside package) or public modifiers
//From Java 8 Interfaces can have default, static methods
//Interfaces can include nested types, i.e Nested classes, Nested Interfaces
interface TestInterface extends ParentTestInterface{
	
	// Interface variables are by default public, static and final
	int testVariable = 10;

	// Interface methods can only be public and all methods are public and abstract by default
	public void testMethod();

	public abstract void testAbstractMethod();

	public default void defaultTestMethod() {

	}

	// Nested class in Interface
	public class nestedTestClass {

	}

	// Nested class in Interface
	public interface nestedTestInterface {

	}

}
