package com.booking.service;

import com.booking.entity.Booking;
import com.booking.exception.BookingException;

public interface BookingService {
	
	long bookFlight(BookingRequest bookingRequest) throws BookingException;
	
	Booking getBooking(long id) throws BookingException;

}
