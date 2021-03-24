package com.petStoreApi.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
	public RequestSpecification spec;
	@BeforeMethod
	public void setUp() {
		RequestSpecBuilder specBuilder=new RequestSpecBuilder();
		specBuilder.setBaseUri("https://petstore.swagger.io/v2");
		//specBuilder.setContentType(ContentType.BINARY);
		spec=specBuilder.build();
	}
	
	@AfterMethod
	public void tearDown() {
		
	}

}
