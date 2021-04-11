package com.pg.warrior.payee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pg.warrior.payee.entity.Payee;
import com.pg.warrior.payee.repo.PayeeRepo;
import com.pg.orion.payee.dao.Bank;

@Service
public class PayeeService 
{

	@Autowired
	PayeeRepo repo;
	
	@Autowired
	RestTemplate template;
	
	public List<Payee> getPayee(int userId) 
	{
		return null;
	}

	public Payee addPayee(Payee payee) 
	{
		Payee createPayee = null;
		
		String bankCode = String.valueOf(payee.getPayeeAccountNo()).substring(3, 8);
		
		Bank bank = template.getForObject("http://localhost:9091/bank-service/getBank/get-bank/"+bankCode, Bank.class);
		
		if(bank != null && bank.getBankCode().equals(bankCode))
		{
			payee.setPayeeBankName(bank.getBankCode());
			createPayee = repo.save(payee);
		}
		
		return createPayee;
	}

	public String deletePayee(int payeeId) 
	{
		return null;
	}

	public Payee updatePayee(Payee payee) 
	{
		return null;
	}

}
