package com.pg.warrior.payee.controller;

import java.util.List;


import com.pg.warrior.payee.entity.Payee;
import com.pg.warrior.payee.service.PayeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class PayeeController 
{
	@Autowired
	private PayeeService payeeService;


	
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

	@Autowired
	PayeeService service;

	@GetMapping("/payee")
	public ResponseEntity<List<Payee>> getAllPayees(
			@RequestParam Integer userId,
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize)
	{
		List<Payee> list = payeeService.getPayeeList(userId,pageNo, pageSize);

		return new ResponseEntity<List<Payee>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
