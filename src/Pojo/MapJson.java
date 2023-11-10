package Pojo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class MapJson {
	
	public static String addJ() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	
	public static String putJ(String place_id) {
		return "{\r\n"
				+ "\"place_id\":\""+place_id+"\",\r\n"
				+ "\"address\":\"70 Summer walk, USA\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}\r\n"
				+ "";		
	}
	
	public static String Jpath(String str) {
		JsonPath js=new JsonPath(str);
		return js.getString("place_id");
	}
	
	public static GoogleMapJson map() {
		
		GoogleMapJson p=new GoogleMapJson();
		p.setAccuracy(50);
		p.setAddress("jdh Fron asd, layout, cohen 09");
		p.setLanguage("French-IN");
		Location low=new Location();
		low.setLat(-38.383494);
		low.setLng(33.427362);
		p.setLocation(low);
		p.setName("dhjdfb reuuerr");
		p.setPhone_number("(+91) 111 700 3937");
		List<String> st=new ArrayList<String>();
		st.add("shoe park");
		st.add("shop");
		p.setTypes(st);
		p.setWebsite("http://google.com");
		return p;

	}
	
	public static RequestSpecification reqSpe() {
//	PrintStream log=new PrintStream(new FileInputStream(""));
	RequestSpecification req=new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com")
			.setContentType(ContentType.JSON)
			.addQueryParam("key", "qaclick123")
			.build();
	 return req;
	}
	
	public static ResponseSpecification resSpe() {
	ResponseSpecification res=new ResponseSpecBuilder()
			.expectContentType(ContentType.JSON)
			.expectStatusCode(200)
			.build();
	return res;
	}

}
