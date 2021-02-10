package com.petStoreApi.petrequests;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.petStoreApi.base.BaseTest;
import com.petStoreApi.pojoClass.Category;
import com.petStoreApi.pojoClass.PetPojo;
import com.petStoreApi.pojoClass.Tag;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
/**
 * In this request we are creating the pet by passing payload
 * @author Nitheesha
 *
 */
public class AddPetTest extends BaseTest{
	/**
	 * This TestCase method written for add new pet by using api
	 * @throws Throwable
	 * @throws Throwable
	 * @throws IOException
	 */
	@Severity(SeverityLevel.CRITICAL)
	@Epic("PS_01")
	@Story("PS_02 Test an api to add pet to petStore")
	@Description("In this request we are creating the pet by passing payload")
	@Test
	public void addPetTest() throws Throwable, Throwable, IOException {
		Category category=new Category(1234567, "Cat");
		Tag[] tagArr= {new Tag(1234567, "Cat"),new Tag(1234569, "Rat")};
		
		String[] photoUrls= {"String"};
		PetPojo pojo = new PetPojo(123456, category, "cat", photoUrls, tagArr, "sold");
		
		given()
			.spec(spec)
			.body(pojo)
		.when()
			.post("/pet")
		.then()
		.statusCode(200)
		.and()
		.time(Matchers.lessThan(2000l), TimeUnit.SECONDS)
		.log().all();
		
	}

}
