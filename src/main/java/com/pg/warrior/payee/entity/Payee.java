package com.pg.warrior.payee.entity;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "Payee")
public class Payee {
	
	private int payeeId;
	private String payeeName;
	private long payeeAccountNo;
	private String payeeBankName;
	private int userId;

}
