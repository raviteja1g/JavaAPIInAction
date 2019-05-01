package com.java.api.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.java.api.model.Apartment;
import com.java.api.model.House;

/**
 * Reflection is comparatively slower than regular invocations, so use with caution for performance intensive applications 
 *
 */
public class ReflectionTestClass {

	public static final Logger logger = LoggerFactory.getLogger(ReflectionTestClass.class);

	@Test
	public void testAccesingClassObjectUsingReflection() {

		Apartment apt = new Apartment();

		// Accessing class object using class literal
		logger.debug("Class Name read from class object of Apartment class: {}", Apartment.class.getName());
		logger.debug("Super Class name of Apartment Class: {}", Apartment.class.getSuperclass().getName());

		// Accessing class object using forName
		try {
			logger.debug("Loading Apartment class to memory and reading fullly qualified Class name:  {}",
					Class.forName("com.java.api.model.Apartment").getName());
		} catch (ClassNotFoundException ex) {
			logger.error("Exception occured while loading Apartment class {}", ex);
		}

		// Accessing class object using getClass()
		logger.debug("Class Name read from class object of Apartment class: {}", apt.getClass().getName());

		// Accessing class object for primitives using TYPE
		logger.debug("Class Name read from class object of Apartment class: {}", Boolean.TYPE.getName());
		logger.debug("Class Name read from class object of Apartment class: {}", Void.TYPE.getName());
	}

	@ParameterizedTest
	@ValueSource(classes = { Apartment.class })
	public void testObjectCreationAndMethodInovationUsingReflection(Class<House> clazz) {

		try {
			Object obj = clazz.newInstance();
			if (obj instanceof Apartment) {
				logger.debug("Default Name: {}, address set to Apartment instance: {}", ((Apartment) obj).getAptName(),
						((Apartment) obj).getAddress());
			}

		} catch (IllegalAccessException | InstantiationException ex) {
			logger.debug("Exception occurred while creating instance for Aparment class", ex);
		}

		Method[] declaredMethods = clazz.getDeclaredMethods();

		for (Method method : declaredMethods) {
			logger.debug("Method name from clazz object: {}", method.getName());
		}

		for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
			logger.debug("Number of paramters of constructor from clazz object: {} ", constructor.getParameterCount());
		}

		// Invoking particular constructor
		try {
			Constructor<House> constructor = clazz.getDeclaredConstructor(String.class, int.class, String.class,
					String.class, boolean.class, String.class);
			House house = constructor.newInstance("TestApt", 2, "Test Address", "1024sqft", false, "");
			
			Method declaredMethod = clazz.getDeclaredMethod("getAptName");
			Object aptName = declaredMethod.invoke(house);
			logger.debug("Apartment name returned from the method  clazz object: {}", aptName);
			
		} catch (NoSuchMethodException | SecurityException ex) {
			// TODO Auto-generated catch block
			logger.error("Exception occurred while retrieving constructor/method from class object ", ex);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException ex) {
			logger.error("Exception occurred while creating an instance through constructor/ Invoking a method from class object ", ex);
		}
		
	}

}
