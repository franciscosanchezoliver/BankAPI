package org.convidad.service;

import java.util.List;

import org.convidad.datarepo.ClientDao;
import org.convidad.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService{

	ClientDao clientDao; 
	
	@Autowired
	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	@Override
	public List<Client> listAllClients() {
		return clientDao.listAllClients();
	}

	@Override
	public boolean addClient(Client client) {
		return clientDao.addClient(client);
	}

	@Override
	public boolean updateClient(Client client) {
		return clientDao.updateClient(client);
	}

	@Override
	public Client deleteClienById(String id) {
		return clientDao.deleteClientById(id);
	}
	
	@Override
	public Client findClient(String id) {
		return clientDao.findClient(id);
	}



}
