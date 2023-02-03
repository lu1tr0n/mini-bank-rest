package com.luis.navarro.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.navarro.bank.dto.APIError;
import com.luis.navarro.bank.dto.AccountDTO;
import com.luis.navarro.bank.dto.Response;
import com.luis.navarro.bank.service.AccountService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@Tag(name = "Account Management", description = "here you get the Accounts endpoints")
@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Operation(summary = "Search account")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = AccountDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAccount(@RequestParam(value = "account_number") String accountNumber) {
		return accountService.findAccountByAccountNumber(accountNumber);
	}

	@Operation(summary = "Return all accounts")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = List.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllAccount() {
		return accountService.findAllAccount();
	}

	@Operation(summary = "Create new Account")
	@ApiResponses({
	    @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = AccountDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createAccount(@Valid @RequestBody(required = true) AccountDTO account) {
		return accountService.save(account);
	}

	@Operation(summary = "Update data Account")
	@ApiResponses({
	    @ApiResponse(responseCode = "202", content = {@Content(schema = @Schema(implementation = AccountDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateAccount(@Valid @RequestBody(required = true) AccountDTO account) {
		return accountService.update(account);
	}

	@Operation(summary = "Delete Account")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Boolean.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteAccount(@RequestParam(value = "account_number") String accountNumber) {
		return accountService.delete(accountNumber);
	}
}
