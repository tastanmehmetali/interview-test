package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;

public interface ICrazyAirService {
	
	List<ISupplierResponse> getFlights(CrazyAirRequest crazyAirRequest);
	
}
