package com.pg.warrior.payee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pg.warrior.payee.entity.Payee;
import com.pg.warrior.payee.service.PayeeService;

@RestController
public class PayeeController 
{
	@Autowired
	private PayeeService payeeService;

	@GetMapping("/payee/{userId}")
	public List<Payee> getpayee(@PathVariable("userId") int userId) 
	{
		return payeeService.getPayee(userId);
	}
	
	@PostMapping("/payee")
	public Payee addPayee(@RequestBody Payee payee) 
	{
		return payeeService.addPayee(payee);
	}
	
	@DeleteMapping("/payee/{payeeId}")
	public String deletePayee(@PathVariable("payeeId") int payeeId) 
	{
		return payeeService.deletePayee(payeeId);
	}
	
	@PutMapping("/payee")
	public Payee updatePayee(@RequestBody Payee payee) 
	{
		return payeeService.updatePayee(payee);
	}

}
