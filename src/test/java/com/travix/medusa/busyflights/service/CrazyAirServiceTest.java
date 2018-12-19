package com.travix.medusa.busyflights.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.universe.Supplier;

public class CrazyAirServiceTest {

	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";
	
	@Test
	public void shouldCheckedGetFlightByGivenCrazyAirRequest(){
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(ORGIN_IST);
		crazyAirRequest.setDestination(DESTINATION_AMS);
		crazyAirRequest.setDepartureDate(DEPARTURE_DATE);
		crazyAirRequest.setReturnDate(RETURN_DATE);
		crazyAirRequest.setPassengerCount(PASSENGER_COUNT);
		
		CrazyAirService crazyAirService = new CrazyAirService();
		List<ISupplierResponse> crazyAirLists = crazyAirService.getFlights(crazyAirRequest);
		CrazyAirResponse crazyAirResponse = (CrazyAirResponse) crazyAirLists.get(0); 
		Assert.assertEquals(crazyAirResponse.getDepartureAirportCode(), crazyAirRequest.getOrigin());
		Assert.assertEquals(crazyAirResponse.getDestinationAirportCode(), crazyAirRequest.getDestination());
		Assert.assertEquals(crazyAirResponse.getDepartureDate(), crazyAirRequest.getDepartureDate());
		Assert.assertEquals(crazyAirResponse.getArrivalDate(), crazyAirRequest.getReturnDate());
		Assert.assertEquals(crazyAirResponse.getAirline(), Supplier.CRAZYAIR.getAirlineName());
	}
	
}
