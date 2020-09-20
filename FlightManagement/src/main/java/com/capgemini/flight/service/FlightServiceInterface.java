package com.capgemini.flight.service;

import java.util.Optional;

import com.capgemini.flight.entity.FlightEntity;

public interface FlightServiceInterface {

	Optional<FlightEntity> searchFlight(long flightNumber);

	String addFlight(FlightEntity flight);

	

}
