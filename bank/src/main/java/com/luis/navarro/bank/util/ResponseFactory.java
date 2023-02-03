package com.luis.navarro.bank.util;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.luis.navarro.bank.dto.Response;

public class ResponseFactory implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @param response
	 * @return
	 */
	public static ResponseEntity<Response> ok(Object response) {
		return new ResponseEntity<>(new Response("Operación ejecutada correctamente.", response), HttpStatus.OK);
	}
	
	/**
	 * @return
	 */
	public static ResponseEntity<Response> ok() {
		return new ResponseEntity<>(new Response("Operación ejecutada correctamente."), HttpStatus.OK);
	}
	
	/**
	 * @param response
	 * @return
	 */
	public static ResponseEntity<Response> create(Object response) {
		return new ResponseEntity<>(new Response("Operación ejecutada correctamente.", response), HttpStatus.CREATED);
	}
	
	/**
	 * @return
	 */
	public static ResponseEntity<Response> create() {
		return new ResponseEntity<>(new Response("Operación ejecutada correctamente."), HttpStatus.CREATED);
	}
	
	/**
	 * @param response
	 * @return
	 */
	public static ResponseEntity<Response> accepted(Object response) {
		return new ResponseEntity<>(new Response("Operación ejecutada correctamente.", response), HttpStatus.ACCEPTED);
	}
	
	/**
	 * @return
	 */
	public static ResponseEntity<Response> accepted() {
		return new ResponseEntity<>(new Response("Operación ejecutada correctamente."), HttpStatus.ACCEPTED);
	}
}