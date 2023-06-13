package com.Search.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Search.entity.Flight;
//import com.Search.repository.FlightRepository;
import com.Search.service.SearchService;

@RestController
@CrossOrigin
@RequestMapping("/flights")
public class SearchController {
	
	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);

	@Autowired
	private SearchService searchService;

	@GetMapping("/search")
	public List<Flight> searchFlights(@RequestParam String origin,
			@RequestParam String destination,
			@RequestParam String flightDate) {
		// SearchQuery query = new SearchQuery(origin, destination, flightDate);
		// List<Flight> searchResult = searchService.searchFlights(origin, destination,
		// flightDate);
		// return ResponseEntity.ok(searchResult);
		logger.info("Searching flights - Origin: {}, Destination: {}, Flight Date: {}", origin, destination, flightDate);
		return searchService.searchFlights(origin, destination, flightDate);
	}

	@PutMapping("/{flightNumber}/{flightDate}")
	public void updateCheckList(@PathVariable String flightNumber, 
			@PathVariable String flightDate,
			@RequestParam int count) {
		
		 logger.info("Updating checklist for flight - Flight Number: {}, Flight Date: {}, Checklist: {}", flightNumber, flightDate, count);
		searchService.updateCheckList(flightNumber, flightDate, count);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Flight>> getAllFlight() {
		logger.info("Retrieving all flights");
	    List<Flight> allFlights = searchService.getAllFlight();
	    logger.info("Total flights retrieved: {}", allFlights.size());
	    return ResponseEntity.ok(allFlights);
	}

}
