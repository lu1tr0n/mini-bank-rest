package com.luis.navarro.bank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.luis.navarro.bank.dto.APIError;
import com.luis.navarro.bank.dto.Response;
import com.luis.navarro.bank.service.MovementsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Reports Management", description = "here you get the Reports endpoints")
@RestController
@RequestMapping("/reports")
public class ReportsController {

	@Autowired
	private MovementsService movementsService;
	
	@Operation(summary = "Generate Reports by date")
	@ApiResponses({
	    @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Map.class), mediaType = "application/json")}),
	    @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema(implementation = APIError.class), mediaType = "application/json")}),
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getMovement(@RequestParam(value = "account_number") String accountNumber, 
			@RequestParam(value = "start_Date") String startDate, @RequestParam(value = "end_date") String endDate) {
		return movementsService.generateReportsBetweenDate(accountNumber, startDate, endDate);
	}
}
