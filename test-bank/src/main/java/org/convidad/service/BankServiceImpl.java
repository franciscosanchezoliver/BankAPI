package org.convidad.service;

import org.convidad.datarepo.BankDao;
import org.convidad.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankDao bankDao;
	
	@Autowired
	public void setBankDao(BankDao bankDao) {
		this.bankDao = bankDao;
	}	
	
	@Override
	public boolean createBankAccountForClient(String idClient, BankAccount bankAccount) {
		return bankDao.createBankAccountForClient(idClient, bankAccount);
	}

	@Override
	public double depositMoneyInBankAccount(String idBankAccount, double amount) {
		return bankDao.depositMoneyInBankAccount(idBankAccount, amount);
	}

	@Override
	public double withdrawMoneyInBankAccount(String idBankAccount, double amount) {
		return bankDao.withdrawMoneyInBankAccount(idBankAccount, amount);
	}

	@Override
	public double seeAccountBalance(String idBankAccount, double amount) {
		return bankDao.seeAccountBalance(idBankAccount, amount);
	}

}
