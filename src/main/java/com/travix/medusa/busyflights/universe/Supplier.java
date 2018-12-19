package com.travix.medusa.busyflights.universe;

import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

public enum Supplier {

	CRAZYAIR("crazyAir") {
		@Override
		public SupplierRequest mappedBy(SupplierRequest supplierRequest) {
			BusyFlightsRequest busyFlightsRequest = (BusyFlightsRequest) supplierRequest;
			return new CrazyAirRequest(busyFlightsRequest);
		}
	}, TOUGHJET("toughJet") {
		@Override
		public SupplierRequest mappedBy(SupplierRequest supplierRequest) {
			BusyFlightsRequest busyFlightsRequest = (BusyFlightsRequest) supplierRequest;
			return new ToughJetRequest(busyFlightsRequest);
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
	
}
