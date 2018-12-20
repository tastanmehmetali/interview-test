package com.travix.medusa.busyflights.universe;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public class SupplierTest {

	private static final String RETURN_DATE = "2019-01-15";
	private static final String DEPARTURE_DATE = "2018-12-17";
	private static final String DESTINATION_AMS = "AMS";
	private static final String ORGIN_IST = "IST";
	private static final String CABIN_CLASS_ECONOMY = "Economy";
	private static final String AIRLINE = "TK";
	
	private static final int PASSENGER_COUNT = 4;
	private static final double PRICE = 100.00;
	private static final double DISCOUNT = 5.0;
	private static final int TAX = 10;
	private static final int ZERO = 0;
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
	
	@Test
	public void shouldCheckedConvertToBusyFlightsResponseGivenCrazyAirResponse() {
		CrazyAirResponse crazyAirResponse = generatedCrazyAirResponse();
		
		Supplier crazyAir = Supplier.CRAZYAIR;
		BusyFlightsResponse busyFlightsResponse = crazyAir.convertTo(crazyAirResponse);
		
		Assert.assertEquals(AIRLINE, busyFlightsResponse.getAirline());
		Assert.assertEquals(crazyAir.getSupplierName(), busyFlightsResponse.getSupplier());
		Assert.assertEquals(ZERO, PRICE, busyFlightsResponse.getFare());
		Assert.assertEquals(ORGIN_IST, busyFlightsResponse.getDepartureAirportCode());
		Assert.assertEquals(DESTINATION_AMS, busyFlightsResponse.getDestinationAirportCode());
		Assert.assertEquals(DEPARTURE_DATE, busyFlightsResponse.getDepartureDate());
		Assert.assertEquals(RETURN_DATE, busyFlightsResponse.getArrivalDate());
	}

	private CrazyAirResponse generatedCrazyAirResponse() {
		CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
		crazyAirResponse.setAirline(AIRLINE);
		crazyAirResponse.setPrice(PRICE);
		crazyAirResponse.setCabinclass(CABIN_CLASS_ECONOMY);
		crazyAirResponse.setDepartureAirportCode(ORGIN_IST);
		crazyAirResponse.setDestinationAirportCode(DESTINATION_AMS);
		crazyAirResponse.setDepartureDate(DEPARTURE_DATE);
		crazyAirResponse.setArrivalDate(RETURN_DATE);
		return crazyAirResponse;
	}
	
	@Test
	public void shouldCheckedConvertToBusyFlightsResponseGivenToughJetResponse() {
		ToughJetResponse toughJetResponse = generatedToughJetResponse();
		
		Supplier toughJet = Supplier.TOUGHJET;
		BusyFlightsResponse busyFlightsResponse = toughJet.convertTo(toughJetResponse);
		
		Assert.assertEquals(AIRLINE, busyFlightsResponse.getAirline());
		Assert.assertEquals(toughJet.getSupplierName(), busyFlightsResponse.getSupplier());
		Assert.assertEquals(ZERO, PRICE, busyFlightsResponse.getFare());
		Assert.assertEquals(ORGIN_IST, busyFlightsResponse.getDepartureAirportCode());
		Assert.assertEquals(DESTINATION_AMS, busyFlightsResponse.getDestinationAirportCode());
		Assert.assertEquals(DEPARTURE_DATE, busyFlightsResponse.getDepartureDate());
		Assert.assertEquals(RETURN_DATE, busyFlightsResponse.getArrivalDate());
	}

	private ToughJetResponse generatedToughJetResponse() {
		ToughJetResponse toughJetResponse = new ToughJetResponse();
		toughJetResponse.setCarrier(AIRLINE);
		toughJetResponse.setBasePrice(PRICE);
		toughJetResponse.setTax(TAX);
		toughJetResponse.setDiscount(DISCOUNT);
		toughJetResponse.setDepartureAirportName(ORGIN_IST);
		toughJetResponse.setArrivalAirportName(DESTINATION_AMS);
		toughJetResponse.setOutboundDateTime(DEPARTURE_DATE);
		toughJetResponse.setInboundDateTime(RETURN_DATE);
		return toughJetResponse;
	}
	
	@Test
	public void shouldCheckedSupplierNameForCrazyAir() {
		Supplier crazyAir = Supplier.CRAZYAIR;
		Assert.assertEquals(crazyAir.getAirlineName().toUpperCase(Locale.US), crazyAir.getSupplierName());
	}
	
	@Test
	public void shouldCheckedSupplierNameForToughJet() {
		Supplier crazyAir = Supplier.TOUGHJET;
		Assert.assertEquals(crazyAir.getAirlineName().toUpperCase(Locale.US), crazyAir.getSupplierName());
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
