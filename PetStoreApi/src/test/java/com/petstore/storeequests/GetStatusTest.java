package com.petstore.storeequests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class GetStatusTest {
	@Test
	public void test() {
		HashMap<Object, Object> job=new HashMap<Object, Object>();
		job.put("id", 12345);
		job.put("petId", 123456);
		job.put("quantity", 1);
		job.put("shipDate", "2021-02-10T07:11:55.622Z");
		job.put("status", "placed");
		job.put("complete", true);
		
		given()
			//.baseUri("https://petstore.swagger.io/v2")
			.contentType(ContentType.JSON)
			.body(job)
		.when()
			.post("https://petstore.swagger.io/v2/store/order")
		.then()
			.assertThat().statusCode(200)
		.and()
		.assertThat().header("Content-Type", "application/json")
			.log().all();
			
		
	}

}
