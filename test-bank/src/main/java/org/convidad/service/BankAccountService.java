package org.convidad.service;

import java.util.List;

import org.convidad.domain.BankAccount;

public interface BankAccountService {
	public List<BankAccount> listAllBankAccounts();
	public boolean addBankAccount(BankAccount bankAccount);
	public BankAccount findBankAccount(String id);
	public boolean updateBankAccount(BankAccount bankAccount);
	public BankAccount deleteBankAccountById(String id);
}
