package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

@Service("busyFlightService")
public class BusyFlightService implements IBusyFlightService {

	@Autowired
	private CrazyAirService crazyAirService;

	@Autowired
	private ToughJetService toughJetService;

	public BusyFlightService() {
		crazyAirService = new CrazyAirService();
		toughJetService = new ToughJetService();
	}

	@Override
	public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest) {
		List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();
		busyFlightsResponses.addAll(crazyAirService.gatheringAllFlights(busyFlightsRequest));
		busyFlightsResponses.addAll(toughJetService.gatheringAllFlights(busyFlightsRequest));
		return sortAllItemsByFare(busyFlightsResponses);
	}

	private List<BusyFlightsResponse> sortAllItemsByFare(List<BusyFlightsResponse> busyFlightsResponses) {
		busyFlightsResponses.sort(Comparator.comparingDouble(BusyFlightsResponse::getFare));
		return busyFlightsResponses;
	}
	
}
