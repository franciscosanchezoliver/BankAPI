package org.convidad.datarepo;

import org.convidad.domain.BankAccount;
import org.springframework.stereotype.Repository;

import static org.convidad.controller.BankController.database;

@Repository
public class BankDaoImpl implements BankDao{

	@Override
	public boolean createBankAccountForClient(String idClient, BankAccount bankAccount) {
		if(database.getClients().containsKey(idClient)) {
			if(!database.getClients().get(idClient).getAccounts().contains(bankAccount)) {
				database.getClients().get(idClient).getAccounts().add(bankAccount);
				if(!database.getBankAccounts().containsKey(bankAccount.getId())) {
					database.getBankAccounts().put(bankAccount.getId(), bankAccount);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public double depositMoneyInBankAccount(String idBankAccount, double amount) {
		if(database.getBankAccounts().containsKey(idBankAccount)) {
			return database.getBankAccounts().get(idBankAccount).deposit(amount);
		}
		return Double.NaN;
	}

	@Override
	public double withdrawMoneyInBankAccount(String idBankAccount, double amount) {
		if(database.getBankAccounts().containsKey(idBankAccount)) {
			return database.getBankAccounts().get(idBankAccount).withdraw(amount);
		}
		return Double.NaN;
	}

	@Override
	public double seeAccountBalance(String idBankAccount, double amount) {
		if(database.getBankAccounts().containsKey(idBankAccount)) {
			return database.getBankAccounts().get(idBankAccount).getMoney();
		}
		return Double.NaN;
	}

}
