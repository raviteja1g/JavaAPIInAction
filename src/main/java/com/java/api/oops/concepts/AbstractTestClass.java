package com.java.api.oops.concepts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.oops.concepts.interfaces.ParentTestInterface;
import com.java.api.oops.concepts.interfaces.TestInterface;

//Abstract classes can only have default or public modifiers
public abstract class AbstractTestClass implements TestInterface, ParentTestInterface {
	
	static final Logger logger = LoggerFactory.getLogger(AbstractTestClass.class);

	public abstract void abstractMethod();
	
	public int defaultTestInternalMethod() {
		
		logger.debug("Default defaultTestInternalMethod implementation from PublicAPITestInterface");
		
		return 2;
	}

	public void regularMethod() {

		// Since testVariable (i.e static) is both in TestInterface,
		// ParentTestInterface, It has to be accessed with Interface name
		// int x = testVariable;
		
		int x = TestInterface.testVariable;
		
		int y = ParentTestInterface.testVariable;
	}
}
