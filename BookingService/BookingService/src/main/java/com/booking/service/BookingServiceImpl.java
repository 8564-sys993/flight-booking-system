package com.booking.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.client.FareServiceClient;
import com.booking.client.SearchServiceClient;
import com.booking.entity.Booking;
import com.booking.entity.FareDto;
import com.booking.entity.FlightDto;
import com.booking.entity.Passenger;
import com.booking.exception.BookingException;
import com.booking.repository.BookingRepository;
//import com.booking.repository.PassengerRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private SearchServiceClient searchServiceClient;

	@Autowired
	private FareServiceClient fareServiceClient;

	@Autowired
	private BookingRepository bookingRepository;

	public long bookFlight(BookingRequest bookingRequest) throws BookingException {
		// TODO Auto-generated method stub
		
		 logger.info("Booking flight for request: {}", bookingRequest);
		
		// Retrieve flight information from the Search microservice
		List<FlightDto> flight = searchServiceClient.searchFlights(bookingRequest.getOrigin(),
				bookingRequest.getDestination(), bookingRequest.getFlightDate());
		if (flight == null) {
			throw new BookingException("Flight not found");
		}

		List<Passenger> passengers = bookingRequest.getPassengers();
		if (passengers == null || passengers.isEmpty()) {
			throw new BookingException("Passengers not specified");
		}
		
		 // Retrieve fare information from the Fare microservice
		FareDto fare = fareServiceClient.getFare(bookingRequest.getFlightNumber(), bookingRequest.getFlightDate());
		if (fare == null) {
			throw new BookingException("Fare not found");
		}
		
		// Check if the flight has available seats
		FlightDto flights = flight.get(0);
		int availableSeats = flights.getCount() - flights.getBookedSeats();
		if (bookingRequest.getPassengers().size() > availableSeats) {
			throw new BookingException("Not enough seats available");
		}

		if (fare.getFare().compareTo("0") <= 0) {
			throw new BookingException("Invalid fare for flight ");
		}

		// Create a new booking record
		Booking bookingRecord = new Booking();
		bookingRecord.setFlightNumber(flights.getFlightNumber());
		bookingRecord.setFlightDate(flights.getFlightDate());
		bookingRecord.setPassengers(bookingRequest.getPassengers());
		bookingRecord.setStatus(BookingStatus.BOOKING_CONFIRMED);
		bookingRecord.setFare(fare.getFare());
        
		 // Save the booking record
		long bookingId = bookingRepository.save(bookingRecord).getId();
        
		
		// Update the flight's booked seats count
		flights.setBookedSeats(flights.getBookedSeats() + bookingRequest.getPassengers().size());
		searchServiceClient.updateFlight(flights.getFlightNumber(), flights.getFlightDate(), flights.getCount());

		generateAndSaveTicketNumbers(bookingRecord);
        
		 logger.info("Flight booked successfully. Booking ID: {}", bookingId);
		
		return bookingId;

	}
	
	

	private void generateAndSaveTicketNumbers(Booking bookingRecord) {
		// TODO Auto-generated method stub
		List<Passenger> passengers = bookingRecord.getPassengers();
		for (Passenger passenger : passengers) {
			String ticketNumber = generateTicketNumber();
			passenger.setTicketNumber(ticketNumber);
		}
		bookingRepository.save(bookingRecord);

	}

	
	
	private String generateTicketNumber() {
		// TODO Auto-generated method stub
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder ticketNumber = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(characters.length());
			char randomChar = characters.charAt(index);
			ticketNumber.append(randomChar);
		}
		return ticketNumber.toString();
	}

	
	
	
	public Booking getBooking(long id) throws BookingException {
		Optional<Booking> bookingRecordOptional = bookingRepository.findById(id);
		if (bookingRecordOptional.isPresent()) {
			return bookingRecordOptional.get();
		} else {
			throw new BookingException("Booking not found");
		}
	}

	
	
	public Booking checkin(long id, String seatNumber) throws BookingException {
        
		logger.info("Performing check-in for Booking ID: {}", id);
		
		Optional<Booking> bookingOptional = bookingRepository.findById(id);

		if (bookingOptional.isPresent()) {
			Booking booking = bookingOptional.get();

			if (seatNumber != null && !seatNumber.isEmpty()) {
				// Seat number provided, assign it to the booking

				booking.setSeatNumber(seatNumber);
			} else {
				// Randomly assign a seat number
				String randomSeatNumber = generateRandomSeatNumber();
				booking.setSeatNumber(randomSeatNumber);
			}
			
			logger.info("Check-in successful. Booking ID: {}", id);
			
			return bookingRepository.save(booking);

		} else {
			throw new BookingException("Booking not found");
		}
	}

	
	
	private String generateRandomSeatNumber() {
		Random random = new Random();
		int seatNumber = random.nextInt(100) + 1;
		return String.format("%03d", seatNumber);
	}

}
