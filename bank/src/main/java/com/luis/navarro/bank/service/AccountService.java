package com.luis.navarro.bank.service;

import org.springframework.http.ResponseEntity;

import com.luis.navarro.bank.dto.AccountDTO;
import com.luis.navarro.bank.dto.Response;

public interface AccountService {

	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> save(AccountDTO request);
	
	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> update(AccountDTO request);
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public ResponseEntity<Response> delete(String accountNumber);
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public ResponseEntity<Response> findAccountByAccountNumber(String accountNumber);
	
	/**
	 * @return
	 */
	public ResponseEntity<Response> findAllAccount();
}
