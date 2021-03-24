package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.petStoreApi.pojoClass.Category;
import com.petStoreApi.pojoClass.PetPojo;
import com.petStoreApi.pojoClass.Tag;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.http.ContentType;

public class GetRequest {
	@Test
	public void test() {
		given()
			.baseUri("https://petstore.swagger.io/v2")
			.contentType(ContentType.JSON)
		.when()	
			.get("/pet/findByStatus?status=available")
		.then()
			.assertThat().statusCode(200)
			.and()
			.log().all();
	}
	
	@Test
	public void test2() {
//		HashMap<Object, Object> category=new HashMap<Object, Object>();
//		category.put("id", 1234);
//		category.put("name", "dog");
//		String[] photoUrls=new String[] {"url1"};
//		
//		HashMap<Object, Object> tag=new HashMap<Object, Object>();
//		category.put("id", 1234);
//		category.put("name", "dog");
//		Object[] tags=new Object[] {tag};
//		JSONObject obj=new JSONObject();
//		obj.put("id", 1234567);
//		obj.put("category", category);
//		obj.put("name", "dog");
//		obj.put("photoUrls", photoUrls);
//		obj.put("tags", tags);
//		obj.put("status", "available");
		Category category = new Category(57765765, "fish");
		String[] photoUrls= new String[] {"http://pet.img"};
		Tag[] tag=new Tag[] {new Tag(68565, "fish")};
		PetPojo petInfo = new PetPojo(56765, category, "Fish", photoUrls, tag, "sold");
		given()
			.contentType(ContentType.JSON)
			.body(petInfo)
			.baseUri("https://petstore.swagger.io/v2")
		.when()
			.post("/pet")
		.then()
			.log().all();
	}

}
