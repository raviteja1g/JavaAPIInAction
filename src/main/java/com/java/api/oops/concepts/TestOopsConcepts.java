package com.java.api.oops.concepts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.Apartment;
import com.java.api.model.House;
import com.java.api.oops.concepts.interfaces.PublicAPITestInterface;
import com.java.api.oops.concepts.interfaces.TestInterface;

public class TestOopsConcepts extends AbstractTestClass implements TestInterface, PublicAPITestInterface {

	final Logger logger = LoggerFactory.getLogger(TestOopsConcepts.class);

	/**
	 * If an implementation exists in both abstract class and an interface as
	 * default method then Abstract class methods takes precedence
	 * 
	 * If you want to call interface default method, you will have use
	 * InterfaceName.super to access default implementation
	 */
	@Test
	public void testMethodInvocationThatExistsInBothAbstractAndInterfaceAsDefaultMethod() {
		Assertions.assertEquals(2, this.defaultTestInternalMethod());
		Assertions.assertEquals(1, PublicAPITestInterface.super.defaultTestInternalMethod());
	}

	@Test
	public void testExplicitCasting() {

		// Assigning sub class object to parent class reference
		House home = new Apartment();

		// Accessing subclass methods via parent class reference throws compiler error
		// since compiler checks whether method exists in parent class, so you need
		// explicit casting
		// home.isGatedCommunity();

		// Explicit casting with primitives
		int value = (int) 10.1;

		// Example of explicit casting (down casting) while assigning parent object to
		// child class
		// Explicit casting with objects is different from primitives because casting a
		// reference does not touch the object it refers to, but only labels the object
		// in another way expanding/narrowing opportunities to work with it
		Assertions.assertThrows(RuntimeException.class, () -> {
			// ClassCastException occur since the reference type does not match the type of
			// real object
			Apartment apt = (Apartment) new House();
		});

	}

	@Test
	public void checkStaticMethodsInerition() {
		// Static methods are inherited and hidden by subclasses static method with same
		// signature but not overridden (just like fields) 
		Apartment.greetingFromHouse();
	}

	@Test
	public void testDownCasting() {
		Assertions.assertThrows(ClassCastException.class, () -> {
			House house = new House();
			checkingAHouse(house);
		});
	}

	@Test
	public void testInstanceOfOperator() throws Exception {
		// Using instanceof operator will avoid class cast Exception when you are down
		// casting
		House house = new House();
		checkingOnlyAptHouse(house);

		Assertions.assertDoesNotThrow(() -> {
			House house1 = new Apartment();
			checkingOnlyAptHouse(house1);
		});

		logger.debug("Validity of instance of, house intance of Aparment: {} ", house instanceof Apartment);
		logger.debug("Validity of instance of, house intance of House: {} ", house instanceof House);

		house = new House();

		logger.debug("Validity of instance of, house intance of Aparment: {} ", house instanceof Apartment);

	}

	@Test
	public void checkObjectCloning() {
		House house = new House();
		Object obj = new Object();

		// Compile error since clone is a protected method
		// house.clone();
		// obj.clone();
	}

	public void checkingAHouse(House home) {
		boolean isHomeSecure = ((Apartment) home).isGatedCommunity();
	}

	public void checkingOnlyAptHouse(House home) throws Exception {
		if (home instanceof Apartment) {
			boolean isHomeSecure = ((Apartment) home).isGatedCommunity();
		}

		// Another way of casting using cast()
		if (Apartment.class.isInstance(home)) {
			boolean isHomeSecure = Apartment.class.cast(home).isGatedCommunity();
		}
	}

	/**
	 * This method is added only to test that CloneNotSupported Exception will be
	 * thrown if Cloneble Interface is not implemented
	 */
	public CloneableTestClass clone() throws CloneNotSupportedException {
		return (CloneableTestClass) super.clone();
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

	@Override
	public void abstractMethod() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void defaultTestMethod() {
		// TODO Auto-generated method stub
		PublicAPITestInterface.super.defaultTestMethod();
	}


}
