package com.fares.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fares.component.FaresComponent;
import com.fares.entity.Fare;

@RestController

@RequestMapping("/fares")
public class FaresController {
	
	@Autowired
	FaresComponent faresComponent;
	
	
	
	@PostMapping
    public ResponseEntity<Fare> createUser(@RequestBody Fare fare) {
        Fare fare1 = faresComponent.saveFare(fare);
        return ResponseEntity.status(HttpStatus.CREATED).body(fare1);
    }

	@RequestMapping("/get")
	Fare getFare(@RequestParam(value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate){
		return faresComponent.getFare(flightNumber,flightDate);
	}
	
	@GetMapping
	 public ResponseEntity<List<Fare>> getAllUser() {
        List<Fare> allFare = faresComponent.getAllFare();
        return ResponseEntity.ok(allFare);
    }
	
	@PutMapping("/{flightNumber}/{flightDate}")
	public ResponseEntity<Fare> updateFares(@PathVariable String flightNumber, @PathVariable String flightDate, @RequestBody Fare fare) {
	    Fare updatedFare = faresComponent.updateFare(flightNumber, flightDate, fare);
	    if (updatedFare == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok(updatedFare);
	}
	
	@DeleteMapping("/{flightNumber}/{flightDate}")
	public ResponseEntity<Void> deleteFare(@PathVariable String flightNumber, @PathVariable String flightDate) {
	    boolean fareDeleted = faresComponent.deleteFare(flightNumber, flightDate);
	    if (fareDeleted) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.notFound().build();
	
}
}
