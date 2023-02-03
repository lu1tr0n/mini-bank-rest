package com.luis.navarro.bank.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luis.navarro.bank.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Serializable> {
	
	public List<Person> findAll();

	public Optional<Person> findByDocumentId(String documentId);
}
