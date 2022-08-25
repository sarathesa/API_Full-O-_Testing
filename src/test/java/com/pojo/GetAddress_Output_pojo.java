package com.pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAddress_Output_pojo {
	
	public int status;
    public String message;
    public ArrayList<GetAddress_Data> data;
    
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<GetAddress_Data> getData() {
		return data;
	}
	public void setData(ArrayList<GetAddress_Data> data) {
		this.data = data;
	}
    
    
}
