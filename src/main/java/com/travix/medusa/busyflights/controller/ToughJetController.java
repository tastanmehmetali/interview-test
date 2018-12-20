package com.travix.medusa.busyflights.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.ISupplierResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.service.IToughJetService;

@RestController
public class ToughJetController {

    @Autowired
    private IToughJetService toughJetApiService;

    @PostMapping(value = "/toughjet/flights")
    public @ResponseBody List<ISupplierResponse> getFlights(@Valid @RequestBody ToughJetRequest toughJetRequest){
    	return toughJetApiService.getFlights(toughJetRequest);
    }
}
