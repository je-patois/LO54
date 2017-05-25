package fr.utbm.jaxb.service;

import java.io.Serializable;
import java.util.List;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.repository.ClientDao;

/**
 * [Couche - Service] - Entité Client
 */
public class ClientService implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private ClientDao clientDao;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/** 
	 * Constructeur par défaut
	 */
	public ClientService() {
		clientDao = new ClientDao();
	}

	
	// --------- GETTERS & SETTERS ---------
	
	public ClientDao getClientDao() {
		return clientDao;
	}

	public void setClientDao(ClientDao clientDao) {
		this.clientDao = clientDao;
	}

	
	// --------- METHODES ---------
	
	/**
	 * Ajoute un client en base de données en avertissant de la réussite ou non de l'opération
	 * @param client
	 * @return
	 */
	public boolean addClient(Client client) {
		boolean success = clientDao.addClient(client);
		return success;
	}
	
	/**
	 * Récupère et renvoie les clients inscrits à une session de cours donnée en paramètre
	 * @param courseSession
	 * @return
	 */
	public List<Client> getClientsByCourseSession(CourseSession courseSession) {
		List<Client> clients = clientDao.getClientByCourseSession(courseSession);
		return clients;
	}
}
