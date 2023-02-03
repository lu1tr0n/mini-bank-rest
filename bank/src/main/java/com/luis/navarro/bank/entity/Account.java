package com.luis.navarro.bank.entity;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "Account")
public class Account {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_account", unique = true, nullable = false)
	private Long idAccount;

	@Column(name = "account_number", unique = true, nullable = false)
	@JsonProperty(value = "account_number")
	private String accountNumber;
	
	@Column(name = "account_type")
	@JsonProperty(value = "account_type")
	private String accountType;
	
	@Column(name = "starting_balance")
	@JsonProperty(value = "starting_balance")
	private BigDecimal startingBalance;
	
	@Column(name = "account_state")
	@JsonProperty(value = "account_state")
	private Boolean accountState;
	
	@ManyToOne
    @JoinColumn(name="id_customer", nullable=false)
	private Customer customer;
	
	@Embedded
	@OneToMany(mappedBy="account")
	@JsonProperty(value = "movements_list")
	private List<Movements> movements;
}
