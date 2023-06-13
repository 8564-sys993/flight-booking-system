package com.Search.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Search.Exception.FlightNotFoundException;
import com.Search.entity.Fares;
import com.Search.entity.Flight;
//import com.Search.entity.checkList;
import com.Search.repository.FlightRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.fares.entity.Fare;
@Service
public class SearchService implements SearchImpl {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public List<Flight> searchFlights(String origin, String destination, String flightDate) {
		// TODO Auto-generated method stub
		 logger.info("Searching flights - Origin: {}, Destination: {}, Flight Date: {}", origin, destination, flightDate);
		List<Flight> flights = flightRepository.findByOriginAndDestinationAndFlightDate(origin, destination, flightDate);
		
		List<Flight> search = new ArrayList<>(flights);
		search.addAll(flights);
		flights.forEach(flight -> {
			 Fares fares = flight.getFare();
			
			int checkListCount = flight.getCount();

	        if (fares.equals(null) ||checkListCount <= 0) {
	            search.remove(flight);
	        }
	    });
		logger.info("Search results: {}", search);
		return search;

	}

	@Override
	public void updateCheckList(String flightNumber, String flightDate,int count) {
		// TODO Auto-generated method stub
		logger.info("Updating checklist for flight - Flight Number: {}, Flight Date: {}, Checklist: {}", flightNumber, flightDate, count);
		Optional<Flight> optionalFlight = flightRepository.findByFlightNumberAndFlightDate(flightNumber, flightDate);
//		if (flight != null) {
//            int check = flight.getCount();
//            check.setCount(checklist);
//            flightRepository.save(flight);
//        }
//		else {
//            
//            throw new FlightNotFoundException("Flight not found for flightNumber: " + flightNumber + " and flightDate: " + flightDate);
//        }
		if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            int count1 =  count-flight.getBookedSeats() ;
            flight.setCount(count1);
            
            flightRepository.save(flight);
            
		} else {
            throw new FlightNotFoundException("Flight not found");
        }
		
	}
	
	@Override
	public List<Flight> getAllFlight() {
		logger.info("Retrieving all flights");
	    List<Flight> allFlights = flightRepository.findAll();
	    logger.info("Total flights retrieved: {}", allFlights.size());
	    return allFlights;
		//return flightRepository.findAll();
	}

}
