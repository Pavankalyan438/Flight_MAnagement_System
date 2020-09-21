package com.capgemini.flight.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.flight.DAO.FlightDAO;
import com.capgemini.flight.entity.FlightEntity;
@Service
public class FlightServiceClass implements FlightServiceInterface {
	@Autowired
	FlightDAO flightDAO;

	@Override
	public Optional<FlightEntity> searchFlight(long flightNumber) {
		// TODO Auto-generated method stub
	return	flightDAO.findById(flightNumber);
		
	}

	@Override
	public String addFlight(FlightEntity flight) {
		flightDAO.save(flight);
		return "Flight Added into the DataBase Successfuly";
	}

	@Override
	public FlightEntity updateFlight(FlightEntity flightEntity) {
		
		return flightDAO.save(flightEntity);
	}

	@Override
	public String deleteFlight(Long flightNumber) {
		// TODO Auto-generated method stub
		flightDAO.deleteById(flightNumber);
		return "Flight is DELETED SUCCESSFULLY !";
	}

	@Override
	public List<FlightEntity> getAllFlights() {
		return flightDAO.findAll();
		 
	}

}
