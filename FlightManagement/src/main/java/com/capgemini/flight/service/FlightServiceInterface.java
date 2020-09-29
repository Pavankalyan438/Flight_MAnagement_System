package com.capgemini.flight.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.flight.entity.FlightEntity;
/**
 * Interface declaring the methods for crud operations
 */
public interface FlightServiceInterface {

	Optional<FlightEntity> searchFlight(int flightNumber);

	String addFlight(FlightEntity flight);

	void updateFlight(FlightEntity flightEntity);

	String deleteFlight(int flightNumber);

	List<FlightEntity> getAllFlights();

	

}
