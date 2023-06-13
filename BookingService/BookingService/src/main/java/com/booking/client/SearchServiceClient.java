package com.booking.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.entity.FlightDto;
@FeignClient(name ="SearchService",url="http://localhost:8085/flights")
public interface SearchServiceClient {
	
	 @GetMapping("/search")
	    List<FlightDto> searchFlights(@RequestParam String origin,
				@RequestParam String destination,
				@RequestParam String flightDate);
	 
	 
	 @PutMapping("/{flightNumber}/{flightDate}")
	 void updateFlight(@PathVariable String flightNumber, 
				@PathVariable String flightDate,
				@RequestParam int count);

}
