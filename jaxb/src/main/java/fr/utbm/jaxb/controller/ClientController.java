package fr.utbm.jaxb.controller;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.service.ClientService;

/**
 * [Couche: Controller] - Entité Client
 */
public class ClientController implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private ClientService clientService;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public ClientController() {
		clientService = new ClientService();
	}

	
	// --------- GETTERS & SETTERS ---------
	
	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}
	
	
	// --------- METHODES ---------
	
	/**
	 *  Ajoute un client en base de donnée en avertissant du succès ou non de l'opération
	 * @param client
	 * @return
	 */
	public boolean addClient(Client client) {
		boolean success = clientService.addClient(client);
		return success;
	}
	
	/**
	 *  Récupère et renvoie tous les clients inscrits à une session de cours
	 * @param courseSession
	 * @return
	 */
	public List<Client> getClientsByCourseSession(CourseSession courseSession) {
		List<Client> clients = clientService.getClientsByCourseSession(courseSession);
		return clients;
	}
}
