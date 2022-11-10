/**
 * Twilio take home test
 * Creado por Leon Felipe Acero
 * 
**/
package FunctionalTesting;

//import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
//import io.restassured.matcher.*;
import io.restassured.response.Response;

public class GetAuto {
	
	public static Response response;
	public static String jsonAsString;
	@Test
	public void getAuto() {
				
		RestAssured.given().
					when().
						get().
					then().assertThat().log().all().statusCode(200);
	}
	//Probar semejanza en el path data.id
	@Test
	public void checkId()
	{     		
	    		Integer userIdString = 
	    		RestAssured.given().
	    		        contentType("application/json").
	    		when().
	    		        get().
	    		then().
	    		        statusCode(200).
	    		extract().
	    		        path("data.id");	
	    		
	    		assertEquals(userIdString, 2, "Id test failed"); 
	}
	//probar semejanza en el path data.email
	@Test
	public void checkEmail()
	{     		
	    		String userEmail = 
	    		RestAssured.given().
	    		        contentType("application/json").
	    		when().
	    		        get().
	    		then().
	    		        statusCode(200).
	    		extract().
	    		        path("data.email");	
	    		
	    		assertEquals(userEmail, "janet.weaver@reqres.in", "Email test failed"); 
	}
	//probar coincidencia del primer nombre
	@Test
	public void checkfirstName()
	{     		
	    		String firstNameString = 
	    		RestAssured.given().
	    		        contentType("application/json").
	    		when().
	    		        get().
	    		then().
	    		        statusCode(200).
	    		extract().
	    		        path("data.first_name");	
	    		
	    		assertEquals(firstNameString, "Janet", "Name mismatch"); 
	}
	//probar semejanza de apellido
	@Test
	public void checkLastName()
	{     		
	    		String userLastNameString = 
	    		RestAssured.given().
	    		        contentType("application/json").
	    		when().
	    		        get().
	    		then().
	    		        statusCode(200).
	    		extract().
	    		        path("data.last_name");	
	    		
	    		assertEquals(userLastNameString, "Weaver", "last name mismatch"); 
	}
	//probar url de avatar
	@Test
	public void checkAvatar()
	{     		
	    		String userAvatarString = 
	    		RestAssured.given().
	    		        contentType("application/json").
	    		when().
	    		        get().
	    		then().
	    		        statusCode(200).
	    		extract().
	    		        path("data.avatar");	
	    		
	    		assertEquals(userAvatarString, "https://reqres.in/img/faces/2-image.jpg", "Invalid avatar"); 
	}
	//Setup inicial
	@BeforeTest
	public void setUp() {
		RestAssured.baseURI="https://reqres.in";
		RestAssured.basePath ="/api/users/2";
	}
	@BeforeClass
    public static void callRidesAPI()
    { 
        response = RestAssured.when().
        							get().
        						then().contentType(ContentType.JSON).  
        						extract().response(); 
        jsonAsString = response.asString();
    }
}
