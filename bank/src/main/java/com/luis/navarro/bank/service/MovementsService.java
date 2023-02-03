package com.luis.navarro.bank.service;

import org.springframework.http.ResponseEntity;

import com.luis.navarro.bank.dto.MovementsDTO;
import com.luis.navarro.bank.dto.Response;

public interface MovementsService {

	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> save(MovementsDTO request);
	
	/**
	 * @param request
	 * @return
	 */
	public ResponseEntity<Response> update(MovementsDTO request);
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public ResponseEntity<Response> delete(Long movementNumber);
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public ResponseEntity<Response> deleteAll(String accountNumber);
	
	/**
	 * @param movementNumber
	 * @return
	 */
	public ResponseEntity<Response> findMovementByIdMovement(Long movementNumber);
	
	/**
	 * @param accountNumber
	 * @return
	 */
	public ResponseEntity<Response> findAllMovementByAccountNumber(String accountNumber);
	
	/**
	 * @return
	 */
	public ResponseEntity<Response> findAllMovements();
	
	/**
	 * @param accountNumber
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ResponseEntity<Response> generateReportsBetweenDate(String accountNumber, String startDate, String endDate);
}
