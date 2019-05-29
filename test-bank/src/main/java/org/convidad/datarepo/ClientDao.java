package org.convidad.datarepo;


import java.util.List;

import org.convidad.domain.Client;

public interface ClientDao {
	public List<Client> listAllClients();
	public boolean addClient(Client client);
	public Client findClient(String id);
	public boolean updateClient(Client client);
	public Client deleteClientById(String id);
}
