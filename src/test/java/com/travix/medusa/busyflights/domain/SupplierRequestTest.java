package com.travix.medusa.busyflights.domain;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class SupplierRequestTest {

	@Test
	public void shouldCheckedConvertToJson() throws JSONException {
		SupplierRequest supplierRequest = new SupplierRequest() {};
		JSONObject supplierJson = new JSONObject(supplierRequest.convertToJson());
		Assert.assertEquals(SupplierRequest.NO_IMPLEMENTATION, supplierJson.getString("warning"));
	}
	
}
