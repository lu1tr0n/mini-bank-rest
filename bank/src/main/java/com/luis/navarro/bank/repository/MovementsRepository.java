package com.luis.navarro.bank.repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luis.navarro.bank.entity.Movements;

import jakarta.transaction.Transactional;

@Repository
public interface MovementsRepository extends JpaRepository<Movements, Serializable>{
	
	public List<Movements> findAll();
	
	@Query(value = "SELECT SUM(m.movementValue) FROM Movements m JOIN m.account a WHERE a.accountNumber=?1")
	public BigDecimal sumMovementValueByAccountNumber(String accountNumber);

	@Query(value = "SELECT m FROM Movements m JOIN m.account a WHERE a.accountNumber=?1")
	public List<Movements> findAllMovementsByAccountNumber(String accountNumber);
	
	@Query(value = "SELECT m FROM Movements m JOIN m.account a WHERE a.accountNumber=?1 AND m.movementDate BETWEEN ?2 AND ?3 ORDER BY m.movementDate DESC")
	public List<Movements> findAllMovementsByAccountNumberAndBetweenMovementDate(String accountNumber, Date startDate, Date endDate);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Movements WHERE Movements.id_account=?1", nativeQuery = true)
	public void deleteAllMovementsByIdAccount(Long idAccount);
}
