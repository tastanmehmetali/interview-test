package com.travix.medusa.busyflights.domain.crazyair;

import org.junit.Assert;
import org.junit.Test;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class CrazyAirRequestTests {

	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@Test
	public void shouldCreatedCrazyAirRequestCheck() {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(ORGIN_IST);
		crazyAirRequest.setDestination(DESTINATION_AMS);
		crazyAirRequest.setDepartureDate(DEPARTURE_DATE);
		crazyAirRequest.setReturnDate(RETURN_DATE);
		crazyAirRequest.setPassengerCount(PASSENGER_COUNT);

		Assert.assertEquals(ORGIN_IST, crazyAirRequest.getOrigin());
		Assert.assertEquals(DESTINATION_AMS, crazyAirRequest.getDestination());
		Assert.assertEquals(DEPARTURE_DATE, crazyAirRequest.getDepartureDate());
		Assert.assertEquals(RETURN_DATE, crazyAirRequest.getReturnDate());
		Assert.assertEquals(PASSENGER_COUNT, crazyAirRequest.getPassengerCount());
	}

	@Test
	public void shouldCreatedCrazyAirRequestByGivenBusyFlights() {
		BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
		busyFlightsRequest.setOrigin(ORGIN_IST);
		busyFlightsRequest.setDestination(DESTINATION_AMS);
		busyFlightsRequest.setDepartureDate(DEPARTURE_DATE);
		busyFlightsRequest.setReturnDate(RETURN_DATE);
		busyFlightsRequest.setNumberOfPassengers(PASSENGER_COUNT);
		
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest(busyFlightsRequest);
		Assert.assertEquals(ORGIN_IST, crazyAirRequest.getOrigin());
		Assert.assertEquals(DESTINATION_AMS, crazyAirRequest.getDestination());
		Assert.assertEquals(DEPARTURE_DATE, crazyAirRequest.getDepartureDate());
		Assert.assertEquals(RETURN_DATE, crazyAirRequest.getReturnDate());
		Assert.assertEquals(PASSENGER_COUNT, crazyAirRequest.getPassengerCount());
	}
}
