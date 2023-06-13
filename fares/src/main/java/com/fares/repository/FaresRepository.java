package com.fares.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fares.entity.Fare;
@Repository
public interface FaresRepository extends JpaRepository<Fare,Long> {
	Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
