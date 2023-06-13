package com.Search.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Search.entity.Flight;
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
	List<Flight> findByOriginAndDestinationAndFlightDate(String origin,String destination, String flightDate);

	Optional<Flight> findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
} 
