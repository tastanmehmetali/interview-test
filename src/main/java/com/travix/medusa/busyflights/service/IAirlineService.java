package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;

public interface IAirlineService {

	List<ISupplierResponse> getFlights(SupplierRequest supplierRequest);

	List<BusyFlightsResponse> gatheringAllFlights(SupplierRequest supplierRequest);
}
