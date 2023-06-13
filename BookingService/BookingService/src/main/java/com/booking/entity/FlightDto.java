package com.booking.entity;

public class FlightDto {

	private String flightNumber;
	private String origin;
	private String destination;
	private String flightDate;
	private String departureTime;
	private String arrivalTime;
	private int count;
	private int bookedSeats;

	public FlightDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDto(String flightNumber, String origin, String destination, String flightDate, String departureTime,
			String arrivalTime, int count, int bookedSeats) {
		super();
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.count = count;
		this.bookedSeats = bookedSeats;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(int bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	@Override
	public String toString() {
		return "FlightDto [flightNumber=" + flightNumber + ", origin=" + origin + ", destination=" + destination
				+ ", flightDate=" + flightDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", count=" + count + ", bookedSeats=" + bookedSeats + "]";
	}

}
