package org.convidad.datarepo;

import java.util.HashMap;

import org.convidad.domain.BankAccount;
import org.convidad.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Database {

	private static Database instance = null;
	private HashMap<String, Client> clients;
	private HashMap<String, BankAccount> bankAccounts;

	public static Database getInstace() {
		if(instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	private Database() {
		clients = new HashMap<String, Client>();
		bankAccounts = new HashMap<String, BankAccount>();

		// Fill the database with test data
		Client julio = new Client("103994433", "Julio M. Silva");
		Client daisy = new Client("656809119", "Daisy C. Ingram");
		Client isaac = new Client("139041712", "Isaac S. Reid");

		addClient(julio);
		addClient(daisy);
		addClient(isaac);

		BankAccount bancoSantander = new BankAccount("5416123015035048", "Banco Santander", julio);
		bancoSantander.deposit(5.0);
		bancoSantander.deposit(6.0);
		julio.addAccount(bancoSantander);

		BankAccount bankia = new BankAccount("5125559597680580", "Bankia", julio);
		bankia.deposit(2.3);
		bankia.deposit(1.0);
		julio.addAccount(bankia);
		bankia.addOwner(daisy);
		daisy.addAccount(bankia);

		BankAccount bbva = new BankAccount("5181796580552860", "BBVA", isaac);
		bbva.deposit(8.6);
		bbva.withdraw(100);
		isaac.addAccount(bbva);

		BankAccount evobanco = new BankAccount("5540259810933901", "Evo Banco", isaac);
		evobanco.deposit(20.0);
		evobanco.deposit(5.2);
		isaac.addAccount(evobanco);

		addBankAccount(bancoSantander);
		addBankAccount(bankia);
		addBankAccount(bbva);
		addBankAccount(evobanco);
	}

	public boolean addClient(Client client) {
		if (!this.clients.containsKey(client.getId())) {
			this.clients.put(client.getId(), client);
			return true;
		} else {
			return false;
		}
	}

	public boolean addBankAccount(BankAccount bankAccount) {
		if (!this.bankAccounts.containsKey(bankAccount.getId())) {
			this.bankAccounts.put(bankAccount.getId(), bankAccount);
			return true;
		} else {
			return false;
		}
	}

	public HashMap<String, Client> getClients() {
		return clients;
	}

	public void setClients(HashMap<String, Client> clients) {
		this.clients = clients;
	}

	public HashMap<String, BankAccount> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(HashMap<String, BankAccount> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}
	
	

}
