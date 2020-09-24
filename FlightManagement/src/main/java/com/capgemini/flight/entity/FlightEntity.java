package com.capgemini.flight.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //@Entity annotation specifies that the class is an entity and is mapped to a database table
@Table(name="flights") //@Table annotation specifies the name of the database table to be used for mapping
public class FlightEntity {
	
	@Id //@Id annotation specifies the primary key of an entity 
	
	@Column(name="flight_number", length=10) //@Column enables you to customize the columns
	private long flightNumber;
	@Column(name="flight_model", length=20)
	private String flightMdel;
	@Column(name="carrier_name", length=20)
	private String carrierName;
	@Column(name="seat_capacity", length=10)
	private int seatCapacity;
	
	/**
	 *Public getter and setter for the private variables declared
	 */
	public long getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(long flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightMdel() {
		return flightMdel;
	}
	public void setFlightMdel(String flightMdel) {
		this.flightMdel = flightMdel;
	}
	public String getCarrierName() {
		return carrierName;
	}
	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}
	public int getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	//Default constructor
	public FlightEntity() {
		// TODO Auto-generated constructor stub
	}
	
	//Constructor with all the Fields and initialization
	public FlightEntity(long flightNumber, String flightMdel, String carrierName, int seatCapacity) {
		super();
		this.flightNumber = flightNumber;
		this.flightMdel = flightMdel;
		this.carrierName = carrierName;
		this.seatCapacity = seatCapacity;
	}
	@Override
	//Overriding the Object class method in this class
	public String toString() {
		return "FlightEntity [flightNumber=" + flightNumber + ", flightMdel=" + flightMdel + ", carrierName="
				+ carrierName + ", seatCapacity=" + seatCapacity + "]";
	}
	
	
	
	

}
