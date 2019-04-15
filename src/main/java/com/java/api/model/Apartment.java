package com.java.api.model;

public class Apartment extends House {

	private boolean gatedCommunity;

	private String floorNumber;

	public Apartment() {
		super();
	}

	public Apartment(int numberOfRooms, String address, String space, boolean gatedCommunity, String floorNumber) {
		super(numberOfRooms, address, space);
		this.gatedCommunity = gatedCommunity;
		this.floorNumber = floorNumber;
	}
	
	// Cannot reduce method visibility for overridden methods
	// default int getNumberOfRooms() will throw compile time error
	@Override
	public int getNumberOfRooms() {
		return super.numberOfRooms;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public boolean isGatedCommunity() {
		return gatedCommunity;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void setGatedCommunity(boolean gatedCommunity) {
		this.gatedCommunity = gatedCommunity;
	}
	
	@Override
	public int getAvgRentalPrice() {
		logger.debug("Calculating renatl price of Apt Instance");
		return this.numberOfRooms * 300;
	}
	
}
