package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {

	static RequestSpecification reqspec;
	 Response response;

	public static String getPropertyValue(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\Config\\config.properties");
		properties.load(file);
		String value = (String) properties.get(key);
		return value;

	}
	public void formData(String imagePath) {
		reqspec = reqspec.multiPart("profile_picture", new File(imagePath));

	}
	
	public void addBody(Object body) {
		reqspec = reqspec.body(body);
	}
	public void addBody(String body) {
		reqspec = reqspec.body(body);
	}
	
	public void basicAuthentication(String userName, String Password) {
		reqspec.auth().preemptive().basic(userName, Password);
	}

	public void addHeader(String key, String Value) {
		reqspec = RestAssured.given().header(key,Value);
	}
	
	public void addHeaders(Headers headers) {
		reqspec = RestAssured.given().headers(headers);

	}

	public void qureparam(String key, String Value) {
		reqspec = reqspec.queryParam(key, Value);
	}

	public void pathParam(String key, String Value) {
		reqspec = reqspec.pathParam(key, Value);
	}

	public Response requestType(String reqType, String endPoint) {
		switch (reqType) {
		case "GET":
			response = reqspec.log().all().get(endPoint);
			break;
		case "POST":
			response = reqspec.log().all().post(endPoint);
			break;
		case "PUT":
			response = reqspec.log().all().put(endPoint);
			break;
		case "DELETE":
			response = reqspec.log().all().delete(endPoint);
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public ResponseBody getBody(Response response) {
		ResponseBody body = response.getBody();
		return body;

	}

	public String getBodyAsString(Response response) {
		String asString = getBody(response).asString();
		return asString;
	}

	public String  getBodyAsPrettyString(Response response) {
	String asString = getBody(response).asPrettyString();
	return asString;

	}
	

}
