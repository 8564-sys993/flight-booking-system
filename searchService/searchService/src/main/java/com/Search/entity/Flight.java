package com.Search.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Flight {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String flightNumber;
	private String origin;
	private String destination;
	private String flightDate;
	private String departureTime;
	private String arrivalTime;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fare_Id")
	private Fares fare;
	
	private int count;
    @Column(name = "booked_seats")
    private int bookedSeats;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(long id, String flightNumber, String origin, String destination, String flightDate,
			String departureTime, String arrivalTime, Fares fare, int count, int bookedSeats) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
		this.count = count;
		this.bookedSeats = bookedSeats;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public Fares getFare() {
		return fare;
	}
	public void setFare(Fares fare) {
		this.fare = fare;
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
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", origin=" + origin + ", destination="
				+ destination + ", flightDate=" + flightDate + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + ", fare=" + fare + ", count=" + count + ", bookedSeats=" + bookedSeats + "]";
	}
    
    

}