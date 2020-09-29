package com.capgemini.flight;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;
import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.flight.entity.FlightEntity;
import com.capgemini.flight.service.FlightServiceInterface;

@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class FlightManagementApplicationTests {

	@Autowired
	private FlightServiceInterface flight_Service;

	@Test
	public void add_FlightTest() {
		FlightEntity flight = new FlightEntity(12222, "Jet Engine", "Air India", 80);
		String actual = flight_Service.addFlight(flight);
		assertEquals("Flight Added into the DataBase Successfuly", actual);

	}


	@Test
	public void search_FlightTest() {
		Optional<FlightEntity> actual = flight_Service.searchFlight(12222);
		assertNotNull(actual);

	}


	@Test

	 public void delete_FlightTest() {
		String actual = flight_Service.deleteFlight(12222);
		assertSame("Flight is DELETED SUCCESSFULLY !", actual);

	}
	@Test
	public void all_FlightsTest() {
		List<FlightEntity> actual = flight_Service.getAllFlights();
		assertNotEquals(7, actual.size());

	}
	
	
	

}
