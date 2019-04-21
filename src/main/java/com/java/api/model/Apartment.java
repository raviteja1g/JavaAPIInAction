package com.java.api.model;

public class Apartment extends House {

	private final String aptName;

	private boolean gatedCommunity;

	private String floorNumber;

	protected boolean digitalLockAvailable;

	public Apartment() {
		super();
		this.aptName = "Anonymous";
	}

	public Apartment(String aptName, int numberOfRooms, String address, String space, boolean gatedCommunity,
			String floorNumber) {
		super(numberOfRooms, address, space);
		this.aptName = aptName;
		this.gatedCommunity = gatedCommunity;
		this.floorNumber = floorNumber;
	}

	public String getAptName() {
		return aptName;
	}

	@Override
	public int getAvgRentalPrice() {
		logger.debug("Calculating renatl price of Apt Instance");
		return this.numberOfRooms * 300;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	// Cannot reduce method visibility for overridden methods
	// default int getNumberOfRooms() will throw compile time error
	@Override
	public int getNumberOfRooms() {
		return super.numberOfRooms;
	}

	protected boolean isDigitalLockAvailable() {
		return digitalLockAvailable;
	}

	public boolean isGatedCommunity() {
		return gatedCommunity;
	}

	protected void setDigitalLockAvailable(boolean digitalLockAvailable) {
		this.digitalLockAvailable = digitalLockAvailable;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void setGatedCommunity(boolean gatedCommunity) {
		this.gatedCommunity = gatedCommunity;
	}

}
