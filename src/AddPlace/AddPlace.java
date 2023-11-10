package AddPlace;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import AddPJ.GoogleApi;
import AddPJ.Location;
import AddPJ.PutGoogle;
import AddPJ.RespGoogle;

public class AddPlace extends AddPlaceJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		GoogleApi p=new GoogleApi();
		p.setAccuracy(50);
		p.setAddress("jdh Frontline asd, layout, cohen 09");
		p.setLanguage("French-IN");
		Location lo=new Location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		p.setLocation(lo);
		p.setName("dhjdfb anwar");
		p.setPhone_number("(+91) 111 777 3937");
		List<String> st=new ArrayList<String>();
		st.add("shoe park");
		st.add("shop");
		p.setTypes(st);
		p.setWebsite("http://google.com");
		
		RequestSpecification req=(RequestSpecification) new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
		
		ResponseSpecification re=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		RespGoogle AddPlace=given().log().all().spec(req).body(p).expect().defaultParser(Parser.JSON)
		.when().post("/maps/api/place/add/json")
		.then().log().all().spec(re).extract().response().as(RespGoogle.class);
		
//		JsonPath js=new JsonPath(AddPlace);
//		String Place_id=js.getString("place_id");
//		
//		System.out.println(Place_id);
		String Place_id=AddPlace.getPlace_id();

		given().log().all().spec(req).queryParam("place_id", Place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().all().spec(re);
		
		PutGoogle pu=new PutGoogle();
		pu.setAddress("sajksfd asdjsd 235");
		pu.setKey("qaclick123");
		pu.setPlace_id(Place_id);
		
		given().log().all().spec(req)
		.body(pu)
		.when().put("/maps/api/place/update/json")
		.then().log().all().spec(re);
		
		given().log().all().spec(req).queryParam("place_id", Place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().all().spec(re);
		
		given().log().all().spec(req)
		.body("{\r\n"
				+ "    \"place_id\":\""+Place_id +"\"\r\n"
				+ "}\r\n"
				+ "")
		.when().post("/maps/api/place/delete/json")
		.then().log().all().spec(re);
	}

}
