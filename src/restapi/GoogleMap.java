package restapi;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;  
public class GoogleMap {

	
public static void main(String[]args) {	
	
	RestAssured.baseURI="https://rahulshettyacademy.com";
	
given().log().all().queryParam("key", "qaclick123").headers("Content-type","application/json").body("").when().post().then().log()


;


}
	
}
