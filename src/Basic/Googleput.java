package Basic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import AddPJ.Location;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Googleput {
	
	public static GoogleMap GoJson() {
		GoogleMap m=new GoogleMap();
		Location la=new Location();
		la.setLat(-38.383494);
		la.setLng(33.427362);
		m.setLocation(la);
		m.setAccuracy(50);
		m.setAddress("36 sid layout USA");
		m.setLanguage("English");
		m.setName("Anwar T Sharma");
		m.setPhone_number("(+91) 983 893 0000");
		List<String> li=new ArrayList<String>();
		li.add("shoe park");
		li.add("shop");
		m.setTypes(li);
		m.setWebsite("http://google.com");
		
		return m;
	}	
	
	public static RequestSpecification request() throws FileNotFoundException {
		PrintStream log=new PrintStream(new FileOutputStream(""));
		RequestSpecification re=new RequestSpecBuilder()
		.setBaseUri("https://rahulshettyacademy.com")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		.addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		return re;
	}
	
	public static ResponseSpecification responce() {
		ResponseSpecification rp=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return rp;
	}

}
