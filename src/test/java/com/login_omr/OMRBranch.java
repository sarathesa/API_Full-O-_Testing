package com.login_omr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.endpoints.Endpoints;
import com.pojo.AddAddress_Input_Pojo;
import com.pojo.Address_Output_Pojo;
import com.pojo.Data_Login;
import com.pojo.DeleteAddress_Output_pojo;
import com.pojo.Delete_Input_pojo;
import com.pojo.GetAddress_Output_pojo;
import com.pojo.Login_Output_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;
import com.pojo.UpdateAdress_Output_Pojo;
import com.pojo.Upload_Output_pojo;
import com.pojo.GetAddress_Data;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class OMRBranch extends BaseClass {
	static String logtoken;
	int address_id;

	@Test(priority = 1)
	public void getUser() throws IOException, ParseException {

		System.out.println("Get User");

		addHeader("Content-Type", "application/json");

		basicAuthentication(getPropertyValue("userName"), getPropertyValue("password"));

		Response response = requestType("POST", Endpoints.LOGIN);

		int statusCode = getStatusCode(response);
		System.out.println(statusCode);

		String bodyAsPrettyString = getBodyAsPrettyString(response);

		Login_Output_Pojo loginOutputPojo = response.as(Login_Output_Pojo.class);

		String firstname = loginOutputPojo.getData().getFirst_name();
		System.out.println(firstname);
		logtoken = loginOutputPojo.getData().getLogtoken();
		Assert.assertEquals(firstname, "sarath", "Verified first name");

		// System.out.println(bodyAsPrettyString);
		//
		// JSONParser jsonparser=new JSONParser();
		//
		// Object parse = jsonparser.parse(bodyAsPrettyString);
		//
		// JSONObject jsonObject=(JSONObject)parse;
		//
		// Object objectData = jsonObject.get("data");
		//
		// JSONObject objLastName=(JSONObject)objectData;
		//
		// Object objectLastName = objLastName.get("last_name");
		//
		// String lastname=(String)objectLastName;
		// System.out.println(lastname);

	}

	@Test(priority = 2)
	public void createAddress() {

		System.out.println("Create Address");

		// add headers
		List<Header> header = new ArrayList<>();
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer " + logtoken);
		Header header3 = new Header("accept", "application/json");

		header.add(header1);
		header.add(header2);
		header.add(header3);
		Headers headers = new Headers(header);
		addHeaders(headers);

		AddAddress_Input_Pojo addAddressInputPojo = new AddAddress_Input_Pojo("sarath", "esa", "1234567890",
				"apartment", "33", "3378", "101", "600008", "egmore", "Home");
		//

		addBody(addAddressInputPojo);

		Response response = requestType("POST", Endpoints.ADDADRESS);
		System.out.println(getStatusCode(response));

		Address_Output_Pojo addressOuputPojo = response.as(Address_Output_Pojo.class);

		address_id = addressOuputPojo.getAddress_id();
		String message = addressOuputPojo.getMessage();

		System.out.println(address_id);
		Assert.assertEquals(message, "Address added successfully", "Verified address update");
	}

	@Test(priority = 3)
	public void updateAddress() {
		System.out.println("Update Address");

		List<Header> header = new ArrayList<>();
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer " + logtoken);

		header.add(header1);
		header.add(header2);
		Headers headers = new Headers(header);
		addHeaders(headers);

		UpdateAddress_Input_Pojo updateInputAddressPojo = new UpdateAddress_Input_Pojo(String.valueOf(address_id),
				"sarathnew", "kumar", "1234567890", "apartment", "33", "3378", "101", "600008", "chetpet", "office");
		addBody(updateInputAddressPojo);

		Response response = requestType("PUT", Endpoints.UPDATEADDRESS);
		System.out.println(getStatusCode(response));

		UpdateAdress_Output_Pojo updateAdressOutputPojo = response.as(UpdateAdress_Output_Pojo.class);

		String message = updateAdressOutputPojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address updated successfully", "Verified address update");

	}

	@Test(priority = 4)
	public void getAdress() {
		System.out.println("Get Address");

		List<Header> header = new ArrayList<>();
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer " + logtoken);

		header.add(header1);
		header.add(header2);
		Headers headers = new Headers(header);
		addHeaders(headers);

		Response response = requestType("GET", Endpoints.GETADDRES);
		System.out.println(getStatusCode(response));

		GetAddress_Output_pojo getAddressOutputpojo = response.as(GetAddress_Output_pojo.class);
//		int status = getAddressOutputpojo.getStatus();
		String message = getAddressOutputpojo.getMessage();
		System.out.println(message);
		
		Data_Login Data_Login=new Data_Login();
		int id = Data_Login.getId();
		System.out.println(id);
		
		Assert.assertEquals(message, "OK", "Verify message OK");

	}

	@Test(priority = 5)
	public void deleteAddress() {
		System.out.println("Delete Address");

		List<Header> header = new ArrayList<>();
		Header header1 = new Header("Content-Type", "application/json");
		Header header2 = new Header("Authorization", "Bearer " + logtoken);

		header.add(header1);
		header.add(header2);
		Headers headers = new Headers(header);
		addHeaders(headers);

		Delete_Input_pojo deleteInputpojo = new Delete_Input_pojo(String.valueOf(address_id));
		addBody(deleteInputpojo);

		Response response = requestType("DELETE", Endpoints.DELETADDRESS);
		System.out.println(getStatusCode(response));

		DeleteAddress_Output_pojo deleteAddressOutputpojo = response.as(DeleteAddress_Output_pojo.class);
		String message = deleteAddressOutputpojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message, "Address deleted successfully", "Verify Address deleted");
	}
	@Test(priority = 6)
	public void uploadProfilePic() {
		List<Header> header = new ArrayList<>();
		Header header1 = new Header("Content-Type", "multipart/form-data");
		Header header2 = new Header("Authorization", "Bearer " + logtoken);
		header.add(header1);
		header.add(header2);
		Headers headers = new Headers(header);
		addHeaders(headers);
		
		//body format for upload
		formData("C:\\Users\\sarath esa\\Downloads\\download.jpg");
		
		Response response = requestType("POST", Endpoints.UPLOADPROFILEPIC);
		System.out.println(getStatusCode(response));
		
//		Upload_Output_pojo as = response.as(Upload_Output_pojo.class);
//		System.out.println(as.getMessage());
		
		
		

		
		
	}
	

}
