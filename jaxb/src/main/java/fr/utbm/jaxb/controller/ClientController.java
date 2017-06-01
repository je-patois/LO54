package fr.utbm.jaxb.controller;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;

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
	 * Récupère et renvoie un client dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Client getClientById(int id) {
		Client client = clientService.getClientById(id);
		return client;
	}
	
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
	
	/**
	 * Utilise les fonctionnalités de JAXB pour sérialiser l'object Client dans un fichier XML
	 * @param client
	 * @throws JAXBException 
	 */
	public String fromClientToXML(Client client, String filename) throws JAXBException {
		String path = clientService.fromClientToXML(client, filename);
		return path;
	}
	
	/**
	 * Utilise les fonctionnalités de JAXB pour déséraliser un fichier XML relatif à l'inscription d'un client
	 * @param filename
	 * @return
	 * @throws JAXBException
	 */
	public Client fromXMLToClient(InputStream content) throws JAXBException {
		Client client = clientService.fromXMLtoClient(content);
		return client;
	}
}
