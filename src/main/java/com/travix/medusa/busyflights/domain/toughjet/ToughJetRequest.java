package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class ToughJetRequest extends SupplierRequest {

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
    private String from;

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
    private String to;

	@NotNull
    private String outboundDate;

	@NotNull
    private String inboundDate;

    @Min(value = 0, message = "Minimum 0")
	@NotNull
    private int numberOfAdults;

    public ToughJetRequest() {}
    
    public ToughJetRequest(BusyFlightsRequest busyFlightsRequest) {
    	this.from = busyFlightsRequest.getOrigin();
    	this.to = busyFlightsRequest.getDestination();
    	this.outboundDate = busyFlightsRequest.getDepartureDate();
    	this.inboundDate = busyFlightsRequest.getReturnDate();
    	this.numberOfAdults = busyFlightsRequest.getNumberOfPassengers();
	}

	public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

	@Override
	public String convertToJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
        jsonObject.put("from", getFrom());
        jsonObject.put("to", getTo());
        jsonObject.put("outboundDate", getOutboundDate());
        jsonObject.put("inboundDate", getInboundDate());
        jsonObject.put("numberOfAdults", getNumberOfAdults());
        return jsonObject.toString();
	}
}