package com.travix.medusa.busyflights.endpoints;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.universe.Supplier;

public class CrazyAirEndPoint {
	
    private static String crazyAirUrl = "http://localhost:8080/crazyair/flights";
	
	public List<BusyFlightsResponse> getFlights(CrazyAirRequest request) {
		RestTemplate restTemplate = new RestTemplate();

		CrazyAirResponse[] response = restTemplate.postForEntity(crazyAirUrl, request, CrazyAirResponse[].class)
				.getBody();

		return Arrays.stream(response).map(Supplier.CRAZYAIR::convertTo).collect(toList());
	}

}
