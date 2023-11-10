package JsonParser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TestJson.JsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.path.json.JsonPath;

public class JsonParsingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		JsonPath js=new JsonPath(JsonReader.posts());
		int post=js.getInt("posts.size()");
//		System.out.println(post);
		
		JsonPath js2=new JsonPath(JsonReader.comments());
		int comments=js2.getInt("comments.size()");
		
		JsonPath js3=new JsonPath(JsonReader.todos());
		int todos=js3.getInt("todos.size()");
		
		JsonPath js4=new JsonPath(JsonReader.albums());
		int albums=js4.getInt("albums.size()");
		
//		JavascriptExecutor js1=(JavascriptExecutor)driver;
//		js1.executeScript("fetch('https://jsonplaceholder.typicode.com/todos')\r\n"
//				+ "      .then(response => response.json())\r\n"
//				+ "      .then(json => console.log(json))");
		
		
		JsonPath js1=new JsonPath(JsonReader.users());
		int user_id=js1.getInt("users[0].id");
		String Company_Name=js1.getString("users[0].company.name");
		String Person_Name=js1.getString("users[0].name");
		String Name=js1.getString("users[0].username");
		String Email=js1.getString("users[0].email");
		String street=js1.getString("users[0].address.street");
		String suite=js1.getString("users[0].address.suite");
		String city=js1.getString("users[0].address.city");
		String zipcode=js1.getString("users[0].address.zipcode");
		String Latitude=js1.getString("users[0].address.geo.lat");
		String Longititude=js1.getString("users[0].address.geo.lng");
		String Phone=js1.getString("users[0].phone");
		String website=js1.getString("users[0].website");
		String catchP=js1.getString("users[0].company.catchPhrase");
		String bs=js1.getString("users[0].company.bs");
		
		System.out.println("User_Id :"+user_id+" Company_Name :"+Company_Name+" Person_Name:"+Person_Name);
		
		System.out.println("Details: Name:"+Person_Name+"  Username:"+Name+"    email:"+Email+"  street:"+street+"  suite:"+suite);
		System.out.println("  city:"+city+"  zip code:"+zipcode+"  latitude:"+Latitude+"  Longititude:"+Longititude);
		System.out.println("  phone:"+Phone+ "   website:"+website+"  catchPhrase:"+catchP+"  bs:"+bs);
		
		System.out.println(" post: "+post+" comments: "+comments+" todos: "+todos+" albums: "+albums);
		
		
	}

}
