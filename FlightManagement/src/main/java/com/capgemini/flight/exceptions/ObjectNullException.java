package com.capgemini.flight.exceptions;
/**
 * ObjectNullException is a run time exception to handle when ever any object is null
 *
 */
public class ObjectNullException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public ObjectNullException(String msg) {

		super(msg);
	}

}
