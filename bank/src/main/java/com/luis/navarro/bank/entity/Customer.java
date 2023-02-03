package com.luis.navarro.bank.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "Customer")
@PrimaryKeyJoinColumn(name="id_person")
public class Customer extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "customer_seq", sequenceName = "customer_sequence")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
	@Column(name = "id_customer")
	private Long idCustomer;
	
	@Column(name = "password")
	@JsonProperty(value = "password")
	private String password;
	
	@Column(name = "state")
	@JsonProperty(value = "state", defaultValue = "false")
	private Boolean state;
	
	@OneToMany(mappedBy="customer")
	@JsonProperty(value = "account_list")
	private List<Account> accountList;
}
