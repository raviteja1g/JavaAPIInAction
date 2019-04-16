package com.java.api.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class House {
	
	static final Logger logger = LoggerFactory.getLogger(House.class);
	
	protected int numberOfRooms;

	protected String address;

	protected String space;

	public House() {
		super();
	}

	public House(int numberOfRooms, String address, String space) {
		super();
		this.numberOfRooms = numberOfRooms;
		this.address = address;
		this.space = space;
	}
	
	
	public static void greetingFromHouse() {
		logger.debug("Thanks for exploring our Houses");
	}
	
	// Irrespective of modifier you cannot have two methods with same name inside same class
	/* 
	 * public void greetingFromHouse() {
	 * logger.debug("Thanks for exploring our Houses"); }
	 */
	public String getAddress() {
		return address;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public String getSpace() {
		return space;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public void setSpace(String space) {
		this.space = space;
	}
	
	
	public int getAvgRentalPrice() {
		logger.debug("Calculating renatl price of House Instance");
		return this.numberOfRooms * 500;
	}
}
