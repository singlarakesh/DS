package com.LLD.Elevator;

import java.util.TreeSet;

public class Elevator {
	private volatile int currentFloor = 0;
	private Direction direction = Direction.UP;
	private Status status = Status.IDLE;

	private volatile TreeSet<Request> currentJobs = new TreeSet<>();

	private volatile TreeSet<Request> upPendingJobs = new TreeSet<Request>();

	private volatile TreeSet<Request> downPendingJobs = new TreeSet<Request>();

	public void startElevator() {
		System.out.println("Elevator has started functioning");
		while (true) {
			synchronized (currentJobs) {

				if (checkIfJob()) {
					if (direction == Direction.UP) {

						System.out.println("Moving upwards");
						Request request = currentJobs.pollFirst();
						processUpRequest(request);
						if (currentJobs.isEmpty()) {
							processPendingUpRequest();
						}
					}
					if (direction == Direction.DOWN) {
						Request request = currentJobs.pollFirst();
						processDownRequest(request);
						if (currentJobs.isEmpty()) {
							processPendingDownRequest();
						}
					}
				}
			}
		}
	}

	private void processDownRequest(Request request) {
		// TODO Auto-generated method stub
		int startFloor = currentFloor;
		if (startFloor < request.getExternalRequest().getSourceFloor()) {
			for (int i = startFloor; i <= request.getExternalRequest().getSourceFloor(); i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("We have reached floor -- " + i);
				currentFloor = i;
			}
		}

		System.out.println("Reached Source Floor--opening door");

		startFloor = currentFloor;

		for (int i = startFloor; i >= request.getInternalRequest().getDestinationFloor(); i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("We have reached floor -- " + i);
			currentFloor = i;
			if (checkIfNewJobCanBeProcessed(request)) {
				break;
			}
		}

	}

	private void processPendingDownRequest() {
		// TODO Auto-generated method stub
		if (!downPendingJobs.isEmpty()) {
			currentJobs = downPendingJobs;
			direction = Direction.DOWN;
		} else {
			status = Status.IDLE;
		}
	}

	private void processPendingUpRequest() {
		// TODO Auto-generated method stub
		if (!upPendingJobs.isEmpty()) {
			currentJobs = upPendingJobs;
			direction = Direction.UP;
		} else {
			status = Status.IDLE;
		}
	}

	private void processUpRequest(Request request) {
		// TODO Auto-generated method stub
		int startFloor = currentFloor;
		if (startFloor < request.getExternalRequest().sourceFloor) {
			for (int i = startFloor; i <= request.getExternalRequest().sourceFloor; i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				System.out.println("we have reached floor " + i);
				currentFloor = i;
			}
		}
		startFloor = currentFloor;
		if (startFloor < request.getInternalRequest().getDestinationFloor()) {
			for (int i = startFloor; i <= request.getInternalRequest().getDestinationFloor(); i++) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				System.out.println("we have reached floor " + i);
				currentFloor = i;
				if (checkIfNewJobCanBeProcessed(request)) {
					break;
				}
			}
		}
	}

	private boolean checkIfNewJobCanBeProcessed(Request currentRequest) {
		if (checkIfJob()) {
			if (direction == Direction.UP) {
				Request request = currentJobs.pollFirst();
				if (request.getInternalRequest().getDestinationFloor() < currentRequest.getInternalRequest()
						.getDestinationFloor()) {
					currentJobs.add(request);
					currentJobs.add(currentRequest);
					return true;
				}
				currentJobs.add(request);

			}

			if (direction == Direction.DOWN) {
				Request request = currentJobs.pollLast();
				if (request.getInternalRequest().getDestinationFloor() > currentRequest.getInternalRequest()
						.getDestinationFloor()) {
					currentJobs.add(request);
					currentJobs.add(currentRequest);
					return true;
				}
				currentJobs.add(request);

			}

		}
		return false;

	}

	private boolean checkIfJob() {
		// TODO Auto-generated method stub
		if (!currentJobs.isEmpty())
			return true;
		return false;
	}

	public void addJob(Request request) {
		if (status == Status.IDLE) {
			status = Status.MOVING;
			direction = request.getExternalRequest().getDirectionToGo();
			currentJobs.add(request);
		} else if (status == Status.MOVING) {

			if (request.getExternalRequest().getDirectionToGo() != direction) {
				addtoPendingJobs(request);
			} else if (request.getExternalRequest().getDirectionToGo() == direction) {
				if (direction == Direction.UP && request.getInternalRequest().getDestinationFloor() < currentFloor) {
					addtoPendingJobs(request);
				} else if (direction == Direction.DOWN
						&& request.getInternalRequest().getDestinationFloor() > currentFloor) {
					addtoPendingJobs(request);
				} else {
					currentJobs.add(request);
				}

			}

		}

	}

	public void addtoPendingJobs(Request request) {
		if (request.getExternalRequest().getDirectionToGo() == Direction.UP) {
			System.out.println("Add to pending up jobs");
			upPendingJobs.add(request);
		} else {
			System.out.println("Add to pending down jobs");
			downPendingJobs.add(request);
		}
	}

}
