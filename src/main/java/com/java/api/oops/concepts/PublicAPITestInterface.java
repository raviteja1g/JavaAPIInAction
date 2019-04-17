package com.java.api.oops.concepts;

/*Have to be careful while designing interfaces as public API, As once published 
it becomes very difficult to distribute because existing implementations will fail to 
recompile when using new version till they implement new methods or changes.*/
public interface PublicAPITestInterface {
	
	public void publicInterfaceMethod();

}
