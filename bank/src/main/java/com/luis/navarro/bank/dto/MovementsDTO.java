package com.luis.navarro.bank.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.luis.navarro.bank.util.DefaultResponseMessage;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovementsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty(value = "movement_number", required = false)
	private Long idMovement;

	@JsonProperty(value = "movement_date")
	@JsonFormat(timezone = DefaultResponseMessage.TIMEZONE)
    private Date movementDate;
	
	@JsonProperty(value = "movement_type")
    private String movementType;
	
	@JsonProperty(value = "movement_description", required = false)
    private String movementDescription;
	
	@JsonProperty(value = "movement_value")
    private BigDecimal movementValue;
	
	@JsonProperty(value = "balance")
    private BigDecimal balance;
	
	@NotNull(message = DefaultResponseMessage.MESSAGE_NT_NULL_NM_ACCOUNT)
	@NotBlank(message = DefaultResponseMessage.MESSAGE_NT_NULL_NM_ACCOUNT)
	@NotEmpty(message = DefaultResponseMessage.MESSAGE_NT_NULL_NM_ACCOUNT)
	@JsonProperty(value = "account_number")
	private String accountNumber; 
}
