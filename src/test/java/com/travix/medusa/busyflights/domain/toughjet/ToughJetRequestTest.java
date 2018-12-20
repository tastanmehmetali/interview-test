package com.travix.medusa.busyflights.domain.toughjet;

import static org.junit.Assert.assertEquals;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class ToughJetRequestTest {

	private static final int PASSENGER_COUNT = 4;
	private static final String INBOUND_DATE = "2019-01-15";
	private static final String OUTBOUND_DATE = "2018-12-17";
	private static final String TO_AMS = "AMS";
	private static final String FROM_LHR = "LHR";

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldCreatedToughJetRequestCheck() {
		ToughJetRequest toughJetRequest = generatedToughJetRequest();

		Assert.assertEquals(FROM_LHR, toughJetRequest.getFrom());
		Assert.assertEquals(TO_AMS, toughJetRequest.getTo());
		Assert.assertEquals(OUTBOUND_DATE, toughJetRequest.getOutboundDate());
		Assert.assertEquals(INBOUND_DATE, toughJetRequest.getInboundDate());
		Assert.assertEquals(PASSENGER_COUNT, toughJetRequest.getNumberOfAdults());
	}

	private ToughJetRequest generatedToughJetRequest() {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(FROM_LHR);
		toughJetRequest.setTo(TO_AMS);
		toughJetRequest.setOutboundDate(OUTBOUND_DATE);
		toughJetRequest.setInboundDate(INBOUND_DATE);
		toughJetRequest.setNumberOfAdults(PASSENGER_COUNT);
		return toughJetRequest;
	}

//	@Test
//	public void shouldCreatedToughJetRequestByGivenBusyFlightsIsNull() {
//		try {
//			new ToughJetRequest(null);
//		} catch (ValidationException e) {
//			Assert.assertEquals(e.getMessage(), "BusyFlight can not be null!");
//		} 
//	}

	// @Test
	// public void
	// shouldCreatedToughJetRequestByGivenBusyFlightsHasEmptyAttribute() throws
	// ValidationException {
	// thrown.expect(ValidationException.class);
	// thrown.expectMessage("any attributes of BusyFlight can not be null /
	// empty!");
	// new ToughJetRequest(new BusyFlightsRequest());
	// }

	@Test
	public void shouldCreatedToughJetRequestByGivenBusyFlights() {
		BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
		busyFlightsRequest.setOrigin(FROM_LHR);
		busyFlightsRequest.setDestination(TO_AMS);
		busyFlightsRequest.setDepartureDate(OUTBOUND_DATE);
		busyFlightsRequest.setReturnDate(INBOUND_DATE);
		busyFlightsRequest.setNumberOfPassengers(PASSENGER_COUNT);

		ToughJetRequest toughJetRequest = new ToughJetRequest(busyFlightsRequest);
		Assert.assertEquals(FROM_LHR, toughJetRequest.getFrom());
		Assert.assertEquals(TO_AMS, toughJetRequest.getTo());
		Assert.assertEquals(OUTBOUND_DATE, toughJetRequest.getOutboundDate());
		Assert.assertEquals(INBOUND_DATE, toughJetRequest.getInboundDate());
		Assert.assertEquals(PASSENGER_COUNT, toughJetRequest.getNumberOfAdults());
	}
	
	@Test
	public void shouldCheckedConvertToJsonByGivenCrazyAirRequest() throws JSONException {
		ToughJetRequest toughJetRequest = generatedToughJetRequest();
		
		JSONObject generatedJsonObject = new JSONObject(toughJetRequest.convertToJson());
		assertEquals(FROM_LHR, generatedJsonObject.getString("from"));
		assertEquals(TO_AMS, generatedJsonObject.getString("to"));
		assertEquals(OUTBOUND_DATE, generatedJsonObject.getString("outboundDate"));
		assertEquals(INBOUND_DATE, generatedJsonObject.getString("inboundDate"));
		assertEquals(PASSENGER_COUNT, generatedJsonObject.getInt("numberOfAdults"));
	}

}
