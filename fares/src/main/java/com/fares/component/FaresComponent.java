package com.fares.component;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.fares.entity.Fare;
//import com.fares.excpetion.FlightNumberAndDateNotFound;
import com.fares.repository.FaresRepository;

@Service
public class FaresComponent implements FaresService {
	@Autowired
	private FaresRepository faresRepository;

	@Override
	public List<Fare> getAllFare() {
		
		return faresRepository.findAll();
	}

	@Override
	public Fare getFare(String flightNumber, String flightDate){
		
		return faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
	}

	@Override
	public Fare saveFare(Fare fare) {
		// TODO Auto-generated method stub
		return faresRepository.save(fare);
	}

	@Override
	public Fare updateFare(String flightNumber, String flightDate, Fare fare) {
		
		 Fare existingFare = faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
	        if (existingFare != null) {
	            fare.setId(existingFare.getId());
	            return faresRepository.save(fare);
	        }
	        return null;
	}

	@Override
	public boolean deleteFare(String flightNumber, String flightDate) {
		// TODO Auto-generated method stub
		Fare existingFare = faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
        if (existingFare != null) {
            faresRepository.delete(existingFare);
            return true;
        }
        return false;
    }
}
