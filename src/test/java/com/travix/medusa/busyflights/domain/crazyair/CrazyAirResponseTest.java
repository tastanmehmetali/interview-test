package com.travix.medusa.busyflights.domain.crazyair;

import org.junit.Assert;
import org.junit.Test;


public class CrazyAirResponseTest {
	
	private static final String ARRIVAL_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DEST_AIRPORT_AMS = "AMS";
	private static final String DEP_AIRPORT_LHR = "LHR";
	private static final String CABIN_CLASS_ECONOMY = "Economy";
	private static final double PRICE = 100.00;
	private static final String AIRLINE = "KLM";
	private static final int ZERO = 0;

	@Test
	public void shouldCreateCrazyAirResponseCheck() {
		CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
		crazyAirResponse.setAirline(AIRLINE);
		crazyAirResponse.setPrice(PRICE);
		crazyAirResponse.setCabinclass(CABIN_CLASS_ECONOMY);
		crazyAirResponse.setDepartureAirportCode(DEP_AIRPORT_LHR);
		crazyAirResponse.setDestinationAirportCode(DEST_AIRPORT_AMS);
		crazyAirResponse.setDepartureDate(DEPARTURE_DATE);
		crazyAirResponse.setArrivalDate(ARRIVAL_DATE);
		
		Assert.assertEquals(AIRLINE, crazyAirResponse.getAirline());
		Assert.assertEquals(ZERO, PRICE, crazyAirResponse.getPrice());
		Assert.assertEquals(CABIN_CLASS_ECONOMY, crazyAirResponse.getCabinclass());
		Assert.assertEquals(DEP_AIRPORT_LHR, crazyAirResponse.getDepartureAirportCode());
		Assert.assertEquals(DEST_AIRPORT_AMS, crazyAirResponse.getDestinationAirportCode());
		Assert.assertEquals(DEPARTURE_DATE, crazyAirResponse.getDepartureDate());
		Assert.assertEquals(ARRIVAL_DATE, crazyAirResponse.getArrivalDate());
	}
	
}
