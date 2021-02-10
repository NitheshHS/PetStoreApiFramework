package com.petStoreApi.petrequests;

import org.testng.annotations.Test;

import com.petStoreApi.base.BaseTest;
import com.petStoreApi.resourcePath.PathConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

import static io.restassured.RestAssured.*;

import java.io.File;
/**
 * 
 * @author Nitheesha
 *
 */
public class AddPetImage extends BaseTest{
	@Severity(SeverityLevel.MINOR)
	@Epic("PS_01")
	@Story("PS_06 user should able to add pet image")
	@Description("In this request user should able to add pet image")
	@Test
	public void addPetImageTest() {
		given()
			.multiPart(new File(".\\PetImages\\PetImage.PNG"))
			.spec(spec)
			.pathParam("petId", "123456")
		.when()
			.post(PathConstants.uploadPetImage)
		.then()
			.log().all();
	}

}
