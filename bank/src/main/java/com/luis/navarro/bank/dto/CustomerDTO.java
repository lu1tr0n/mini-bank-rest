package com.luis.navarro.bank.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(callSuper=false)
@JsonInclude(content = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerDTO extends PersonDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "password")
	private String password;
	
	@JsonProperty(value = "state", defaultValue = "false")
	private Boolean state;
}
