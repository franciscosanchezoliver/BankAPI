package org.convidad.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BankAccount implements Comparator<BankAccount> {

	private String id;
	private String name;
	// One bank account can belong to many clients, but only one of them will be the holder
	@JsonIgnore
	private Client holder;
	@JsonIgnore
	private List<Client> owners;
	private double money;

	public BankAccount() {
		
	}
	
	public BankAccount(String id, String name, Client holder) {
		super();
		this.id = id;
		this.name = name;
		this.holder = holder;
		owners = new ArrayList<Client>();
		owners.add(holder);
		this.money = 0.0;
	}

	public BankAccount(String id, String name, Client holder, double money) {
		super();
		this.id = id;
		this.name = name;
		this.holder = holder;
		owners = new ArrayList<Client>();
		owners.add(holder);
		this.money = money;
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

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Client getHolder() {
		return holder;
	}

	public void setHolder(Client holder) {
		this.holder = holder;
	}

	public List<Client> getOwners() {
		return owners;
	}

	public void setOwners(List<Client> owners) {
		this.owners = owners;
	}

	public void addOwner(Client owner) {
		this.owners.add(owner);
	}
	
	public double deposit(double money) {
		this.money += money;
		return money;
	}

	public double withdraw(double money) {
		this.money -= money;
		return money;
	}

	@Override
	public int compare(BankAccount b1, BankAccount b2) {
		return (b1.getId().compareTo(b2.getId()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
