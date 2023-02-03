package com.luis.navarro.bank.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luis.navarro.bank.dto.AccountDTO;
import com.luis.navarro.bank.entity.Account;
import com.luis.navarro.bank.entity.Customer;

@Component
public class AccountMapper {
	/**
	 * @param account
	 * @return
	 */
	public AccountDTO toModel(Account account) {
		return AccountDTO.builder().
				accountNumber(account.getAccountNumber())
				.accountState(account.getAccountState() != null ? account.getAccountState() : Boolean.FALSE)
				.accountType(account.getAccountType())
				.startingBalance(account.getStartingBalance() != null ? account.getStartingBalance() : BigDecimal.ZERO)
				.documentId(account.getCustomer().getDocumentId())
				.build();
	}
	
	/**
	 * @param account
	 * @return
	 */
	public Account toEntity(AccountDTO account, Customer customer) {
		return Account.builder()
				.accountNumber(account.getAccountNumber())
				.accountState(account.getAccountState())
				.accountType(account.getAccountType())
				.startingBalance(account.getStartingBalance())
				.customer(customer)
				.build();
	}
	
	/**
	 * @param account
	 * @return
	 */
	public List<AccountDTO> toModelList(List<Account> account) {
		List<AccountDTO> accountList = new ArrayList<>();
		account.stream().forEach(info -> {
			AccountDTO accountNewList = new AccountDTO();
			accountNewList.setAccountNumber(info.getAccountNumber());
			accountNewList.setAccountState(info.getAccountState());
			accountNewList.setAccountType(info.getAccountType());
			accountNewList.setStartingBalance(info.getStartingBalance());
			accountNewList.setDocumentId(info.getCustomer().getDocumentId());
			accountList.add(accountNewList);
		});
		
		return accountList;
	}
}
