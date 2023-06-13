package com.booking.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.entity.Booking;
import com.booking.exception.BookingException;
import com.booking.service.BookingRequest;
import com.booking.service.BookingServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	 private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

	@Autowired
	private BookingServiceImpl bookingServiceImpl;

	@PostMapping("/bookings")
	public long bookFlight(@RequestBody BookingRequest bookingRequest) throws BookingException {
		 logger.info("Received booking request: {}", bookingRequest);
		long bookingId = bookingServiceImpl.bookFlight(bookingRequest);
		logger.info("Flight booked successfully. Booking ID: {}", bookingId);
		return bookingId;
	}

	@GetMapping("/{id}")
	public Booking getBooking(@PathVariable long id) throws BookingException {
		logger.info("Retrieving booking with ID: {}", id);
		return bookingServiceImpl.getBooking(id);
	}

	@PostMapping("/{id}/checkin")
	public ResponseEntity<Booking> checkinBooking(@PathVariable("id") long id,
			@RequestParam(value = "seatNumber", required = false) String seatNumber) {
		try {
			logger.info("Performing check-in for Booking ID: {}", id);
			Booking booking = bookingServiceImpl.checkin(id, seatNumber);
			logger.info("Check-in successful. Booking ID: {}", id);
			return ResponseEntity.ok().body(booking);
		} catch (BookingException e) {
			logger.error("Failed to perform check-in for Booking ID: {}", id, e);
			return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body(null);
		}
	}
}
