package com.luis.navarro.bank.service;

import org.springframework.http.ResponseEntity;

import com.luis.navarro.bank.dto.CustomerDTO;
import com.luis.navarro.bank.dto.Response;

public interface CustomerService {

	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> save(CustomerDTO request);
	
	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> update(CustomerDTO request);
	
	/**
	 * @param documentId
	 * @return
	 */
	public ResponseEntity<Response> delete(String documentId);
	
	/**
	 * @param documentId
	 * @return
	 */
	public ResponseEntity<Response> findCustomerByDocumentId(String documentId);
	
	/**
	 * @return
	 */
	public ResponseEntity<Response> findAllCustomer();
}
