package com.stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class LoginStep extends BaseClass {
	static Response response;
	public static String logToken;
	public static int address_id;
	int statusCode;

	@Given("User add header")
	public void userAddHeader() {
		System.out.println("User Login");
		addHeader("Content-Type", "application/json");
	}

	@Given("User Add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() throws IOException {
		basicAuthentication(getPropertyValue("userName"), getPropertyValue("password"));

	}

	@Given("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String POSTLogin) {
		POSTLogin = "POST";
		response = requestType(POSTLogin, Endpoints.LOGIN);
	}

	@Then("User verify the status code {int}")
	public void userVerifyTheStatusCode(int status) {
		status = 200;
		statusCode = getStatusCode(response);
		System.out.println(statusCode);
	}

	@Then("User verify successfull response body with message {string} and get the Logtoken saved")
	public static void userVerifySuccessfullResponseBodyWithMessageAndGetTheLogtokenSaved(String login) {
		Login_Output_Pojo loginOutputPojo = response.as(Login_Output_Pojo.class);
		login = "Login successfully";
		logToken = loginOutputPojo.getData().getLogtoken();
		String message = loginOutputPojo.getMessage();
		System.out.println(message);
		System.out.println(logToken);
		Assert.assertEquals(message, login, "Verified first name");

	}

}
