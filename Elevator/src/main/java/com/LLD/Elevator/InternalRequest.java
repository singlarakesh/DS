package com.LLD.Elevator;

public class InternalRequest {
	int destinationFloor;

	public InternalRequest(int destinationFloor) {
		super();
		this.destinationFloor = destinationFloor;
	}

	public int getDestinationFloor() {
		return destinationFloor;
	}

	public void setDestinationFloor(int destinationFloor) {
		this.destinationFloor = destinationFloor;
	}

}
