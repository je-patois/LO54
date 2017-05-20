package fr.utbm.jaxb.controller;

import java.io.Serializable;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.service.ClientService;

public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClientService clientService;
	
	public ClientController() {
		clientService = new ClientService();
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	public boolean addClient(Client client) {
		boolean success = clientService.addClient(client);
		return success;
	}
}
