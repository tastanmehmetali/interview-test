package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;

public interface IToughJetService {
	
	List<ISupplierResponse> getFlights(ToughJetRequest toughJetRequest) ;
	
}
