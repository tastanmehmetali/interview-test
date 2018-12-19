package com.travix.medusa.busyflights.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.universe.Supplier;

public class ToughJetServiceTest {

	private static final int PASSENGER_COUNT = 4;
	private static final String INBOUND_DATE = "2019-01-15";
	private static final String OUTBOUND_DATE = "2018-12-17";
	private static final String TO_AMS = "AMS";
	private static final String FROM_LHR = "LHR";

	@Test
	public void shouldCheckedGetFlightByGivenToughJetRequest() {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(FROM_LHR);
		toughJetRequest.setTo(TO_AMS);
		toughJetRequest.setOutboundDate(OUTBOUND_DATE);
		toughJetRequest.setInboundDate(INBOUND_DATE);
		toughJetRequest.setNumberOfAdults(PASSENGER_COUNT);
		
		ToughJetService toughJetService = new ToughJetService();
		List<ISupplierResponse> toughJetLists = toughJetService.getFlights(toughJetRequest);
		
		ToughJetResponse toughJetResponse = (ToughJetResponse) toughJetLists.get(0); 
		Assert.assertEquals(toughJetResponse.getDepartureAirportName(), toughJetRequest.getFrom());
		Assert.assertEquals(toughJetResponse.getArrivalAirportName(), toughJetRequest.getTo());
		Assert.assertEquals(toughJetResponse.getInboundDateTime(), toughJetRequest.getInboundDate());
		Assert.assertEquals(toughJetResponse.getOutboundDateTime(), toughJetRequest.getOutboundDate());
		Assert.assertEquals(toughJetResponse.getCarrier(), Supplier.TOUGHJET.getAirlineName());
	}
}