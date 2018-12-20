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

import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.universe.Supplier;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ToughJetControllerTest {
	
	private static String serviceUrl = "/toughjet/flights";
	private static final int PASSENGER_COUNT = 4;
	private static final String INBOUND_DATE = "2019-01-15";
	private static final String OUTBOUND_DATE = "2018-12-17";
	private static final String TO_AMS = "AMS";
	private static final String FROM_LHR = "LHR";

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
	
    @Test
    public void ShouldReturnToughJetListForGivenToughJetRequest() throws Exception {
    	MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.post(serviceUrl)
				.contentType(MediaType.APPLICATION_JSON).content(generatedToughJetRequest().convertToJson()))
				.andReturn().getResponse();
    	
    	assertEquals(response.getStatus(), HttpStatus.OK.value());
    	
    	JSONArray toughJetResponseArr = new JSONArray(response.getContentAsString());
    	assertFalse(toughJetResponseArr.isNull(0));
    	
    	JSONObject toughJetResponse = toughJetResponseArr.getJSONObject(0);
    	assertEquals(Supplier.TOUGHJET.getAirlineName(), toughJetResponse.getString("carrier"));
    	assertEquals(FROM_LHR, toughJetResponse.getString("departureAirportName"));
    	assertEquals(TO_AMS, toughJetResponse.getString("arrivalAirportName"));
    	assertEquals(OUTBOUND_DATE, toughJetResponse.getString("outboundDateTime"));
    	assertEquals(INBOUND_DATE, toughJetResponse.getString("inboundDateTime"));
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
}
