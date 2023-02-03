package com.luis.navarro.bank.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.navarro.bank.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {
	
	public List<Customer> findAll();

	public Optional<Customer> findByDocumentId(String documentId);
}
