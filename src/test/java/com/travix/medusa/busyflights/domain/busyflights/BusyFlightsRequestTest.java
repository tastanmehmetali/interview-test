package com.travix.medusa.busyflights.domain.busyflights;

import org.junit.Assert;
import org.junit.Test;

public class BusyFlightsRequestTest {

	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@Test
	public void shouldCreatedBusyFlightsRequestCheck() {
		BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
		busyFlightsRequest.setOrigin(ORGIN_IST);
		busyFlightsRequest.setDestination(DESTINATION_AMS);
		busyFlightsRequest.setDepartureDate(DEPARTURE_DATE);
		busyFlightsRequest.setReturnDate(RETURN_DATE);
		busyFlightsRequest.setNumberOfPassengers(PASSENGER_COUNT);
		
		Assert.assertEquals(ORGIN_IST, busyFlightsRequest.getOrigin());
		Assert.assertEquals(DESTINATION_AMS, busyFlightsRequest.getDestination());
		Assert.assertEquals(DEPARTURE_DATE, busyFlightsRequest.getDepartureDate());
		Assert.assertEquals(RETURN_DATE, busyFlightsRequest.getReturnDate());
		Assert.assertEquals(PASSENGER_COUNT, busyFlightsRequest.getNumberOfPassengers());
	}
	
}
