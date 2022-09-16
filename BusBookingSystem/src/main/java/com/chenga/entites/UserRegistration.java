package com.chenga.entites;


import java.time.LocalDateTime;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Registration")
public class UserRegistration {

	@Id
	@NotNull
	private String regId;
	
	
	@NotNull(message="name can not be blank ")
	private String name;
	
	@NotNull(message="email can not be blank")
	private String email;
	
	@NotNull(message="age can not be blank")
	@Size(min = 15, max = 80, message="age between 15 to 80")
	private int age;
	
	@NotNull(message ="gender can not be blank")
	private String gender;
	
	
	@NotNull(message="Date Of Birth can not be blank")
	private String dob;
	
	@CreationTimestamp
	private LocalDateTime regDateTime;
	
	@NotNull(message="Mobile can not be blank ")
	private String mobile;
	
	@NotNull(message="password can not be blank ")
	@Size(max = 20, min = 8, message="password between 8 to 20 characters")
	private String password;
	
	private boolean loginStatus;
	
	@OneToOne(targetEntity = Wallet.class, cascade = CascadeType.ALL)
	private Wallet wallet;

	
	
	public UserRegistration() {
		// TODO Auto-generated constructor stub
	}



	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus = loginStatus;
	}
	

	
	public String getRegId() {
		return regId;
	}

	public boolean getLoginstatus() {
		return loginStatus;

	}

	public void setRegId(String regId) {
		this.regId = regId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getDob() {
		return dob;
	}



	public void setDob(String dob) {
		this.dob = dob;
	}



	public LocalDateTime getRegDateTime() {
		return regDateTime;
	}



	public void setRegDateTime(LocalDateTime regDateTime) {
		this.regDateTime = regDateTime;
	}



	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Wallet getWallet() {
		return wallet;
	}



	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}



	public UserRegistration(String regId, String name, String email, int age, String gender, String dob,
			LocalDateTime regDateTime, String mobile, String password, Wallet wallet) {
		super();
		this.regId = regId;
		this.name = name;
		this.email = email;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.regDateTime = regDateTime;
		this.mobile = mobile;
		this.password = password;
		this.wallet = wallet;
	}



	@Override
	public String toString() {
		return "UserRegistration [regId=" + regId + ", name=" + name + ", email=" + email + ", age=" + age + ", gender="
				+ gender + ", dob=" + dob + ", regDateTime=" + regDateTime + ", mobile=" + mobile + ", password="
				+ password + ", wallet=" + wallet + "]";
	}
	
	
	
	
	




		
}
