package API.Endpoind;

public class User_routes {
	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String Post_url = base_url+"/user/createWithList";
	public static String Get_url = base_url+"/user/{username}";
	public static String Update_url = base_url+"/user/{username}";
	public static String Delete_url = base_url+"/user/{username}";

}
