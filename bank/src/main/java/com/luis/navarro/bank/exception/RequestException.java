package com.luis.navarro.bank.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RequestException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private String code;
	
    private HttpStatus httpStatus;
    
    public RequestException(HttpStatus httpStatus, String code, String message){
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
