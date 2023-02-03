package com.luis.navarro.bank.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.luis.navarro.bank.util.DefaultResponseMessage;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Movements")
public class Movements {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_movement", unique = true, nullable = false)
	private Long idMovement;
    
	@Column(name = "movement_date")
	@JsonProperty(value = "movement_date")
	@JsonFormat(timezone = DefaultResponseMessage.TIMEZONE)
    private Date movementDate;
    
	/* Ahorro, Corriente
	 * */
	@Column(name = "movement_type")
	@JsonProperty(value = "movement_type")
    private String movementType;
	
	@Column(name = "movement_description")
	@JsonProperty(value = "movement_description")
	private String movementDescription;
    
	@Column(name = "movement_value")
	@JsonProperty(value = "movement_value")
    private BigDecimal movementValue;
    
	@Column(name = "balance")
	@JsonProperty(value = "balance")
    private BigDecimal balance;
	
	@ManyToOne
    @JoinColumn(name="id_account", nullable=false)
	private Account account;
}
