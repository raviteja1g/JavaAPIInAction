package com.java.api.jvm.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface ParentTestInterface {
	public static final Logger logger = LoggerFactory.getLogger(ParentTestInterface.class);

	static final double testVar = Math.random() * 5;

	static void testInterfaceStaticMethod() {
		logger.debug("Static Initliazer block started execution....");
	}

}

class TestClass {
	public static final Logger logger = LoggerFactory.getLogger(TestClass.class);
	
	TestClass() {
		logger.debug("Static Initliazer block started execution....");
	}
}

class ParentTestClass {

	public static final Logger logger = LoggerFactory.getLogger(ParentTestClass.class);

	static {
		logger.debug("Static Initliazer block started execution....");
	}

	{
		logger.debug("Instance block started execution....");
	}

	ParentTestClass() {
		logger.debug("ParentTestClass constructor block started execution....");
	}

}

class ChildTestClass extends ParentTestClass implements ParentTestInterface{

	public static final Logger logger = LoggerFactory.getLogger(ChildTestClass.class);

	public static final int testVar = 10;

	public static final double testVar2 = Math.random() * 10;

	static {
		logger.debug("Static Initliazer block started execution....");
	}

	{
		logger.debug("Instance block started execution....");
	}

	public ChildTestClass() {
		logger.debug("ChildTestClass constructor block started execution....");
	}

}

public class TestExecutionOrder {

	public static final Logger logger = LoggerFactory.getLogger(TestExecutionOrder.class);

	static {
		logger.debug("Static Initliazer block started execution....");
	}

	{
		logger.debug("Instance block started execution....");
	}

	/**
	 * Run this main method and Look for logging in console which will give you an
	 * idea of order of execution of different parts of the Java code
	 */
	public static void main(String[] args) {
		logger.debug("ChildTestClass Static final Variable: {} ", ChildTestClass.testVar);
		logger.debug("ChildTestClass Static final another Variable: {} ", ChildTestClass.testVar2);
		new ChildTestClass();
		logger.debug("ParentTestInterface Static final Variable: {} ", ParentTestInterface.testVar);
		
	}

}
