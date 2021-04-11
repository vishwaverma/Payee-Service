package com.pg.warrior.payee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pg.warrior.payee.entity.Payee;

public interface PayeeRepo extends JpaRepository<Payee, Integer>{

}
