package com.booking.entity;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import javax.persistence.Column;


@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
  
	long id;
    
    String firstName;
    String lastName;
    String gender;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="BOOKING_ID")
    @JsonIgnore
    private Booking booking;
    private String ticketNumber;
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passenger(long id, String firstName, String lastName, String gender, Booking booking, String ticketNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.booking = booking;
		this.ticketNumber = ticketNumber;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	@Override
	public String toString() {
		return "Passenger [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", booking=" + booking + ", ticketNumber=" + ticketNumber + "]";
	}
	
    

}
