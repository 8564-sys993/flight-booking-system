package com.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.entity.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
