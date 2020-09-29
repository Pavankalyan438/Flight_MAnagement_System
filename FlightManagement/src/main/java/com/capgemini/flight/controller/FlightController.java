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
@CrossOrigin(origins = "http://localhost:4200")
public class FlightController {

	@Autowired
	private FlightServiceInterface flightService;

	@PostMapping("/addflight") 
	/**
	 * This method used to add the new flight into the database
	 * 
	 * @param flight
	 * @return String telling that adding is successful
	 */

	public ResponseEntity<String> addFlight(@RequestBody FlightEntity flight) {
		/**
		 * Checking whether any variable in the object is null
		 */

		if (flight.getCarrierName() == null || flight.getFlightMdel() == null || flight.getSeatCapacity() == 0
				|| flight.getFlightNumber() == 0)

			throw new ObjectNullException("Object Cannot be Empty"); 

		/**
		 * Checking whether this flight is already available in the database by
		 * seaechFlight() method,if not we are adding into the database
		 */

		Optional<FlightEntity> flightEntity = flightService.searchFlight(flight.getFlightNumber());
		if (flightEntity.isPresent())
			return new ResponseEntity<String>("Flight with " + flight.getFlightNumber() + " number is already added",
					HttpStatus.OK);
		String msg = flightService.addFlight(flight);

		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@GetMapping("/searchflight/{flightNumber}") 

	/**
	 * @PathVariable is used to extract the variable from the URL This method
	 *               searches for the flight with particular flight number
	 * @param flightNumber
	 * @return FlightEntity object if avilable else throws an exception
	 */
	public Optional<FlightEntity> searchFlight(@PathVariable int flightNumber) {
		if (flightNumber == 0)
			throw new ObjectNullException("Flight Number Cannot be 0 !");

		Optional<FlightEntity> flightEntity = flightService.searchFlight(flightNumber);
		return flightEntity;
		

	}

	@PutMapping("/updateflight") 
	/**
	 * @RequestBody is used to get the object of the class from the URL Method is
	 *              used to update the flight, initially checks whether the object
	 *              is null
	 * @param flightEntity
	 * @return String that update is successful
	 */

	public String updateFlight(@RequestBody FlightEntity flightEntity) {
		if (flightEntity.getCarrierName() == null || flightEntity.getFlightMdel() == null
				|| flightEntity.getSeatCapacity() == 0 || flightEntity.getFlightNumber() == 0)
			throw new ObjectNullException("Object Cannot be NULL!");
		Optional<FlightEntity> flight_check = flightService.searchFlight(flightEntity.getFlightNumber());
		if (flight_check.isPresent()) {

			/**
			 * checking whether values are present is received object and updates with the
			 * new object
			 */

			flightService.updateFlight(flightEntity);
			return "Successfully UPDATED ! !";
		}
		/**
		 * Else return that flight is not available to update
		 */
		return "Flight with " + flightEntity.getFlightNumber() + " is not AVAILABLE to update!!";

	}

	@DeleteMapping("/deleteflight/{flightNumber}")

	/**
	 * This method used to delete the flight with particular flight number
	 * 
	 * @param flightNumber
	 * @return String that flight is deleted successfully else throws an
	 *         FlightNotFoundException
	 */

	public String deleteFlight(@PathVariable int flightNumber) {
		if (flightNumber == 0)
			throw new ObjectNullException("Flight Number Cannot be 0 !");

		/**
		 * To delete first i am searching whether the flight is available in the
		 * database
		 * 
		 */

		Optional<FlightEntity> flightEntity = flightService.searchFlight(flightNumber);
		if (flightEntity.isPresent()) {

			return flightService.deleteFlight(flightNumber); // deleting the flight with particular flight number

		}

		throw new FlightNotFoundException("Flight with " + flightNumber + " Flight Number is NOT AVAILABLE !!!");

	}

	@GetMapping("/allflights") 
	/**
	 * This method used to get all the flights that are available
	 * 
	 * @return List of FlightEntity objects
	 */

	public ResponseEntity<List<FlightEntity>> viewAllFlights() {
		List<FlightEntity> all_flights = flightService.getAllFlights();
		if (all_flights.isEmpty()) { // Checking whether the list is Empty

			throw new FlightNotFoundException("Flight Not found"); // Throwing exception if the object is empty
		}

		return new ResponseEntity<List<FlightEntity>>(all_flights, HttpStatus.OK);

	}
}
