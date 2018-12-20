package com.travix.medusa.busyflights.endpoints;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.universe.Supplier;

public class ToughJetEndPoint {

	private static String toughJetUrl = "http://localhost:8080/toughjet/flights";
	
	public List<BusyFlightsResponse> getFlights(ToughJetRequest request) {
		RestTemplate restTemplate = new RestTemplate();

		ToughJetResponse[] response = restTemplate.postForEntity(toughJetUrl, request, ToughJetResponse[].class)
				.getBody();

		return Arrays.stream(response).map(Supplier.TOUGHJET::convertTo).collect(toList());
	}

}
