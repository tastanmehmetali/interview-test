package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.endpoints.CrazyAirEndPoint;
import com.travix.medusa.busyflights.endpoints.ToughJetEndPoint;
import com.travix.medusa.busyflights.universe.Supplier;

@Service("busyFlightService")
public class BusyFlightService implements IBusyFlightService {

	private CrazyAirEndPoint crazyAirService;
	private ToughJetEndPoint toughJetService;

	public BusyFlightService() {
		crazyAirService = new CrazyAirEndPoint();
		toughJetService = new ToughJetEndPoint();
	}

	@Override
	public List<BusyFlightsResponse> getFlights(BusyFlightsRequest busyFlightsRequest) {
		List<BusyFlightsResponse> busyFlightsResponses = new ArrayList<>();
		busyFlightsResponses.addAll(crazyAirService.getFlights((CrazyAirRequest) Supplier.CRAZYAIR.mappedBy(busyFlightsRequest)));
		busyFlightsResponses.addAll(toughJetService.getFlights((ToughJetRequest) Supplier.TOUGHJET.mappedBy(busyFlightsRequest)));
		return sortAllItemsByFare(busyFlightsResponses);
	}

	private List<BusyFlightsResponse> sortAllItemsByFare(List<BusyFlightsResponse> busyFlightsResponses) {
		busyFlightsResponses.sort(Comparator.comparingDouble(BusyFlightsResponse::getFare));
		return busyFlightsResponses;
	}
	
}
