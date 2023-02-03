package com.luis.navarro.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luis.navarro.bank.dto.AccountDTO;
import com.luis.navarro.bank.dto.Response;
import com.luis.navarro.bank.entity.Account;
import com.luis.navarro.bank.entity.Customer;
import com.luis.navarro.bank.exception.RequestException;
import com.luis.navarro.bank.mapper.AccountMapper;
import com.luis.navarro.bank.repository.AccountRepository;
import com.luis.navarro.bank.repository.CustomerRepository;
import com.luis.navarro.bank.service.AccountService;
import com.luis.navarro.bank.util.DefaultResponseMessage;
import com.luis.navarro.bank.util.ResponseFactory;

@Service
public class AccountServiceImp implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountMapper accountMapper;
	
	@Override
	public ResponseEntity<Response> save(AccountDTO request) {
		/* Search Customer if exists
		 * */
		Optional<Customer> customerSearch = customerRepository.findByDocumentId(request.getDocumentId());
		if (Boolean.TRUE.equals(customerSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRASSV001", DefaultResponseMessage.MESSAGE_NT_FOUND_CUSTOMER);
		}
		/* Check if exists account
		 * */
		Optional<Account> accountSearch = accountRepository.findByAccountNumber(request.getAccountNumber());
		if (Boolean.FALSE.equals(accountSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_ACCEPTABLE, "ERRASACC001", DefaultResponseMessage.MESSAGE_EXISTS_ACCOUNT);
		}
		return ResponseFactory.create(accountMapper.toModel(accountRepository.save(accountMapper.toEntity(request, customerSearch.get()))));
	}

	@Override
	public ResponseEntity<Response> update(AccountDTO request) {
		Optional<Account> accountSearch = accountRepository.findByAccountNumber(request.getAccountNumber());
		if (Boolean.TRUE.equals(accountSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRNFAS001", DefaultResponseMessage.MESSAGE_NT_FOUND_ACCOUNT);
		}
		accountSearch.get().setAccountType(request.getAccountType());
		accountSearch.get().setAccountState(request.getAccountState());
		accountSearch.get().setStartingBalance(request.getStartingBalance());
		
		return ResponseFactory.accepted(accountMapper.toModel(accountRepository.save(accountSearch.get())));
	}

	@Override
	public ResponseEntity<Response> delete(String accountNumber) {
		Optional<Account> accountSearch = accountRepository.findByAccountNumber(accountNumber);
		if (Boolean.TRUE.equals(accountSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRDACC001", DefaultResponseMessage.MESSAGE_NT_FOUND_ACCOUNT);
		}
		/* Delete account
		 * */
		accountRepository.deleteByAccountNumber(accountNumber);
		return ResponseFactory.ok(true);
	}

	@Override
	public ResponseEntity<Response> findAccountByAccountNumber(String accountNumber) {
		Optional<Account> accountSearch = accountRepository.findByAccountNumber(accountNumber);
		if (Boolean.TRUE.equals(accountSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRFACCNB001", DefaultResponseMessage.MESSAGE_NT_FOUND_ACCOUNT);
		}
		return ResponseFactory.ok(accountMapper.toModel(accountSearch.get()));
	}

	@Override
	public ResponseEntity<Response> findAllAccount() {
		List<Account> accountList = accountRepository.findAll();
		if (accountList == null || accountList.isEmpty()) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRFACC001", DefaultResponseMessage.MESSAGE_LIST_ACCOUNT);
		}
		return ResponseFactory.ok(accountMapper.toModelList(accountList));
	}
}
