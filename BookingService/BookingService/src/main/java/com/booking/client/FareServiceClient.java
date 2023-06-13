package com.booking.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.entity.FareDto;

@FeignClient(name="FareService",url="http://localhost:8082/fares")
public interface FareServiceClient {
	
	@GetMapping("/get")
	FareDto getFare(@RequestParam String flightNumber, @RequestParam String flightDate);

	

}
