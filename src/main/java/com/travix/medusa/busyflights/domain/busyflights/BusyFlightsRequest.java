package com.travix.medusa.busyflights.domain.busyflights;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.travix.medusa.busyflights.domain.SupplierRequest;

public class BusyFlightsRequest extends SupplierRequest {

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
    
    @Max(value = 4, message = "Maximum 4")
    @Min(value = 0, message = "Minimum 0")
    @NotNull
    private int numberOfPassengers;

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

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(final int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

	@Override
	public String convertToJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("origin", getOrigin());
        jsonObject.put("destination", getDestination());
        jsonObject.put("departureDate", getDepartureDate());
        jsonObject.put("returnDate", getReturnDate());
        jsonObject.put("numberOfPassengers", getNumberOfPassengers());
        return jsonObject.toString();
	}
}