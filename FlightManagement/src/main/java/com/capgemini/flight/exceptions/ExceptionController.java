package com.capgemini.flight.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
/**
 * @ControllerAdvice is an annotation provided by Spring allowing you to write
 *                   global code that can be applied to a wide range of
 *                   controllers
 *
 */
public class ExceptionController {
	@ExceptionHandler(value = FlightNotFoundException.class)
	public ResponseEntity<Object> exception(FlightNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = ObjectNullException.class)
	public ResponseEntity<Object> exception(ObjectNullException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = NoDataFoundException.class)
	public ResponseEntity<Object> exception(NoDataFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
}
