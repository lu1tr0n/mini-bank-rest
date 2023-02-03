package com.luis.navarro.bank.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_person", unique = true, nullable = false)
    private Long idPerson;
	
	@Column(name = "names")
	@JsonProperty(value = "names")
	private String names;
	
	@Column(name = "surnames")
	@JsonProperty(value = "surnames")
	private String surnames;
	
	@Column(name = "gender")
	@JsonProperty(value = "gender")
	private String gender;
	
	@Column(name = "age")
	@JsonProperty(value = "age")
	private Integer age;
	
	@Column(name = "document_id")
	@JsonProperty(value = "document_id")
	private String documentId;
	
	@Column(name = "address")
	@JsonProperty(value = "address")
	private String address;
	
	@Column(name = "telephone")
	@JsonProperty(value = "telephone")
	private String telephone;
}