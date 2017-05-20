package fr.utbm.jaxb.service;

import java.io.Serializable;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.repository.ClientDao;

public class ClientService implements Serializable {

	private static final long serialVersionUID = 1L;
	private ClientDao clientDao;
	
	public ClientService() {
		clientDao = new ClientDao();
	}

	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	public boolean addClient(Client client) {
		boolean success = clientDao.addClient(client);
		return success;
	}
}
