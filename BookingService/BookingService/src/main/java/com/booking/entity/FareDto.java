package com.booking.entity;

public class FareDto {

	private String flightNumber;
	private String flightDate;
	private String fare;

	public FareDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FareDto(String flightNumber, String flightDate, String fare) {
		super();
		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.fare = fare;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

}
