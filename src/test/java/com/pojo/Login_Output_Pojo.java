package com.pojo;

public class Login_Output_Pojo {

	private int status;
    private String message;
    private Data_Login data;
    private String refer_msg;
    private int cart_count;
    private String role;
    
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
	public Data_Login getData() {
		return data;
	}
	public void setData(Data_Login data) {
		this.data = data;
	}
	public String getRefer_msg() {
		return refer_msg;
	}
	public void setRefer_msg(String refer_msg) {
		this.refer_msg = refer_msg;
	}
	public int getCart_count() {
		return cart_count;
	}
	public void setCart_count(int cart_count) {
		this.cart_count = cart_count;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
    
	
}
