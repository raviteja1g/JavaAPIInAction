package com.java.api.oops.concepts;

public class CloneableTestClass implements Cloneable {

	// Cloneable interface is marker interface and you don't have to implement any
	// methods

	int testVariable = 1;

	/**
	 * Since clone() in Object class is protected, Only subclasses can call clone(),
	 * so you cannot expect clone() method can be called directly on any Class
	 * object which can invoke clone() of Object class though it is a global parent
	 * Class
	 * 
	 * For this reason of Java forcing implementation of clone() method for an
	 * Class object to be Cloneble, It is considered as design flaw of Java by certain
	 * authors for Java having Cloneable method as marker interface 
	 */
	public CloneableTestClass clone() throws CloneNotSupportedException {
		return (CloneableTestClass) super.clone();
	}
	
	
	

}
