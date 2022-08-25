package com.pojo;

public class AddAddress_Input_Pojo {

	private String first_name;
	private String last_name;
	private String mobile;
	private String apartment;
	private String state;
	private String city;
	private String country;
	private String zipcode;
	private String address;
	private String address_type;
	

	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getApartment() {
		return apartment;
	}


	public void setApartment(String apartment) {
		this.apartment = apartment;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAddress_type() {
		return address_type;
	}


	public void setAddress_type(String address_type) {
		this.address_type = address_type;
	}


	public AddAddress_Input_Pojo(String first_name, String last_name, String mobile, String apartment, String state,
			String city, String country, String zipcode, String address, String address_type) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.apartment = apartment;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.address = address;
		this.address_type = address_type;
	}

}
