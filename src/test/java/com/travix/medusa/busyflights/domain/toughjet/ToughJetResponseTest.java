package com.travix.medusa.busyflights.domain.toughjet;

import org.junit.Assert;
import org.junit.Test;

public class ToughJetResponseTest {

	private static final int ZERO = 0;
	private static final String INBOUND_DATE = "2019-01-15";
	private static final String OUTBOUND_DATE = "2018-12-17";
	private static final String ARRIVAL_AIRPORT_AMS = "AMS";
	private static final String DEPT_AIRPORT_LHR = "LHR";
	private static final double DISCOUNT = 5.0;
	private static final int TAX = 10;
	private static final double BASE_PRICE = 100.00;
	private static final String CARRIER_KLM = "KLM";

	@Test
	public void shouldCreatedToughJetResponseCheck() {
		ToughJetResponse toughJetResponse = generateToughJetObject();
		
		Assert.assertEquals(CARRIER_KLM, toughJetResponse.getCarrier());
		Assert.assertEquals(ZERO, BASE_PRICE, toughJetResponse.getBasePrice());
		Assert.assertEquals(ZERO, TAX, toughJetResponse.getTax());
		Assert.assertEquals(ZERO, DISCOUNT, toughJetResponse.getDiscount());
		Assert.assertEquals(DEPT_AIRPORT_LHR, toughJetResponse.getDepartureAirportName());
		Assert.assertEquals(ARRIVAL_AIRPORT_AMS, toughJetResponse.getArrivalAirportName());
		Assert.assertEquals(OUTBOUND_DATE, toughJetResponse.getOutboundDateTime());
		Assert.assertEquals(INBOUND_DATE, toughJetResponse.getInboundDateTime());
	}
	
	@Test
	public void shouldCreatedToughJetResponseCheckCalculatedFare() {
		ToughJetResponse toughJetResponse = generateToughJetObject();
		double calculatedFare = toughJetResponse.getBasePrice() + toughJetResponse.getTax() - toughJetResponse.getDiscount();
		Assert.assertEquals(ZERO, toughJetResponse.getCalculatedFare(), calculatedFare);
	}
	
	private ToughJetResponse generateToughJetObject() {
		ToughJetResponse toughJetResponse = new ToughJetResponse();
		toughJetResponse.setCarrier(CARRIER_KLM);
		toughJetResponse.setBasePrice(BASE_PRICE);
		toughJetResponse.setTax(TAX);
		toughJetResponse.setDiscount(DISCOUNT);
		toughJetResponse.setDepartureAirportName(DEPT_AIRPORT_LHR);
		toughJetResponse.setArrivalAirportName(ARRIVAL_AIRPORT_AMS);
		toughJetResponse.setOutboundDateTime(OUTBOUND_DATE);
		toughJetResponse.setInboundDateTime(INBOUND_DATE);
		return toughJetResponse;
	}
	
}
