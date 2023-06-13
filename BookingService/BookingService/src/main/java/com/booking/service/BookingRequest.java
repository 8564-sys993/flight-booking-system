package com.booking.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import com.booking.entity.Passenger;

public class BookingRequest {
	
	  private String flightNumber;
	    private String origin;
	    private String destination;
	    private String flightDate;
	    private Date bookingDate;
	    private String fare;
	    private List<Passenger> passengers;
	    
	    
		public BookingRequest() {
			super();
			// TODO Auto-generated constructor stub
		}


		public BookingRequest(String flightNumber, String origin, String destination, String flightDate,
				Date bookingDate, String fare, List<Passenger> passengers) {
			super();
			this.flightNumber = flightNumber;
			this.origin = origin;
			this.destination = destination;
			this.flightDate = flightDate;
			this.bookingDate = bookingDate;
			this.fare = fare;
			this.passengers = passengers;
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


		public Date getBookingDate() {
			return bookingDate;
		}


		public void setBookingDate(Date bookingDate) {
			this.bookingDate = bookingDate;
		}


		public String getFare() {
			return fare;
		}


		public void setFare(String fare) {
			this.fare = fare;
		}


		public List<Passenger> getPassengers() {
			return passengers;
		}


		public void setPassengers(List<Passenger> passengers) {
			this.passengers = passengers;
		}
	    
	    

	    

}
