package com.fares.entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fare_micro")
public class Fare {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String flightNumber;

	private String flightDate;

	private String fare;

	public Fare() {
		super();
	}

	public Fare(String flightNumber, String flightDate, String fare) {
		super();

		this.flightNumber = flightNumber;
		this.flightDate = flightDate;
		this.fare = fare;
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

	@Override
	public String toString() {
		return "Fare [id=" + id + ", flightNumber=" + flightNumber + ", flightDate=" + flightDate + ", fare=" + fare
				+ "]";
	}

}