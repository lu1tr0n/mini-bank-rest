package com.luis.navarro.bank.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class APIError implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "error_message")
    private Object errorMessage;

	@JsonProperty(value = "error_code")
    private String errorCode;

    private String request;
    
    @JsonProperty(value = "request_type")
    private String requestType;

    @JsonProperty(value = "message")
    private Object customMessage;

}