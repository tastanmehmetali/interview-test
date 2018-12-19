package com.travix.medusa.busyflights.universe;

import org.junit.Assert;
import org.junit.Test;

import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

public class SupplierTest {

	private static final int PASSENGER_COUNT = 4;
	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";

	@Test
	public void shouldCheckedMappedByForCrazyAirReturnType() {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		Supplier crazyAir = Supplier.CRAZYAIR;
		SupplierRequest supplierRequest = crazyAir.mappedBy(busyFlightsRequest);
		
		Assert.assertTrue(supplierRequest instanceof CrazyAirRequest);
	}

	@Test
	public void shouldCheckedMappedByForToughJetReturnType() {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		Supplier toughtJet = Supplier.TOUGHJET;
		SupplierRequest supplierRequest = toughtJet.mappedBy(busyFlightsRequest);
		
		Assert.assertTrue(supplierRequest instanceof ToughJetRequest);
	}
	
	@Test
	public void shouldCheckedMappedByForCrazyAir() {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		Supplier crazyAir = Supplier.CRAZYAIR;
		SupplierRequest supplierRequest = crazyAir.mappedBy(busyFlightsRequest);
		
		Assert.assertTrue(supplierRequest instanceof CrazyAirRequest);
		
		CrazyAirRequest crazyAirRequest = (CrazyAirRequest) supplierRequest;
		Assert.assertEquals(busyFlightsRequest.getOrigin(), crazyAirRequest.getOrigin());
		Assert.assertEquals(busyFlightsRequest.getDestination(), crazyAirRequest.getDestination());
		Assert.assertEquals(busyFlightsRequest.getDepartureDate(), crazyAirRequest.getDepartureDate());
		Assert.assertEquals(busyFlightsRequest.getReturnDate(), crazyAirRequest.getReturnDate());
		Assert.assertEquals(busyFlightsRequest.getNumberOfPassengers(), crazyAirRequest.getPassengerCount());
	}
	
	@Test
	public void shouldCheckedMappedByForToughJet() {
		BusyFlightsRequest busyFlightsRequest = generateBusyFlightRequest();
		Supplier toughJet = Supplier.TOUGHJET;
		SupplierRequest supplierRequest = toughJet.mappedBy(busyFlightsRequest);
		
		Assert.assertTrue(supplierRequest instanceof ToughJetRequest);
		
		ToughJetRequest toughJetRequest = (ToughJetRequest) supplierRequest;
		Assert.assertEquals(busyFlightsRequest.getOrigin(), toughJetRequest.getFrom());
		Assert.assertEquals(busyFlightsRequest.getDestination(), toughJetRequest.getTo());
		Assert.assertEquals(busyFlightsRequest.getDepartureDate(), toughJetRequest.getOutboundDate());
		Assert.assertEquals(busyFlightsRequest.getReturnDate(), toughJetRequest.getInboundDate());
		Assert.assertEquals(busyFlightsRequest.getNumberOfPassengers(), toughJetRequest.getNumberOfAdults());
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
