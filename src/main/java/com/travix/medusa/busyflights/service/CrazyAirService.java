package com.travix.medusa.busyflights.service;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.universe.Supplier;

@Service("crazyAirService")
public class CrazyAirService implements ICrazyAirService, IAirlineService {
	
	private static final String CABIN_CLASS_ECONOMY = "Economy";
	private static final double PRICE = 200.00;
	
	@Override
	public List<ISupplierResponse> getFlights(CrazyAirRequest crazyAirRequest) {
		List<ISupplierResponse> crazyAirResponses = new ArrayList<>();
		crazyAirResponses.add(generatedCrazyAirResponse(crazyAirRequest));
		return crazyAirResponses;
	}

	@Override
	public List<ISupplierResponse> getFlights(SupplierRequest supplierRequest) {
		List<ISupplierResponse> crazyAirResponses = new ArrayList<>();
		crazyAirResponses.add(generatedCrazyAirResponse((CrazyAirRequest) Supplier.CRAZYAIR.mappedBy(supplierRequest)));
		return crazyAirResponses;
	}

	@Override
	public List<BusyFlightsResponse> gatheringAllFlights(SupplierRequest supplierRequest) {
		return getFlights(supplierRequest).stream().map(Supplier.CRAZYAIR::convertTo).collect(toList());
	}
	
	private ISupplierResponse generatedCrazyAirResponse(CrazyAirRequest crazyAirRequest) {
		CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
		crazyAirResponse.setAirline(Supplier.CRAZYAIR.getAirlineName());
		crazyAirResponse.setPrice(PRICE);
		crazyAirResponse.setCabinclass(CABIN_CLASS_ECONOMY);
		crazyAirResponse.setDepartureAirportCode(crazyAirRequest.getOrigin());
		crazyAirResponse.setDestinationAirportCode(crazyAirRequest.getDestination());
		crazyAirResponse.setDepartureDate(crazyAirRequest.getDepartureDate());
		crazyAirResponse.setArrivalDate(crazyAirRequest.getReturnDate());

		return crazyAirResponse;
	}

}
