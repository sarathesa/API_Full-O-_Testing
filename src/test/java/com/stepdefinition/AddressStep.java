package com.stepdefinition;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.payloads.Payloads;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.Address_Output_Pojo;
import com.pojo.Data_Login;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.Delete_Input_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAdress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AddressStep extends BaseClass {
	static Response response;
	//static String logToken;
	//static int address_id;
	 int statusCode;
	// Create Address
	@Given("User add headers")
	public void userAddHeaders() {
		List<Header> header = new ArrayList<>();
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization","Bearer "+LoginStep.logToken);
		Header header3 = new Header("accept", "application/json");
		header.add(header1);
		header.add(header2);
		header.add(header3);
		Headers headers = new Headers(header);
		addHeaders(headers);

	}

	@Given("User add response body {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userAddResponseBody(String first_name, String last_name, String mobile, String apartment, String state,
			String city, String country, String zipcode, String address, String address_type) {

		Payloads payload = new Payloads();
		AddAddress_Input_Pojo createAddress = payload.createAddress(first_name, last_name, mobile, apartment, state,
				city, country, zipcode, address, address_type);

		addBody(createAddress);
	}

	@Given("User send {string} request for with create address endpoints")
	public void userSendRequestForWithCreateAddressEndpoints(String POST) {
		POST = "POST";
		response = requestType(POST, Endpoints.ADDADRESS);

	}

	@Given("User verify status code {int}")
	public void userVerifyStatusCode(int status) {
		status = 200;
		statusCode = getStatusCode(response);
		System.out.println(statusCode);

	}

	@Given("User verify successfull response body with Create message {string}")
	public void userVerifySuccessfullResponseBodyWithCreateMessage(String createExp) {
		Address_Output_Pojo addressOuputPojo = response.as(Address_Output_Pojo.class);
		String message = addressOuputPojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, createExp, "Verify Create address success");

	}

	@Then("User get the Address id and saved")
	public void userGetTheAddressIdAndSaved() {
		Address_Output_Pojo	addressOuputPojo = response.as(Address_Output_Pojo.class);
		LoginStep.address_id = addressOuputPojo.getAddress_id();
		System.out.println(LoginStep.address_id);
	}

	// Update Address
	@Given("User update response body {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
	public void userUpdateResponseBody(String Addressid, String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {

		Payloads payloads = new Payloads();
		UpdateAddress_Input_Pojo updateAddress = payloads.updateAddress(String.valueOf(LoginStep.address_id), first_name,
				last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		addBody(updateAddress);

	}

	@Given("User send {string} request for with Update address endpoints")
	public void userSendRequestForWithUpdateAddressEndpoints(String PUT) {
		PUT = "PUT";
		response = requestType(PUT, Endpoints.UPDATEADDRESS);

	}

	@Given("User verify Update status code {int}")
	public void userVerifyUpdateStatusCode(int status) {
		status = 200;
		System.out.println(getStatusCode(response));
	}

	@Then("User verify successfull response body with Update message {string}")
	public void userVerifySuccessfullResponseBodyWithUpdateMessage(String expUpdate) {
		String bodyAsPrettyString = getBodyAsPrettyString(response);
		UpdateAdress_Output_Pojo updateAdressOutputPojo = response.as(UpdateAdress_Output_Pojo.class);
		String message1 = updateAdressOutputPojo.getMessage();
		System.out.println(message1);
		Assert.assertEquals( message1, expUpdate,"Verify Update address success");

	}

	// GET address
	@Given("User send {string} request for with Get address endpoints")
	public void userSendRequestForWithGetAddressEndpoints(String GET) {
		GET = "GET";
		 response = requestType(GET, Endpoints.GETADDRES);
	}

	@Then("User verify successfull response body with message {string}")
	public void userVerifySuccessfullResponseBodyWithMessage(String OK) {
		GetAddress_Output_pojo getAddressOutputpojo = response.as(GetAddress_Output_pojo.class);
		String message = getAddressOutputpojo.getMessage();
		System.out.println(message);
		Data_Login Data_Login = new Data_Login();
		int id = Data_Login.getId();
		System.out.println(id);

		Assert.assertEquals(message, OK, "Verify message OK");

	}

	//DELETE
	@Given("User send payload")
	public void userSendPayload() {
	
		Delete_Input_pojo deleteInputpojo = new Delete_Input_pojo(String.valueOf(LoginStep.address_id));
		System.out.println(deleteInputpojo);
		addBody(deleteInputpojo);

	}

	@Given("User send {string} request for with Delete address endpoints")
	public void userSendRequestForWithDeleteAddressEndpoints(String string) {
		 response = requestType("DELETE", Endpoints.DELETADDRESS);

	}
	@Given("User verify Delete status code {int}")
	public void userVerifyDeleteStatusCode(int status) {
		status = 200;
		statusCode = getStatusCode(response);
		System.out.println(statusCode);
	}

@Then("User verify successfull response body with Delete message {string}")
public void userVerifySuccessfullResponseBodyWithDeleteMessage(String string) {
	DeleteAddress_Output_pojo deleteAddressOutputpojo = response.as(DeleteAddress_Output_pojo.class);
	String message = deleteAddressOutputpojo.getMessage();
	System.out.println(message);
	Assert.assertEquals(message, "Address deleted successfully", "Verify Address deleted");
}

}
