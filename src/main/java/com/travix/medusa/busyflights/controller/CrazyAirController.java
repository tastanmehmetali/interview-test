package com.travix.medusa.busyflights.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.service.ICrazyAirService;

@RestController
public class CrazyAirController {

	@Autowired
    private ICrazyAirService crazyAirService;

	@PostMapping(value = "/crazyair/flights")
    public @ResponseBody List<ISupplierResponse> getFlights(@Valid @RequestBody CrazyAirRequest crazyAirRequest){
    	return crazyAirService.getFlights(crazyAirRequest);
    }
    
}
