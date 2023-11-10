package AddPlace;

import io.restassured.path.json.JsonPath;

public class JsonParsing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonPath js=new JsonPath(AddPlaceJson.DemJson());
		
		String str1=js.getString("dashboard.website");
		System.out.println(str1);
		
		int pAmount=js.getInt("dashboard.purchaseAmount");
		System.out.println(pAmount);
		
		
		for(int i=0;i<3;i++) {
		String title=js.getString("courses["+i+"].title");
		System.out.println(title);
		}
		
		
		
		
//		String st1=js.getString("dashboard.purchaseAmount");
//		System.out.println(st1);
//		
//		int count=js.getInt("courses.size()");
//		System.out.println(count);
//		
//		for(int i=0;i<count;i++) {
//			String name=js.get("courses["+i+"].title");
//			System.out.println(name);
//		}
	}

}
