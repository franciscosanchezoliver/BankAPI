package org.convidad.datarepo;


import java.util.List;

import org.convidad.domain.BankAccount;

public interface BankAccountDao {
	public List<BankAccount> listAllBankAccounts();
	public boolean addBankAccount(BankAccount bankAccount);
	public BankAccount findBankAccount(String id);
	public boolean updateBankAccount(BankAccount bankAccount);
	public BankAccount deleteBankAccountById(String id);
}
