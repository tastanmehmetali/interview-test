package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.travix.medusa.busyflights.domain.ISupplierResponse;

public class CrazyAirResponse implements ISupplierResponse {

	@NotNull
    private String airline;

	@NotNull
    private double price;

	@NotNull
    private String cabinclass;

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

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
