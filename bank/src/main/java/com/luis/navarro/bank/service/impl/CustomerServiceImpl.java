package com.luis.navarro.bank.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.luis.navarro.bank.dto.CustomerDTO;
import com.luis.navarro.bank.dto.Response;
import com.luis.navarro.bank.entity.Customer;
import com.luis.navarro.bank.exception.RequestException;
import com.luis.navarro.bank.mapper.CustomerMapper;
import com.luis.navarro.bank.repository.CustomerRepository;
import com.luis.navarro.bank.service.CustomerService;
import com.luis.navarro.bank.util.DefaultResponseMessage;
import com.luis.navarro.bank.util.ResponseFactory;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public ResponseEntity<Response> save(CustomerDTO request) {
		Optional<Customer> customerSearch = customerRepository.findByDocumentId(request.getDocumentId());
		if (Boolean.FALSE.equals(customerSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_ACCEPTABLE, "ERRCTMSV001", DefaultResponseMessage.MESSAGE_EXISTS_CUSTOMER);
		}
		/* Increment sequence
		 * */
		Customer newCostumer = customerMapper.toEntity(request);
		newCostumer.setIdCustomer(customerRepository.count()+1);
		return ResponseFactory.create(customerMapper.toModel(customerRepository.save(newCostumer)));
	}

	@Override
	public ResponseEntity<Response> update(CustomerDTO request) {
		Optional<Customer> customerSearch = customerRepository.findByDocumentId(request.getDocumentId());
		if (Boolean.TRUE.equals(customerSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRCTMUP001", DefaultResponseMessage.MESSAGE_NT_FOUND_CUSTOMER);
		}
		/* Update field after save
		 * */
		customerSearch.get().setNames(request.getNames());
		customerSearch.get().setSurnames(request.getSurnames());
		customerSearch.get().setGender(request.getGender());
		customerSearch.get().setAge(request.getAge());
		customerSearch.get().setAddress(request.getAddress());
		customerSearch.get().setTelephone(request.getTelephone());
		customerSearch.get().setState(request.getState());
		customerSearch.get().setPassword(request.getPassword());
		return ResponseFactory.accepted(customerMapper.toModel(customerRepository.save(customerSearch.get())));
	}

	@Override
	public ResponseEntity<Response> delete(String documentId) {
		Optional<Customer> customerSearch = customerRepository.findByDocumentId(documentId);
		if (Boolean.TRUE.equals(customerSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRCTMDT001", DefaultResponseMessage.MESSAGE_NT_FOUND_CUSTOMER);
		}
		/* Delete register
		 * */
		customerRepository.delete(customerSearch.get());
		return ResponseFactory.ok(true);
	}

	@Override
	public ResponseEntity<Response> findCustomerByDocumentId(String documentId) {
		Optional<Customer> customerSearch = customerRepository.findByDocumentId(documentId);
		if (Boolean.TRUE.equals(customerSearch.isEmpty())) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRCTMDT001", DefaultResponseMessage.MESSAGE_NT_FOUND_CUSTOMER);
		}
		return ResponseFactory.ok(customerMapper.toModel(customerSearch.get()));
	}

	@Override
	public ResponseEntity<Response> findAllCustomer() {
		List<Customer> customerList = customerRepository.findAll();
		if (customerList == null || customerList.isEmpty()) {
			throw new RequestException(HttpStatus.NOT_FOUND, "ERRCTMFA001", DefaultResponseMessage.MESSAGE_LIST_CUSTOMER);
		}
		return ResponseFactory.ok(customerMapper.toModelList(customerList));
	}

}
