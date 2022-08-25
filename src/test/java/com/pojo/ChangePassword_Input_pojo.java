package com.pojo;

public class ChangePassword_Input_pojo {

	private String password;
	private String new_password;
	private String confirm_password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public ChangePassword_Input_pojo(String password, String new_password, String confirm_password) {
		super();
		this.password = password;
		this.new_password = new_password;
		this.confirm_password = confirm_password;
	}
	
	

}
