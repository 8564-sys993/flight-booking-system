package com.fares.component;
import java.util.List;
import com.fares.entity.Fare;

public interface FaresService {
	 Fare saveFare(Fare fare);
	 
	List<Fare> getAllFare();
	
	Fare getFare(String flightNumber, String flightDate);
	
	Fare updateFare(String flightNumber, String flightDate, Fare fare);
	
    boolean deleteFare(String flightNumber, String flightDate);

}
