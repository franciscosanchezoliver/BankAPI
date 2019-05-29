package org.convidad.controller;

import java.util.List;

import org.convidad.domain.Client;
import org.convidad.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ClientController {

	@Autowired
	ClientService clientService;

	/**
	 * Return a list with all clients.
	 * 
	 * @return 200 OK. 			List of clients. <br>
	 * 		   204 No Content. 	If there aren't clients.
	 */
	@RequestMapping(value = "/clients/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> listAllClients() {
		List<Client> list = clientService.listAllClients();
		HttpStatus httpStatus = list.size() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK;
		return new ResponseEntity<List<Client>>(list, httpStatus);
	}

	/**
	 * Return one client.
	 * 
	 * @return 200 OK.	 		Info of client. <br>
	 *         204 No Content. 	If the client doesn't exist.
	 */
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> getClient(@PathVariable("id") String id) {
		Client client = clientService.findClient(id);
		return client != null ?  new ResponseEntity<Client>(client, HttpStatus.OK) : new ResponseEntity<Client>(HttpStatus.NO_CONTENT);  
	}

	/**
	 * Create a new client.
	 * 
	 * @param Client object.
	 * @return 201 Created if a new client has been inserted. <br> 
	 *         409 Conflict if it was not possible to create the new client.
	 */
	@RequestMapping(value = "/clients/", method = RequestMethod.POST)
	public ResponseEntity<Void> addClient(@RequestBody Client client) {
		HttpStatus returnStatus = clientService.addClient(client) ? HttpStatus.CREATED : HttpStatus.CONFLICT;
		return new ResponseEntity<Void>(new HttpHeaders(), returnStatus);
	}

	/**
	 * Update an existing client.
	 * 
	 * @param Client object.
	 * @return 200 OK.		 If the client has been updated. <br> 
	 * 		   409 Conflict. If it was not possible to updated the client.
	 */
	@RequestMapping(value = "/clients/", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClient(@RequestBody Client client) {
		HttpStatus returnStatus = clientService.updateClient(client) ? HttpStatus.OK : HttpStatus.CONFLICT;
		return new ResponseEntity<Void>(new HttpHeaders(), returnStatus);
	}

	/**
	 * Update a client.
	 * 
	 * @param Client id
	 * @param Client object.
	 * @return 200 OK.		 If the client has been updated. <br> 
	 * 		   409 Conflict. If it was not possible to update the client.
	 */
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateClientById(@PathVariable("id") String id, @RequestBody Client client) {
		client.setId(id);
		HttpStatus returnStatus = clientService.updateClient(client) ? HttpStatus.OK : HttpStatus.CONFLICT;
		return new ResponseEntity<Void>(new HttpHeaders(), returnStatus);
	}

	/**
	 * Delete a client.
	 * 
	 * @param Client id
	 * @param Client object.
	 * @return 201 OK + Client info.	 If the client has been removed. <br> 
	 *         204 No content. 			 if it was not possible to remove the client.
	 */	
	@RequestMapping(value = "/clients/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Client> deleteClientById(@PathVariable("id") String id) {
		Client deleted = clientService.deleteClienById(id);
		HttpStatus returnStatus = deleted != null ? HttpStatus.OK : HttpStatus.NO_CONTENT;
		return new ResponseEntity<Client>(deleted, returnStatus);
	}

}
