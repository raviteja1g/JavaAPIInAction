package com.java.api.oops.concepts.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface ParentTestInterface {

	static final Logger logger = LoggerFactory.getLogger(TestInterface.class);

	int testVariable = 12;

	void parentTestInterfaceMethod();

	static void parentTestInterfaceStaticMethod() {

		logger.debug("Executing static method in parentTestInterfaceStaticMethod");

	}
}
