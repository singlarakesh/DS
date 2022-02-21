package com.LLD.Elevator;

public class Request implements Comparable<Request> {
	InternalRequest internalRequest;
	ExternalRequest externalRequest;

	public Request(InternalRequest internalRequest, ExternalRequest externalRequest) {
		super();
		this.internalRequest = internalRequest;
		this.externalRequest = externalRequest;
	}

	public InternalRequest getInternalRequest() {
		return internalRequest;
	}

	public void setInternalRequest(InternalRequest internalRequest) {
		this.internalRequest = internalRequest;
	}

	public ExternalRequest getExternalRequest() {
		return externalRequest;
	}

	public void setExternalRequest(ExternalRequest externalRequest) {
		this.externalRequest = externalRequest;
	}

	@Override
	public int compareTo(Request o) {
		// TODO Auto-generated method stub
		
		if(this.internalRequest.getDestinationFloor()==o.internalRequest.getDestinationFloor()) {
			return 0;
		}else if(this.internalRequest.getDestinationFloor()>this.internalRequest.getDestinationFloor()) {
			return 1;
		}else {
			return -1;
		}
	}

}
