package com.petStoreApi.petrequests;

import org.testng.annotations.Test;

import com.petStoreApi.base.BaseTest;
import com.petStoreApi.pojoClass.Category;
import com.petStoreApi.pojoClass.PetPojo;
import com.petStoreApi.pojoClass.Tag;
import com.petStoreApi.resourcePath.PathConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
/**
 * In this request pass pet id to get status
 * @author Nitheesha
 *
 */
public class GetPetById extends BaseTest{
	/**
	 * This method written for get the pet by passing id
	 */
	@Severity(SeverityLevel.BLOCKER)
	@Epic("PS_01")
	@Story("PS_03 create a request to get the status of the pet")
	@Description("In this request pass pet id to get status")
	@Test
	public void getPetIdTest() {
		Tag[] tagArr= {new Tag(887734, "German Sheherd")};

		PetPojo payLoad = new PetPojo(831059, new Category(887734, "German Shepherd"), "German Shepherd",new String[]{"String"}, tagArr, "available");

		Response response=given()
		.spec(spec)
		.body(payLoad)
		.when()
		.post(PathConstants.addNewPet);
		String petId=response.jsonPath().getString("id");
		response.then()
		.log().all();
		
		given()
		.spec(spec)
		.pathParam("petId", petId)
		.when()
		.get(PathConstants.getPetById)
		.then()

		.log().all();
	}
}
