package com.chenga.entites;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class BusSeats {

	@Id
	private Integer busnumber;
	
	private String busname;
	
	
	private byte seat1;
	
	private byte seat2;
	
	private byte seat3;
	
	private byte seat4;
	
	private byte seat5;
	
	private byte seat6;
	
	private byte seat7;
	
	private byte seat8;
	
	private byte seat9;
	
	private byte seat10;

	
	
	public Integer getBusnumber() {
		return busnumber;
	}

	public void setBusnumber(Integer busnumber) {
		this.busnumber = busnumber;
	}

	public void setBusname(String busname) {
		this.busname = busname;
	}
	
	public String getBusname() {
		return busname;
	}
	
	public byte getSeat1() {
		return seat1;
	}

	public void setSeat1(byte seat1) {
		this.seat1 = seat1;
	}

	public byte getSeat2() {
		return seat2;
	}

	public void setSeat2(byte seat2) {
		this.seat2 = seat2;
	}

	public byte getSeat3() {
		return seat3;
	}

	public void setSeat3(byte seat3) {
		this.seat3 = seat3;
	}

	public byte getSeat4() {
		return seat4;
	}

	public void setSeat4(byte seat4) {
		this.seat4 = seat4;
	}

	public byte getSeat5() {
		return seat5;
	}

	public void setSeat5(byte seat5) {
		this.seat5 = seat5;
	}

	public byte getSeat6() {
		return seat6;
	}

	public void setSeat6(byte seat6) {
		this.seat6 = seat6;
	}

	public byte getSeat7() {
		return seat7;
	}

	public void setSeat7(byte seat7) {
		this.seat7 = seat7;
	}

	public byte getSeat8() {
		return seat8;
	}

	public void setSeat8(byte seat8) {
		this.seat8 = seat8;
	}

	public byte getSeat9() {
		return seat9;
	}

	public void setSeat9(byte seat9) {
		this.seat9 = seat9;
	}

	public byte getSeat10() {
		return seat10;
	}

	public void setSeat10(byte seat10) {
		this.seat10 = seat10;
	}
	
	public BusSeats() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BusSeats [id=" + ", busnumber=" + busnumber + ", busname "+busname+", seat1=" + seat1 + ", seat2=" + seat2 + ", seat3="
				+ seat3 + ", seat4=" + seat4 + ", seat5=" + seat5 + ", seat6=" + seat6 + ", seat7=" + seat7 + ", seat8="
				+ seat8 + ", seat9=" + seat9 + ", seat10=" + seat10 + "]";
	}
	
	
	
}
