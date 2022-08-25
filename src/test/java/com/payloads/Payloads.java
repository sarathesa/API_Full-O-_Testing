package com.payloads;

import com.pojo.AddAddress_Input_Pojo;
import com.pojo.UpdateAddress_Input_Pojo;

public class Payloads {

	public AddAddress_Input_Pojo createAddress(String first_name, String last_name, String mobile, String apartment,
			String state, String city, String country, String zipcode, String address, String address_type) {

		AddAddress_Input_Pojo addAddressInputPojo = new AddAddress_Input_Pojo(first_name, last_name, mobile, apartment,
				state, city, country, zipcode, address, address_type);

		return addAddressInputPojo;
	}
	
	public UpdateAddress_Input_Pojo updateAddress(String address_id,String first_name, String last_name, String mobile, String apartment, String state, String city,String country,String zipcode,String address,String address_type) {
		
		UpdateAddress_Input_Pojo UpdateAddress_Input_Pojo=new UpdateAddress_Input_Pojo(address_id, first_name, last_name, mobile, apartment, state, city, country, zipcode, address, address_type);
		return UpdateAddress_Input_Pojo;
	}
	

}
