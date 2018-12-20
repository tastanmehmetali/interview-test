package com.travix.medusa.busyflights.domain.toughjet;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.travix.medusa.busyflights.domain.ISupplierResponse;

public class ToughJetResponse implements ISupplierResponse {

	@NotNull
    private String carrier;

	@NotNull
    private double basePrice;

	@NotNull
    private double tax;

	@NotNull
    private double discount;

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
    private String departureAirportName;

	@Pattern(regexp ="[A-Z]{3}")
	@NotNull
    private String arrivalAirportName;

	@NotNull
    private String outboundDateTime;

	@NotNull
    private String inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

	public double getCalculatedFare() {
		return getBasePrice() + getTax() - getDiscount();
	}
}