package com.chenga;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Hello {
	
	private UUID uuid=UUID.randomUUID();
	
	private String msg; 
	
	private String name;
	
	private Timestamp createAt;
	
	private BigDecimal balance;
	
	
	
	public Hello() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Hello(String msg,String name,Timestamp time,BigDecimal balance) {
		super();
		this.msg = msg; this.name=name;  this.createAt=time;  this.balance=balance;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Timestamp getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}



	public UUID getUuid() {
		return uuid;
	}



	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

}
