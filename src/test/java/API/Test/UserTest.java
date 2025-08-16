package API.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import API.Endpoind.UserEndpoints;
import API.Payloads.UserPojo;
import io.restassured.response.Response;

public class UserTest {
	
	Faker fake;
	UserPojo userpayload;
	
	@BeforeClass
	public void setup()
	{
		fake = new Faker();
		userpayload = new UserPojo();
		
		userpayload.setId(fake.idNumber().hashCode());
		userpayload.setUsername(fake.name().fullName());
		userpayload.setFirstname(fake.name().firstName());
		userpayload.setLastname(fake.name().lastName());
		userpayload.setPassword(fake.internet().password(5, 10));
		userpayload.setEmail(fake.internet().emailAddress());
		userpayload.setPhone(fake.phoneNumber().cellPhone());
	}
	
	
	@Test(priority=1)
	public void TestCreateUser()
	{
		List<UserPojo> userlist = new ArrayList<>();
		userlist.add(userpayload);
		Response res = UserEndpoints.CreateUser(userlist);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=2)
	public void GetUserByName()
	{
		Response response = UserEndpoints.GetUser(this.userpayload.getUsername());
		response.then().log().all();
		response.then().log().headers();
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	

}
