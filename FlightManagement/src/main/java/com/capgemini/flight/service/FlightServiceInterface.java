package com.capgemini.flight.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.flight.entity.FlightEntity;

public interface FlightServiceInterface {

	Optional<FlightEntity> searchFlight(long flightNumber);

	String addFlight(FlightEntity flight);

	FlightEntity updateFlight(FlightEntity flightEntity);

	String deleteFlight(Long flightNumber);

	List<FlightEntity> getAllFlights();

	

}
