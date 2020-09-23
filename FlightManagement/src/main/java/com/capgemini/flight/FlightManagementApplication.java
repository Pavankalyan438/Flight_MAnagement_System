package com.capgemini.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @SpringBootApplication annotation is used to triggers auto-configuration and
						// component scanning
public class FlightManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightManagementApplication.class, args);
	}

}
