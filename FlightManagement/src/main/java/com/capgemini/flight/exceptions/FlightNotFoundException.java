package com.capgemini.flight.exceptions;
/**
 * FlightNotFoundException is a run time exception to handle when ever flight is not available
 *
 */
public class FlightNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	public FlightNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
