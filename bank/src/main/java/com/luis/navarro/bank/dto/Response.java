package com.luis.navarro.bank.dto;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Response implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	private String message;

	private Object response;
}