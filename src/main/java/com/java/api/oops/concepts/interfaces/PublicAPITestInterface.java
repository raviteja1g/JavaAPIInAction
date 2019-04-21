package com.java.api.oops.concepts.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Have to be careful while designing interfaces as public API, As once published 
it becomes very difficult to distribute because existing implementations will fail to 
recompile (Before Java 8) when using new version till they implement new methods or changes.

To address evolution problem with Interfaces, Java introduced default methods as binary compatible,
which means implementations can work with new interface release without re-compilation
*/
public interface PublicAPITestInterface {
	
	static final Logger logger = LoggerFactory.getLogger(TestInterface.class);
	
	public void publicInterfaceMethod();
	
	public default void defaultTestMethod() {
		
		logger.debug("Default defaultTestMethod implementation from PublicAPITestInterface");
		
	}
	
	public default int defaultTestInternalMethod() {
		logger.debug("Default defaultTestInternalMethod implementation from PublicAPITestInterface");
		return 1;
	}

}
