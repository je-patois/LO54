package fr.utbm.jaxb.service;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;

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
	 * Récupère et renvoie un client dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Client getClientById(int id) {
		Client client = clientDao.getClientById(id);
		return client;
	}
	
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
	
	/**
	 * Utilise les fonctionnalités de JAXB pour sérialiser l'object Client dans un fichier XML
	 * @param client
	 * @throws JAXBException
	 */
	public String fromClientToXML(Client client, String filename) throws JAXBException {
		String path = clientDao.fromClientToXML(client, filename);
		return path;
	}
	
	/**
	 * Utilise les fonctionnalités de JAXB pour déséraliser un fichier XML relatif à l'inscription d'un client
	 * @param filename
	 * @return
	 * @throws JAXBException
	 */
	public Client fromXMLtoClient(InputStream content) throws JAXBException {
		Client client = clientDao.fromXMLToClient(content);
		return client;
	}
}
