package com.luis.navarro.bank.service;

import org.springframework.http.ResponseEntity;

import com.luis.navarro.bank.dto.PersonDTO;
import com.luis.navarro.bank.dto.Response;

public interface PersonService {

	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> save(PersonDTO request);
	
	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> update(PersonDTO request);
	
	/**
	 * @param documentId
	 * @return
	 */
	public ResponseEntity<Response> delete(String documentId);
	
	/**
	 * @param documentId
	 * @return
	 */
	public ResponseEntity<Response> findPersonByDocumentId(String documentId);
	
	/**
	 * @return
	 */
	public ResponseEntity<Response> findAllPerson();
}
