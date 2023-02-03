package com.luis.navarro.bank.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.luis.navarro.bank.entity.Account;

import jakarta.transaction.Transactional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Serializable> {
	
	public List<Account> findAll();

	public Optional<Account> findByAccountNumber(String accountNumber);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM Account a WHERE a.accountNumber=?1")
	public void deleteByAccountNumber(String accountNumber);
}
