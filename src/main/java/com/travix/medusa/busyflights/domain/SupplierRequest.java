package com.travix.medusa.busyflights.domain;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class SupplierRequest {

	public static final String NO_IMPLEMENTATION = "No Implementation !";

	public String convertToJson() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("warning", NO_IMPLEMENTATION);
		return jsonObject.toString();
	}
	
}
