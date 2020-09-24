package com.capgemini.flight.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flight.DAO.FlightDAO;
import com.capgemini.flight.entity.FlightEntity;

@Service
@Transactional
/**
 * This class implements the FlightServiceInterface interface and performs crud operations
 * @author Pavan
 *
 */
public class FlightServiceClass implements FlightServiceInterface {
	@Autowired
	private FlightDAO flightDAO;

	@Override
	/**
	 * seaching a flight with findById(Long l) method  and returning the object
	 */
	public Optional<FlightEntity> searchFlight(long flightNumber) {

		return flightDAO.findById(flightNumber);

	}

	@Override
	/**
	 * Adding the flights into the database
	 */
	public String addFlight(FlightEntity flight) {
		flightDAO.save(flight);
		return "Flight Added into the DataBase Successfuly";
	}

	@Override
	/**
	 * Getting the flight object and then setting the varibles with the new object values
	 */
	public void updateFlight(FlightEntity flightEntity) {
		FlightEntity old_Flight = flightDAO.findById(flightEntity.getFlightNumber()).get();
		old_Flight.setCarrierName(flightEntity.getCarrierName());
		old_Flight.setFlightMdel(flightEntity.getFlightMdel());
		old_Flight.setSeatCapacity(flightEntity.getSeatCapacity());

		flightDAO.save(old_Flight);
	}

	@Override
	/**
	 * deleting the flight with deleteById(Long l) method and returning the string
	 */
	public String deleteFlight(Long flightNumber) {
		// TODO Auto-generated method stub
		flightDAO.deleteById(flightNumber);
		return "Flight is DELETED SUCCESSFULLY !";
	}

	@Override
	/**
	 * Reurning the list of flight objects
	 */
	public List<FlightEntity> getAllFlights() {
		return flightDAO.findAll();

	}

}
