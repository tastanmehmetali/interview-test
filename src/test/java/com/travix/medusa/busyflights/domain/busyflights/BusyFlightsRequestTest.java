package com.travix.medusa.busyflights.domain.busyflights;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

public class BusyFlightsRequestTest {

	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@Test
	public void shouldCreatedBusyFlightsRequestCheck() {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		
		assertEquals(ORGIN_IST, busyFlightsRequest.getOrigin());
		assertEquals(DESTINATION_AMS, busyFlightsRequest.getDestination());
		assertEquals(DEPARTURE_DATE, busyFlightsRequest.getDepartureDate());
		assertEquals(RETURN_DATE, busyFlightsRequest.getReturnDate());
		assertEquals(PASSENGER_COUNT, busyFlightsRequest.getNumberOfPassengers());
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
	
	@Test
	public void shouldCheckedConvertToJsonByGivenBusyFlightsRequest() throws JSONException {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		
		JSONObject generatedJsonObject = new JSONObject(busyFlightsRequest.convertToJson());
		assertEquals(ORGIN_IST, generatedJsonObject.getString("origin"));
		assertEquals(DESTINATION_AMS, generatedJsonObject.getString("destination"));
		assertEquals(DEPARTURE_DATE, generatedJsonObject.getString("departureDate"));
		assertEquals(RETURN_DATE, generatedJsonObject.getString("returnDate"));
		assertEquals(PASSENGER_COUNT, generatedJsonObject.getInt("numberOfPassengers"));
	}
	
}
