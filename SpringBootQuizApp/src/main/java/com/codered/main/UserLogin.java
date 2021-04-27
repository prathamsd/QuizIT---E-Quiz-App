package com.codered.main;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class UserLogin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int login_id;
	private String UEmail;
	private String Password;
	
	public String getUEmail() {
		return UEmail;
	}
	public void setUEmail(String uEmail) {
		UEmail = uEmail;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "UserLogin [UEmail=" + UEmail + ", Password=" + Password + "]";
	}
	
}
