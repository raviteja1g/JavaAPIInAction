package com.java.api.threads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadClassTest extends Thread {
	
	public static Logger logger = LoggerFactory.getLogger(ThreadClassTest.class);
	
	public static void main(String[] args) {
		logger.debug("Main program execution started: {}", Thread.currentThread()); // Prints thread name, priorty, group
		Destruction aptDestruction = new Destruction();

		logger.debug("Ordering to start aptDestruction");
		aptDestruction.start();
		
		logger.debug("Continuing with main thread execution");
	}

}

class Destruction extends Thread {
	
	public static Logger logger = LoggerFactory.getLogger(Destruction.class);

	@Override
	public void run() {
		logger.debug("Destruction started: {}", Thread.currentThread());
		orderForScrapPickup();		
	}
	
	void orderForScrapPickup() {
		logger.debug("Making order for destruction scrap pickup");
	}
	
}

