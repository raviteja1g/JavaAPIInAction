package com.java.api.model;

public class Condominium extends House{
	
	private boolean liftAvailable;

	private int floorNumber;

	public Condominium() {
		super();
	}
	
	public Condominium(int numberOfRooms, String address, String space, boolean liftAvailable, int floorNumber) {
		super(numberOfRooms, address, space);
		this.liftAvailable = liftAvailable;
		this.floorNumber = floorNumber;
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public boolean isLiftAvailable() {
		return liftAvailable;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public void setLiftAvailable(boolean liftAvailable) {
		this.liftAvailable = liftAvailable;
	}
	
	@Override
	public int getAvgRentalPrice() {
		logger.debug("Calculating renatl price of Condo Instance");
		return this.numberOfRooms * 400;
	}
	
	

}
