package com.capgemini.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.flight.entity.Customer;
import com.capgemini.flight.exceptions.NoDataFoundException;
import com.capgemini.flight.service.LoginServiceInterface;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200")
public class LoginController {
	
	@Autowired
	LoginServiceInterface service;
	
	/**
	 * Method used to check whether the login details are correct or not
	 * @param cust as the input
	 * @return String 
	 */
	@PutMapping("/checkdetails")
	public ResponseEntity<String> checkLoginDetails(@RequestBody Customer cust) {
		if(cust!=null) {
		String result=service.login(cust);   //invoking the login method using ServiceInterface object
		return new ResponseEntity<String>(result,HttpStatus.OK);	
		}
		else 
			throw new NoDataFoundException("No input data found");
	}
}


