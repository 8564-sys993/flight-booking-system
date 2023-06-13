package com.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class BookingServiceApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceApplication.class);

	public static void main(String[] args) {
		logger.info("Starting Booking Service Application");
		SpringApplication.run(BookingServiceApplication.class, args);
	}

}
