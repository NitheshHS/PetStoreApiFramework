package com.petStoreApi.petrequests;
/**
 * This api test written for get the status of pet by using query parameter
 * @author Nitheesha
 *
 */

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.petStoreApi.base.BaseTest;
import com.petStoreApi.resourcePath.PathConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
public class GetStatusofPetTest extends BaseTest{
	@Severity(SeverityLevel.BLOCKER)
	@Epic("PS_01")
	@Story("PS_04 create a request to get the status of the pet by giving query parameter as sold")
	@Description("This api test written for get the status of pet by using query parameter")
	@Test
	public void getStatusofPetTest() {
		given()
			.spec(spec)
			.queryParam("status", "sold")
		.when()
			.get(PathConstants.petStatus)
		.then()
			.assertThat().statusCode(200)
			.and()
			.assertThat().time(Matchers.lessThan(2000l), TimeUnit.SECONDS)
			.and()
			.log().all();
	}

}
