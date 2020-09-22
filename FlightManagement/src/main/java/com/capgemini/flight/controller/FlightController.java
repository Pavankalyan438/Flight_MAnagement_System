package com.capgemini.flight.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flight.entity.FlightEntity;
import com.capgemini.flight.exceptions.FlightNotFoundException;
import com.capgemini.flight.exceptions.ObjectNullException;
import com.capgemini.flight.service.FlightServiceInterface;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "*")
public class FlightController {

	@Autowired
	FlightServiceInterface flightService;

	@PostMapping("/addflight") // Mapping the URL to add flight
	public ResponseEntity<String> addFlight(@RequestBody FlightEntity flight) {

		if (flight.getCarrierName() == null) // Checking whether the received object is null
			throw new ObjectNullException("Object Cannot be Empty"); // If object is null throwing an Null pointer
																		// Exception

		// Checking whether this flight is already available in the database by
		// seaechFlight() method
		Optional<FlightEntity> flightEntity = flightService.searchFlight(flight.getFlightNumber());
		if (flightEntity.isPresent())
			return new ResponseEntity<String>("Flight with " + flight.getFlightNumber() + " number is already added",
					HttpStatus.ALREADY_REPORTED);
		// Adding the flight into the Database
		String msg = flightService.addFlight(flight);
		// Returning the ResponseEntity<String> with Httpstatus and message
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@GetMapping("/searchflight/{flightNumber}") // Mapping the URL for Searching Flight
	// @PathVariable is used to extract the variable from the URL
	public Optional<FlightEntity> searchFlight(@PathVariable Long flightNumber) {
		Optional<FlightEntity> flightEntity = flightService.searchFlight(flightNumber);
		if (flightEntity.isPresent()) {
			return flightEntity;
		}

		throw new FlightNotFoundException("Flight with " + flightNumber + " Flight Number is NOT AVAILABLE !!!"); // Throwing
																													// exception
																													// available

	}

	@PutMapping("/updateflight") // Mapping the URL to update flight

	// @RequestBody is used to get the object of the class from the URL
	public String updateFlight(@RequestBody FlightEntity flightEntity) {
		if (flightEntity == null) // Checking whether the object received is null

			throw new ObjectNullException("Object Cannot be NULL!");
		Optional<FlightEntity> flight_check = flightService.searchFlight(flightEntity.getFlightNumber());
		if (flight_check.isPresent()) { // checking whether values are present is received object
			flightService.updateFlight(flightEntity);
			return "Successfully Updated :) ";
		}
		return "Flight with " + flightEntity.getFlightNumber() + " is not AVAILABLE to update!!";

	}

	@DeleteMapping("/deleteflight/{flightNumber}") // Mapping the URL to delete the flight with flight number
	public String deleteFlight(@PathVariable Long flightNumber) {
		// To delete first i am searching whether the flight is available in the
		// database
		Optional<FlightEntity> flightEntity = flightService.searchFlight(flightNumber);
		if (flightEntity.isPresent()) {
			// deleting the flight with particular flight number
			return flightService.deleteFlight(flightNumber);

		}
		// throwing exception if flight is not available
		throw new FlightNotFoundException("Flight with " + flightNumber + " Flight Number is NOT AVAILABLE !!!");

	}

	@GetMapping("/allflights") // Mapping the URL to get all the flights available
	public ResponseEntity<List<FlightEntity>> viewAllFlights() {
		List<FlightEntity> all_flights = flightService.getAllFlights();
		if (all_flights.isEmpty()) { // Checking whether the list is Empty

			// Throwing exception if the object is empty
			throw new FlightNotFoundException("Flight Not found");
		}
		// Else returning the List of available flights with HtttpStatus
		return new ResponseEntity<List<FlightEntity>>(all_flights, HttpStatus.OK);

	}
}
