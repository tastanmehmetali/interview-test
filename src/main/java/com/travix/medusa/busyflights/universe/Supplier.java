package com.travix.medusa.busyflights.universe;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;

public enum Supplier {

	CRAZYAIR("crazyAir") {
		@Override
		public SupplierRequest mappedBy(SupplierRequest supplierRequest) {
			BusyFlightsRequest busyFlightsRequest = (BusyFlightsRequest) supplierRequest;
			return new CrazyAirRequest(busyFlightsRequest);
		}

		@Override
		public BusyFlightsResponse convertTo(ISupplierResponse supplierResponse) {
			BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
			CrazyAirResponse crazyAirResponse = (CrazyAirResponse) supplierResponse;
			
			busyFlightsResponse.setAirline(crazyAirResponse.getAirline());
			busyFlightsResponse.setSupplier(getAirlineName());
			busyFlightsResponse.setFare(crazyAirResponse.getPrice());
			busyFlightsResponse.setDepartureAirportCode(crazyAirResponse.getDepartureAirportCode());
			busyFlightsResponse.setDestinationAirportCode(crazyAirResponse.getDestinationAirportCode());
			busyFlightsResponse.setDepartureDate(crazyAirResponse.getDepartureDate());
			busyFlightsResponse.setArrivalDate(crazyAirResponse.getArrivalDate());
			
			return busyFlightsResponse;
		}
	}, TOUGHJET("toughJet") {
		@Override
		public SupplierRequest mappedBy(SupplierRequest supplierRequest) {
			BusyFlightsRequest busyFlightsRequest = (BusyFlightsRequest) supplierRequest;
			return new ToughJetRequest(busyFlightsRequest);
		}

		@Override
		public BusyFlightsResponse convertTo(ISupplierResponse supplierResponse) {
			BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
			ToughJetResponse toughJetResponse = (ToughJetResponse) supplierResponse;
			
			busyFlightsResponse.setAirline(toughJetResponse.getCarrier());
			busyFlightsResponse.setSupplier(getAirlineName());
			busyFlightsResponse.setFare(toughJetResponse.getCalculatedFare());
			busyFlightsResponse.setDepartureAirportCode(toughJetResponse.getDepartureAirportName());
			busyFlightsResponse.setDestinationAirportCode(toughJetResponse.getArrivalAirportName());
			busyFlightsResponse.setDepartureDate(toughJetResponse.getOutboundDateTime());
			busyFlightsResponse.setArrivalDate(toughJetResponse.getInboundDateTime());
			
			return busyFlightsResponse;
		}
	};
	
	private String airlineName;

	private Supplier(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public abstract SupplierRequest mappedBy(SupplierRequest supplierRequest);
	public abstract BusyFlightsResponse convertTo(ISupplierResponse supplierResponse);

}
