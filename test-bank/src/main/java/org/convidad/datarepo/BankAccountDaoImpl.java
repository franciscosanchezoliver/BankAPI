package org.convidad.datarepo;

import static org.convidad.controller.BankController.database;

import java.util.ArrayList;
import java.util.List;

import org.convidad.domain.BankAccount;
import org.springframework.stereotype.Repository;

@Repository
public class BankAccountDaoImpl implements BankAccountDao{

	@Override
	public BankAccount findBankAccount(String id) {
		if(database.getBankAccounts().containsKey(id))
			return database.getBankAccounts().get(id);
		return null;
	}
	
	@Override
	public List<BankAccount> listAllBankAccounts() {
		return new ArrayList<BankAccount>(database.getBankAccounts().values());
	}

	@Override
	public boolean addBankAccount(BankAccount bankAccount) {
		if(!database.getBankAccounts().containsKey(bankAccount.getId())){
			database.getBankAccounts().put(bankAccount.getId(), bankAccount);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBankAccount(BankAccount bankAccount) {
		if(database.getBankAccounts().containsKey(bankAccount.getId())) {
			database.getBankAccounts().replace(bankAccount.getId(), bankAccount);
			return true;
		}
		return false;
	}
	
	@Override
	public BankAccount deleteBankAccountById(String id) {
		if(database.getBankAccounts().containsKey(id)) {
			return database.getBankAccounts().remove(id);
		}
		return null;
	}

}
