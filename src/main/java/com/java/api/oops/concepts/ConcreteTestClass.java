package com.java.api.oops.concepts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.oops.concepts.interfaces.FunctionalInterfaceTest;

public class ConcreteTestClass {

	public static final Logger logger = LoggerFactory.getLogger(ConcreteTestClass.class);

	@Test
	public void testLambdaFunction() {
		lambdaTestMethod(() -> logger.debug("Executing implemntation from testLambdaFuction"));
	}

	void lambdaTestMethod(FunctionalInterfaceTest funcTest) {
		funcTest.testMethod();
	}

	@Test
	public void testProtectedMembersAcces() {

		HiTechApartment hitechApt = new HiTechApartment();

		hitechApt.isAptDigitallySecure(hitechApt);

		/*
		 * Compilation error while accessing protected members of HiTechApartment
		 * (inherited from its superclass Apartment) even though it is with in the same
		 * package because You cannot access protected members of a class outside its
		 * package via a sub class. This is why protected members are helpful For
		 * example: clone() in Object class is protected
		 */

		// hitechApt.isDigitalLockAvailable();
		// hitechApt.digitalLockAvailable;

		CloneableTestClass testObject = new CloneableTestClass();

		TestOopsConcepts testObjOfClassNotImplementedCloneble = new TestOopsConcepts();

		Assertions.assertDoesNotThrow(() -> testObject.clone());
		Assertions.assertThrows(CloneNotSupportedException.class, () -> testObjOfClassNotImplementedCloneble.clone());

	}

}
