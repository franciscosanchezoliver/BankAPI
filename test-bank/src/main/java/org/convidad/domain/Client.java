package org.convidad.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Client {
	private String id;
	private String name;
	// A client may have many accounts
	private List<BankAccount> accounts;
	
	public Client() {
		
	}
	
	public Client(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = new ArrayList<BankAccount>();
	}

	public Client(String id, String name, List<BankAccount> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.accounts = accounts;
	}
	
	public double getBalance() {
		double balance = 0.0;
		for (BankAccount bankAccount : accounts) {
			balance += bankAccount.getMoney();
		}
		return balance; 
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<BankAccount> accounts) {
		this.accounts = accounts;
	}

	public void addAccount(BankAccount account) {
		this.accounts.add(account);
	}
	
	
	
}
