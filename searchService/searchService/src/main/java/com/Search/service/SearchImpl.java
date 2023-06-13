package com.Search.service;

import java.util.List;

import com.Search.entity.Flight;

public interface SearchImpl {
	
	List<Flight> searchFlights(String origin, String destination, String flightDate);
    void updateCheckList(String flightNumber, String flightDate,int count);
	List<Flight> getAllFlight();

}
