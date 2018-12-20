package com.travix.medusa.busyflights.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public class BusyFlightServiceTest {

	private static final int NUMBER_TWO = 2;
	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@InjectMocks
	private BusyFlightService busyFlightService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldCheckedGetFlightsByGivenBusyFlightsRequest() {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		
		List<BusyFlightsResponse> busyFlightsResponses = busyFlightService.getFlights(busyFlightsRequest);
		Assert.assertEquals(NUMBER_TWO, busyFlightsResponses.size());
	}

	private BusyFlightsRequest generateBusyFlightRequest() {
		BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
		busyFlightsRequest.setOrigin(ORGIN_IST);
		busyFlightsRequest.setDestination(DESTINATION_AMS);
		busyFlightsRequest.setDepartureDate(DEPARTURE_DATE);
		busyFlightsRequest.setReturnDate(RETURN_DATE);
		busyFlightsRequest.setNumberOfPassengers(PASSENGER_COUNT);
		return busyFlightsRequest;
	}
}
