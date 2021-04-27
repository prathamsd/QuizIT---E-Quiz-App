package com.codered.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class UserRegistration 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int r_id;
	private String UName;
	private String EmailId;
	private String Password;
	private String CPassword;
	private String Phone;
	
	
	
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRegistration(int r_id, String uName, String emailId, String password, String cPassword, String phone) {
		super();
		this.r_id = r_id;
		UName = uName;
		EmailId = emailId;
		Password = password;
		CPassword = cPassword;
		Phone = phone;
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getUName() {
		return UName;
	}
	public void setUName(String uName) {
		UName = uName;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getCPassword() {
		return CPassword;
	}
	public void setCPassword(String cPassword) {
		CPassword = cPassword;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	@Override
	public String toString() {
		return "UserRegistration [r_id=" + r_id + ", UName=" + UName + ", EmailId=" + EmailId + ", Password=" + Password
				+ ", CPassword=" + CPassword + ", Phone=" + Phone + "]";
	}
	
	
	
	
}
