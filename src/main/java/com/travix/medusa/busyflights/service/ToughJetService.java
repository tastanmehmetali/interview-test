package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.SupplierRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.universe.Supplier;

@Service("toughJetService")
public class ToughJetService implements IToughJetService, IAirlineService {

	private static final double DISCOUNT = 5.0;
	private static final int TAX = 10;
	private static final double BASE_PRICE = 100.00;
	
	@Override
	public List<ISupplierResponse> getFlights(ToughJetRequest toughJetRequest) {
		List<ISupplierResponse> toughJetResponses = new ArrayList<>();
		toughJetResponses.add(generatedToughJetResponse(toughJetRequest));
		return toughJetResponses;
	}

	private ISupplierResponse generatedToughJetResponse(ToughJetRequest toughJetRequest) {
		ToughJetResponse toughJetResponse = new ToughJetResponse();
		toughJetResponse.setCarrier(Supplier.TOUGHJET.getAirlineName());
		toughJetResponse.setBasePrice(BASE_PRICE);
		toughJetResponse.setTax(TAX);
		toughJetResponse.setDiscount(DISCOUNT);
		toughJetResponse.setDepartureAirportName(toughJetRequest.getFrom());
		toughJetResponse.setArrivalAirportName(toughJetRequest.getTo());
		toughJetResponse.setOutboundDateTime(toughJetRequest.getOutboundDate());
		toughJetResponse.setInboundDateTime(toughJetRequest.getInboundDate());
		
		return toughJetResponse;
	}

	@Override
	public List<ISupplierResponse> getFlights(SupplierRequest supplierRequest) {
		List<ISupplierResponse> toughJetResponses = new ArrayList<>();
		toughJetResponses.add(generatedToughJetResponse((ToughJetRequest) Supplier.TOUGHJET.mappedBy(supplierRequest)));
		return toughJetResponses;
	}

}
