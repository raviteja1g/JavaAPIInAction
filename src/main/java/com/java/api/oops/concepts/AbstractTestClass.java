package com.java.api.oops.concepts;

//Abstract classes can only have default or public modifiers
public abstract class AbstractTestClass implements TestInterface, ParentTestInterface {

	public abstract void abstractMethod();

	public void regularMethod() {

		// Since testVariable (i.e static) is both in TestInterface,
		// ParentTestInterface, It has to be accessed with Interface name
		// int x = testVariable;
		
		int x = TestInterface.testVariable;
		
		int y = ParentTestInterface.testVariable;
	}
}
