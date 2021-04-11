package com.pg.warrior.payee.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

import com.pg.orion.payee.dao.Bank;
import com.pg.warrior.payee.entity.Payee;
import com.pg.warrior.payee.repo.PayeeRepo;

import com.pg.warrior.payee.entity.Payee;
import com.pg.warrior.payee.repo.PayeeRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;



import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class PayeeServiceApplicationTests {

	@Autowired
	PayeeService service;

	@MockBean
	PayeeRepo repo;

	@MockBean
	RestTemplate template;


	@Test
	void addPayee() {
		Payee payee = new Payee();
		payee.setPayeeAccountNo(1234567890);
		payee.setPayeeBankName("HDFC");
		payee.setPayeeId(1);
		payee.setUserId(1);
		payee.setPayeeName("Rahul");

		String bankCode = String.valueOf(payee.getPayeeAccountNo()).substring(4, 8);

		Bank bank = new Bank();
		bank.setBankId(1);
		bank.setBankName("HDFC");
		bank.setBankCode("45678");

		when(template.getForObject("http://localhost:9091/bank-service/getBank/get-bank/" + bankCode, Bank.class)).thenReturn(bank);

		if (bank.getBankCode().equals(bankCode)) {
			when(repo.save(payee)).thenReturn(payee);
		}

		assertEquals(repo.save(payee), service.addPayee(payee));

	}

	@Test
	void findAllPayees() {
		Pageable pageable = PageRequest.of(0,20);
		Page<Payee> payeeList = new PageImpl<>(Stream.of(new Payee(1,"abc",123456789011l,"Vishwajeet Verma",1)).collect(Collectors.toList()));
		Mockito.when(repo.findByUserId(1,pageable)).thenReturn(payeeList);
		List<Payee> payees = service.getPayeeList(1,0,20);
		assertEquals(	1,payees.size());
	}
}
