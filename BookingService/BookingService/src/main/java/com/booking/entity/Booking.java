package com.booking.entity;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Booking {
	
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="BOOKING_ID")
		long id;
	    
	    private String flightNumber;
	    private String origin;
	    private String destination;
	    private String flightDate;
	    private Date bookingDate;
	    private String fare;
	    private String status;
	    private String seatNumber;

	    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy="booking")
    private List<Passenger> passengers;

    public Booking() {
    }

    public Booking(String flightNumber, String from, String to, String flightDate, Date bookingDate, String fare,String seatNumber) {
        this.flightNumber = flightNumber;
        this.origin = from;
        this.destination = to;
        this.flightDate = flightDate;
        this.bookingDate = bookingDate;
        this.fare = fare;
        this.seatNumber=seatNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
    

    public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	@Override
    public String toString() {
        return "BookingRecord [id=" + id + ", flightNumber=" + flightNumber + ", from=" + origin + ", to=" + destination
                + ", flightDate=" + flightDate + ", bookingDate=" + bookingDate + ", passengers=" + passengers + "]";
    }
    

}
