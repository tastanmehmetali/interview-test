package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class ToughJetRequest extends SupplierRequest {

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
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
}