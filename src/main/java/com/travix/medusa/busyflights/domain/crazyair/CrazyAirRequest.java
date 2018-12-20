package com.travix.medusa.busyflights.domain.crazyair;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class CrazyAirRequest extends SupplierRequest {

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
    private String origin;
    
	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
	private String destination;

	@NotNull
    private String departureDate;

	@NotNull
    private String returnDate;
    
    @Min(value = 0, message = "Minimum 0")
	@NotNull
    private int passengerCount;

    public CrazyAirRequest() {}
    
    public CrazyAirRequest(BusyFlightsRequest busyFlightsRequest) {
    	this.origin = busyFlightsRequest.getOrigin();
    	this.destination = busyFlightsRequest.getDestination();
    	this.departureDate = busyFlightsRequest.getDepartureDate();
    	this.returnDate = busyFlightsRequest.getReturnDate();
    	this.passengerCount = busyFlightsRequest.getNumberOfPassengers();
	}

	public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }

	@Override
	public String convertToJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("origin", getOrigin());
        jsonObject.put("destination", getDestination());
        jsonObject.put("departureDate", getDepartureDate());
        jsonObject.put("returnDate", getReturnDate());
        jsonObject.put("passengerCount", getPassengerCount());
        return jsonObject.toString();
	}
}