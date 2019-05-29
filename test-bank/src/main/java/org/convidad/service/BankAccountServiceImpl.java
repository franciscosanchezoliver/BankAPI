package org.convidad.service;

import java.util.List;

import org.convidad.datarepo.BankAccountDao;
import org.convidad.domain.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountServiceImpl implements BankAccountService{

	BankAccountDao bankAccountDao; 
	
	@Autowired
	public void setBankAccountDao(BankAccountDao backAccountDao) {
		this.bankAccountDao = backAccountDao;
	}

	@Override
	public List<BankAccount> listAllBankAccounts() {
		return bankAccountDao.listAllBankAccounts();
	}

	@Override
	public boolean addBankAccount(BankAccount bankAccount) {
		return bankAccountDao.addBankAccount(bankAccount);
	}

	@Override
	public boolean updateBankAccount(BankAccount bankAccount) {
		return bankAccountDao.updateBankAccount(bankAccount);
	}

	@Override
	public BankAccount deleteBankAccountById(String id) {
		return bankAccountDao.deleteBankAccountById(id);
	}
	
	@Override
	public BankAccount findBankAccount(String id) {
		return bankAccountDao.findBankAccount(id);
	}



}
