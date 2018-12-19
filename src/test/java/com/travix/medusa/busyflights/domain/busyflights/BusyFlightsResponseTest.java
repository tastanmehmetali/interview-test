package com.travix.medusa.busyflights.domain.busyflights;

import org.junit.Assert;
import org.junit.Test;

public class BusyFlightsResponseTest {

	private static final int ZERO = 0;
	private static final double FARE = 100.00;
	private static final String SUPPLIER_BUSY_FLIGHT = "BusyFlight";
	private static final String AIRLINE = "TK";
	private static final String ARRIVAL_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@Test
	public void shouldCreatedBusyFlightsResponseCheck() {
		BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		busyFlightsResponse.setAirline(AIRLINE);
		busyFlightsResponse.setSupplier(SUPPLIER_BUSY_FLIGHT);
		busyFlightsResponse.setFare(FARE);
		busyFlightsResponse.setDepartureAirportCode(ORGIN_IST);
		busyFlightsResponse.setDestinationAirportCode(DESTINATION_AMS);
		busyFlightsResponse.setDepartureDate(DEPARTURE_DATE);
		busyFlightsResponse.setArrivalDate(ARRIVAL_DATE);
		
		Assert.assertEquals(AIRLINE, busyFlightsResponse.getAirline());
		Assert.assertEquals(SUPPLIER_BUSY_FLIGHT, busyFlightsResponse.getSupplier());
		Assert.assertEquals(ZERO, FARE, busyFlightsResponse.getFare());
		Assert.assertEquals(ORGIN_IST, busyFlightsResponse.getDepartureAirportCode());
		Assert.assertEquals(DESTINATION_AMS, busyFlightsResponse.getDestinationAirportCode());
		Assert.assertEquals(DEPARTURE_DATE, busyFlightsResponse.getDepartureDate());
		Assert.assertEquals(ARRIVAL_DATE, busyFlightsResponse.getArrivalDate());
	}

}
