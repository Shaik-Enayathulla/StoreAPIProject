package API.Endpoind;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import API.Payloads.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {
	
	public static Response CreateUser(List<UserPojo> payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(User_routes.Post_url);
		return response;
	}
	
	public static Response GetUser(String Username)
	{
		Response response = given()
				.pathParam("username",Username)
			.when()
				.get(User_routes.Get_url);
		return response;
	}
	
	public static Response UpdateUser(String Username, List<UserPojo> payload)
	{
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", Username)
				.body(payload)
			.when()
				.put(User_routes.Update_url);
		return response;
	}
	
	public static Response DeleteUser(String Username)
	{
		Response response = given()
				.pathParam("username",Username)
			.when()
				.delete(User_routes.Delete_url);
		return response;
	}
}
