package AddPlace;

import static io.restassured.RestAssured.given;

import Pojo.MapJson;
import Pojo.getJ;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	RestAssured.baseURI="https://rahulshettyacademy.com";
	
		
		getJ jp=given().log().all().spec(MapJson.reqSpe())
		.body(MapJson.map())
		.when().post("/maps/api/place/add/json")
		.then().log().all().spec(MapJson.resSpe()).extract().response().as(getJ.class);
		
		String Place_id=jp.getPlace_id();
		
		String id=jp.getId();
		System.out.println(id);
				
		given().log().all().spec(MapJson.reqSpe()).queryParam("place_id", Place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().all().spec(MapJson.resSpe());
		
		given().log().all().spec(MapJson.reqSpe())
		.body(MapJson.putJ(Place_id))
		.when().put("/maps/api/place/update/json")
		.then().log().all().spec(MapJson.resSpe());
		
		given().log().all().spec(MapJson.reqSpe()).queryParam("place_id", Place_id)
		.when().get("/maps/api/place/get/json")
		.then().log().all().spec(MapJson.resSpe());
		
		given().log().all().spec(MapJson.reqSpe())
		.body("{\r\n"
				+ "    \"place_id\":\""+Place_id+"\"\r\n"
				+ "}")
		.when().delete("/maps/api/place/delete/json")
		.then().log().all().spec(MapJson.resSpe());
		
		
	}

}
