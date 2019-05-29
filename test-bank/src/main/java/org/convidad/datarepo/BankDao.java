package org.convidad.datarepo;

import org.convidad.domain.BankAccount;

public interface BankDao {
	public boolean createBankAccountForClient(String idClient, BankAccount bankAccount );
	public double depositMoneyInBankAccount(String idBankAccount, double amount);
	public double withdrawMoneyInBankAccount(String idBankAccount, double amount);
	public double seeAccountBalance(String idBankAccount, double amount);
}
