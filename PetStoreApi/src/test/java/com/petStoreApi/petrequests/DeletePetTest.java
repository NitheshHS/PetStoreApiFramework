package com.petStoreApi.petrequests;
import static io.restassured.RestAssured.given;

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
/**
 * This class written to delete a pet from petStrore
 * @author Nitheesha
 *
 */
public class DeletePetTest extends BaseTest{

	@Severity(SeverityLevel.MINOR)
	@Epic("PS_01")
	@Story("PS_05 user should able to delete the pet by using petId")
	@Description("In this request user should able to delete the pet from store")
	@Test
	public void deletePetTest()  {
		Tag[] tag=new Tag[] {new Tag(665544, "Supreeth")};
		Category category=new Category(665544, "Supreeth");
		PetPojo payLoad = new PetPojo(665544, category, "Supreeth", new String[] {"String"}, tag, "sold");
		Response response = given()
				.spec(spec)
				.body(payLoad)
				.when()
				.post(PathConstants.addNewPet);
		response.then()
		.log().all();
		String petId=response.jsonPath().getString("id");

		given()
			.spec(spec)
			.pathParam("petId", petId)
		.when()
			.delete(PathConstants.deletePet)
		.then()
			.log().all();
	}

}
