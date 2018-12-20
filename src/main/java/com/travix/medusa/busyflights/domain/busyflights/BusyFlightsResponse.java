package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BusyFlightsResponse {

	@NotNull
	private String airline;
	
	@NotNull
	private String supplier;
	private double fare;

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
	private String departureAirportCode;

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
	private String destinationAirportCode;
	
	@NotNull
	private String departureDate;
	
	@NotNull
	private String arrivalDate;

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getDepartureAirportCode() {
		return departureAirportCode;
	}

	public void setDepartureAirportCode(String departureAirportCode) {
		this.departureAirportCode = departureAirportCode;
	}

	public String getDestinationAirportCode() {
		return destinationAirportCode;
	}

	public void setDestinationAirportCode(String destinationAirportCode) {
		this.destinationAirportCode = destinationAirportCode;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
}
