package com.travix.medusa.busyflights.universe;

public enum Supplier {

	CRAZYAIR("crazyAir"), TOUGHJET("toughJet");
	
	private String airlineName;

	private Supplier(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineName() {
		return airlineName;
	}
}
