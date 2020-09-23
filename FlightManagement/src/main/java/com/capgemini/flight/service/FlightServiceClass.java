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
public class FlightServiceClass implements FlightServiceInterface {
	@Autowired
	private FlightDAO flightDAO;

	@Override
	public Optional<FlightEntity> searchFlight(long flightNumber) {

		return flightDAO.findById(flightNumber);

	}

	@Override
	public String addFlight(FlightEntity flight) {
		flightDAO.save(flight);
		return "Flight Added into the DataBase Successfuly";
	}

	@Override
	public void updateFlight(FlightEntity flightEntity) {
		FlightEntity old_Flight = flightDAO.findById(flightEntity.getFlightNumber()).get();
		old_Flight.setCarrierName(flightEntity.getCarrierName());
		old_Flight.setFlightMdel(flightEntity.getFlightMdel());
		old_Flight.setSeatCapacity(flightEntity.getSeatCapacity());

		flightDAO.save(old_Flight);
	}

	@Override
	@Transactional
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
