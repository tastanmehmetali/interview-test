package com.travix.medusa.busyflights.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.IBusyFlightService;

@RestController
public class BusyFlightsController {

	@Autowired
	private IBusyFlightService busyFlightService;

	@PostMapping(value = "/busy/flights")
	public @ResponseBody List<BusyFlightsResponse> getFlights(@Valid @RequestBody BusyFlightsRequest request) {
		return busyFlightService.getFlights(request);
	}
}
