package com.pg.warrior.payee.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Payee")
public class Payee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int payeeId;
	private String payeeName;
	private long payeeAccountNo;
	private String payeeBankName;
	private int userId;
	public int getPayeeId() {
		return payeeId;
	}
	public void setPayeeId(int payeeId) {
		this.payeeId = payeeId;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public long getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(long payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	public String getPayeeBankName() {
		return payeeBankName;
	}
	public void setPayeeBankName(String object) {
		this.payeeBankName = object;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

}
