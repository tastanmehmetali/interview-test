package com.travix.medusa.busyflights.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.json.JSONArray;
import org.json.JSONObject;
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

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.universe.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class CrazyAirControllerTest {

	private static String serviceUrl = "/crazyair/flights";
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
	public void ShouldReturnCrazyAirListForGivenCrazyAirRequest() throws Exception {
		MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(serviceUrl)
				.contentType(MediaType.APPLICATION_JSON).content(generatedCrazyAirRequest().convertToJson()))
				.andReturn().getResponse();

		assertEquals(response.getStatus(), HttpStatus.OK.value());

		JSONArray crazyAirResponseArr = new JSONArray(response.getContentAsString());
		assertFalse(crazyAirResponseArr.isNull(0));

		JSONObject crazyAirResponse = crazyAirResponseArr.getJSONObject(0);
		assertEquals(Supplier.CRAZYAIR.getAirlineName(), crazyAirResponse.getString("airline"));
		assertEquals(ORGIN_IST, crazyAirResponse.getString("departureAirportCode"));
		assertEquals(DESTINATION_AMS, crazyAirResponse.getString("destinationAirportCode"));
		assertEquals(DEPARTURE_DATE, crazyAirResponse.getString("departureDate"));
		assertEquals(RETURN_DATE, crazyAirResponse.getString("arrivalDate"));
	}

	private static CrazyAirRequest generatedCrazyAirRequest() {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(ORGIN_IST);
		crazyAirRequest.setDestination(DESTINATION_AMS);
		crazyAirRequest.setDepartureDate(DEPARTURE_DATE);
		crazyAirRequest.setReturnDate(RETURN_DATE);
		crazyAirRequest.setPassengerCount(PASSENGER_COUNT);
		return crazyAirRequest;
	}
}
