package com.pg.warrior.payee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pg.warrior.bank.service.entity.Bank;
import com.pg.warrior.bank.service.service.BankService;

@RestController
@RequestMapping("/payee")
public class PayeeController 
{
	@Autowired
	private PayeeService payeeService;

	@PostMapping("/save-bank")
	public List<Payee> payee(@RequestBody List<Payee> bank) {
		return payeeService.saveBank(bank);
	}
	
	@GetMapping("/get-bank/{bankCode}")
	public Bank getBank(@PathVariable("bankCode") String bankCode) {
		return bankService.getBankDetails(bankCode);
	}

}
