package com.stepdefinition;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.ChangePassword_Input_pojo;
import com.pojo.ChangePassword_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class ChangePasswordStep extends BaseClass {
	static Response response;

	@Given("User add response body {string},{string}, {string}")
	public void userAddResponseBody(String password, String newPassword, String confirmPassword) {

		ChangePassword_Input_pojo changePasswordInputpojo = new com.pojo.ChangePassword_Input_pojo("Admin@12345",
				"Admin@123456", "Admin@123456");
		addBody(changePasswordInputpojo);

	}

	@Given("User send {string} request for with changePassord address endpoints")
	public void userSendRequestForWithChangePassordAddressEndpoints(String string) {
	 response = requestType(string, Endpoints.CHANGEPASSWORD);
	}

	@Then("User verify successfull response body with changePassord message {string}")
	public void userVerifySuccessfullResponseBodyWithChangePassordMessage(String string) {
		String bodyAsPrettyString = getBodyAsPrettyString(response);
		System.out.println(bodyAsPrettyString);
		ChangePassword_Output_pojo as = response.as(ChangePassword_Output_pojo.class);
		String message = as.getMessage();
		System.out.println(message);
	}

}
