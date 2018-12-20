package com.travix.medusa.busyflights.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.universe.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BusyFlightsControllerTest {

	private static String serviceUrl = "/busy/flights";
	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void ShouldReturnBusyFlightListForGivenBusyFlightRequest() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(serviceUrl)
				.contentType(MediaType.APPLICATION_JSON).content(generateBusyFlightRequest().convertToJson()))
				.andReturn().getResponse();

		assertEquals(response.getStatus(), HttpStatus.OK.value());

		JSONArray busyFlightResponseArr = new JSONArray(response.getContentAsString());
		assertFalse(busyFlightResponseArr.isNull(0));
		assertFalse(busyFlightResponseArr.isNull(1));

		JSONObject firstFlight = busyFlightResponseArr.getJSONObject(0);
		JSONObject secondFlight = busyFlightResponseArr.getJSONObject(1);

		assertEquals(Supplier.TOUGHJET.getAirlineName(), firstFlight.getString("airline"));
		assertEquals(Supplier.TOUGHJET.getSupplierName(), firstFlight.getString("supplier"));

		assertEquals(Supplier.CRAZYAIR.getAirlineName(), secondFlight.getString("airline"));
		assertEquals(Supplier.CRAZYAIR.getSupplierName(), secondFlight.getString("supplier"));

		Double firstFlightFare = firstFlight.getDouble("fare");
		Double secondFlightFare = secondFlight.getDouble("fare");
		Assert.assertNotEquals(secondFlightFare.compareTo(firstFlightFare), -1);
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
