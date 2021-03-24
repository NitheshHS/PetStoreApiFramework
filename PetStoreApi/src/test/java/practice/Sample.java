package practice;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.petStoreApi.pojoClass.StorePojo;

public class Sample {
public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
	//StorePojo pojo = new StorePojo(123, 123, 1, "2021-02-10T11:34:31.796Z", "placed", true);
	ObjectMapper map=new ObjectMapper();
	//map.writeValue(new File("./abc.json"), pojo);
	//System.out.println("sucess");
	StorePojo storeVar = map.readValue(new File("./abc.json"), StorePojo.class);
	int id = storeVar.getId();
	System.out.println(id);
}
}
