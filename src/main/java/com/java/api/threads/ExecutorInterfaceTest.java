package com.java.api.threads;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorInterfaceTest {
	
	public static Logger logger = LoggerFactory.getLogger(ExecutorInterfaceTest.class);

	public static void main(String[] args) {
		ThreadPerTaskExecutor executor = new ThreadPerTaskExecutor();

		executor.execute(new Construction() {
			@Override
			public void run() {
				logger.debug("Wokring with construction");
			}	
		});
		
		
		executor.execute(new Destruction() {
			@Override
			public void run() {
				logger.debug("Wokring with destroying house");
			}
		});
		
	}

}

class ThreadPerTaskExecutor implements Executor {

	@Override
	public void execute(Runnable task) {
		new Thread(task).start();
	}

}