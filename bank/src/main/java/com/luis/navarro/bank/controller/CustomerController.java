package com.luis.navarro.bank.controller;

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
import com.luis.navarro.bank.dto.CustomerDTO;
import com.luis.navarro.bank.dto.PersonDTO;
import com.luis.navarro.bank.dto.Response;
import com.luis.navarro.bank.service.CustomerService;
import com.luis.navarro.bank.service.PersonService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Customer Management", description = "here you get the Customer endpoints")
@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private CustomerService customerService;
	
	@Operation(summary = "Search person")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = PersonDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(value = "/person/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getPerson(@RequestParam(value = "document_id") String documentId) {
		return personService.findPersonByDocumentId(documentId);
	}
	
	@Operation(summary = "All people")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = PersonDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllPerson() {
		return personService.findAllPerson();
	}
	
	@Operation(summary = "Create new Person")
	@ApiResponses({
	    @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = PersonDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})	
	@PostMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createPerson(@Valid @RequestBody(required = true) PersonDTO person) {
		return personService.save(person);
	}
	
	@Operation(summary = "Update data Person")
	@ApiResponses({
	    @ApiResponse(responseCode = "202", content = {@Content(schema = @Schema(implementation = PersonDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@PutMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updatePerson(@Valid @RequestBody(required = true) PersonDTO person) {
		return personService.update(person);
	}
	
	@Operation(summary = "Delete data Person")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Boolean.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@DeleteMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deletePerson(@RequestParam(value = "document_id") String documentId) {
		return personService.delete(documentId);
	}
	
	@Operation(summary = "Search person")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = CustomerDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getCustomer(@RequestParam(value = "document_id") String documentId) {
		return customerService.findCustomerByDocumentId(documentId);
	}
	
	@Operation(summary = "All Customers")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = CustomerDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getAllCustomer() {
		return customerService.findAllCustomer();
	}
	
	@Operation(summary = "Create new Customer")
	@ApiResponses({
	    @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = CustomerDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> createCustomer(@Valid @RequestBody(required = true) CustomerDTO customer) {
		return customerService.save(customer);
	}
	
	@Operation(summary = "Update data Customer")
	@ApiResponses({
	    @ApiResponse(responseCode = "202", content = {@Content(schema = @Schema(implementation = CustomerDTO.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> updateCustomer(@Valid @RequestBody(required = true) CustomerDTO customer) {
		return customerService.update(customer);
	}	
	
	@Operation(summary = "Delete data Customer")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Boolean.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> deleteCustomer(@RequestParam(value = "document_id") String documentId) {
		return customerService.delete(documentId);
	}
}
