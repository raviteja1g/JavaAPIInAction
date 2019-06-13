package com.java.api.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableInterfaceThreadTest {
	
	public static Logger logger = LoggerFactory.getLogger(RunnableInterfaceThreadTest.class);
	
	public static void main(String[] args) {
		logger.debug("Main program execution started");
		Construction houseConstruction = new Construction();
		Thread thread = new Thread(houseConstruction);
		
		logger.debug("Ordering to start houseConstruction");
		thread.start();
		
		logger.debug("Continuing with main thread execution");
	}

}

class Construction implements Runnable {
	
	public static Logger logger = LoggerFactory.getLogger(Construction.class);

	@Override
	public void run() {
		logger.debug("Construction started");
		makeOrderForConstructionMaterial();		
	}
	
	void makeOrderForConstructionMaterial() {
		logger.debug("Making order for construction material");
	}
	
}
