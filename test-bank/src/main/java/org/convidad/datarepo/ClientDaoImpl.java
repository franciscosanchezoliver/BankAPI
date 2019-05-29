package org.convidad.datarepo;

import static org.convidad.controller.BankController.database;

import java.util.ArrayList;
import java.util.List;

import org.convidad.domain.Client;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDaoImpl implements ClientDao{

	@Override
	public Client findClient(String id) {
		if(database.getClients().containsKey(id))
			return database.getClients().get(id);
		return null;
	}
	
	@Override
	public List<Client> listAllClients() {
		return new ArrayList<Client>(database.getClients().values());
	}

	@Override
	public boolean addClient(Client client) {
		if(!database.getClients().containsKey(client.getId())){
			database.getClients().put(client.getId(), client);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateClient(Client client) {
		if(database.getClients().containsKey(client.getId())) {
			database.getClients().replace(client.getId(), client);
			return true;
		}
		return false;
	}
	
	@Override
	public Client deleteClientById(String id) {
		if(database.getClients().containsKey(id)) {
			return database.getClients().remove(id);
		}
		return null;
	}

}
