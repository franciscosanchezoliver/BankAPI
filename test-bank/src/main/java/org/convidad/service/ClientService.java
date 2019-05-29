package org.convidad.service;

import java.util.List;

import org.convidad.domain.Client;

public interface ClientService {
	public List<Client> listAllClients();
	public boolean addClient(Client client);
	public Client findClient(String id);
	public boolean updateClient(Client client);
	public Client deleteClienById(String id);
}
