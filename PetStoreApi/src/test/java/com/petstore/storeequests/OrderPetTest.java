package com.petstore.storeequests;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.petStoreApi.base.BaseTest;
import com.petStoreApi.pojoClass.Category;
import com.petStoreApi.pojoClass.PetPojo;
import com.petStoreApi.pojoClass.StorePojo;
import com.petStoreApi.pojoClass.Tag;
import com.petStoreApi.resourcePath.PathConstants;
import com.petStoreApi.resourcePath.StorePath;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
/**
 * 
 * @author Nitheesha
 *
 */
public class OrderPetTest extends BaseTest{

	@Severity(SeverityLevel.CRITICAL)
	@Epic("PS_02")
	@Story("PS_07 user should able to add order a pet and also able to check the order status by passing order id")
	@Test
	public void orderPetTest() {
		Category category = new Category(764533, "BullDog");
		String[] photoUrls= {"url"};
		Tag[] tag = new Tag[] {new Tag(764533, "BullDog")};
		PetPojo petPayLoad = new PetPojo(764533, category, "BullDog", photoUrls, tag, "available");
		Response response = given()	
			.spec(spec)
			.body(petPayLoad)
		.when()
			.post(PathConstants.addNewPet);
		 
		response.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.and()
			.assertThat().time(Matchers.lessThan(2000l), TimeUnit.SECONDS)
		.and()
			.log().all();
		int petId=response.jsonPath().getInt("id");
		
		
		StorePojo storePayLoad = new StorePojo(12345,petId, 2, "2021-02-10T04:41:28.289Z", "placed", true);
		Response storeResponse = given()
			.spec(spec)
			.body(storePayLoad)
		.when()
			.post(StorePath.placeOrderPet);
		storeResponse.then()
		.assertThat().statusCode(200)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.and()
			.assertThat().time(Matchers.lessThan(2000l), TimeUnit.SECONDS)
		.and()
			.log().all();
		int orderId=storeResponse.jsonPath().getInt("id");
		
		given()
			.spec(spec)
			.pathParam("orderId", orderId)
		.when()
			.get(StorePath.findPurchaseOrder)
		.then()
			.assertThat().statusCode(200)
		.and()
			.assertThat().contentType(ContentType.JSON)
		.and()
			.assertThat().time(Matchers.lessThan(2000l), TimeUnit.SECONDS)
		.and()
			.log().all();
			
	}
}
