package com.capgemini.flight.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.flight.entity.FlightEntity;

public interface FlightDAO extends JpaRepository<FlightEntity, Long>{

}
