package com.capgemini.flight.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flight.entity.FlightEntity;
import com.capgemini.flight.service.FlightServiceInterface;

@RestController
@RequestMapping("/flight")
@CrossOrigin(origins = "*")
public class FlightController {

	@Autowired
	FlightServiceInterface flightService;

	@PostMapping("/addflight")
	public ResponseEntity<String> addFlight(@RequestBody FlightEntity flight) {

		if (flight == null)
			throw new NullPointerException("Object Cannot be Empty");
		Optional<FlightEntity> flightEntity = flightService.searchFlight(flight.getFlightNumber());
		if (flightEntity.isPresent())
			return new ResponseEntity<String>("Flight with " + flight.getFlightNumber() + " number is already added",
					HttpStatus.ALREADY_REPORTED);
		String msg = flightService.addFlight(flight);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

}
