package com.fares.excpetion;

public class FlightNumberAndDateNotFound extends RuntimeException {
	
	public FlightNumberAndDateNotFound(String mesg) {
		super(mesg);
	}

}
