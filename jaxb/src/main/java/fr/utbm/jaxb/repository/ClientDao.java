package fr.utbm.jaxb.repository;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.util.HibernateUtil;

/**
 * [Couche: DAO] - Entité Client
 */
public class ClientDao implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private Session session; 
	private JAXBContext context;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constrcuteur par défaut
	 */
	public ClientDao() {
		try {
			initJAXBContext();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// --------- GETTERS & SETTERS ---------
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public JAXBContext getContext() {
		return context;
	}
	
	public void setContext(JAXBContext context) {
		this.context = context;
	}

	
	// --------- METHODES ---------
	
	/**
	 * Récupère et renvoie tous les clients
	 * @return
	 */
	public List<Client> getClient () {
		
		session = HibernateUtil.getSessionFactory().openSession();
		List<Client> listeClient = new ArrayList<Client>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Client");
			listeClient = query.list();
			session.getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(session != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }      
			}	
		}	
		return listeClient;
	}


	/**
	 * Récupère et renvoie un client dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Client getClientById (int id){
		
		session = HibernateUtil.getSessionFactory().openSession();
		Client client = new Client();
	
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Client where id = :id");
			query.setParameter("id", id);
			client = (Client) query.uniqueResult();
			session.getTransaction().commit();
		}	
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(session != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }    
			}
		}
		return client;
	}
	
	/**
	 * Récupère et renvoie les clients inscrits à une session de cours donnée en paramètre
	 * @param courseSession
	 * @return
	 */
		public List<Client> getClientByCourseSession (CourseSession courseSession){
			
			session = HibernateUtil.getSessionFactory().openSession();
			List<Client> clients = new ArrayList<Client>();
			
			try {
				session.beginTransaction();
				Query query = session.createQuery("from Client where courseSessionId = :courseSession");
				query.setParameter("courseSession", courseSession);
				clients = query.list();
				session.getTransaction().commit();
			}
			catch (HibernateException he) {
		        he.printStackTrace();
		        if(session.getTransaction() != null) {
		            try {
		                session.getTransaction().rollback();
		            }catch(HibernateException he2) {
		            	he2.printStackTrace(); 
		            }
		        }
			}
			finally {
				if(session != null) {
		            try { 
		            	session.close();
		            }catch(HibernateException he2) {
		            	he2.printStackTrace(); 
		            }     
				}
			}
			return clients;
		}
	
	/**
	 * Ajoute un client en base de donnée en avertissant du succès ou non de l'opération
	 * @param client
	 * @return
	 */
	public boolean addClient (Client client){
		
		session = HibernateUtil.getSessionFactory().openSession();
		boolean succes;
		
		try {
			session.beginTransaction();
			session.persist(client);
			session.getTransaction().commit();
			succes = true;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        succes = false;
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(session != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }    
			}
		}
		return succes;
	}
	
	
	/**
	 * Met à jour un client en base de données en avertissant du succès ou non de l'opération
	 * @param client
	 * @return
	 */
	public boolean updateClient (Client client){
		
		session = HibernateUtil.getSessionFactory().openSession();
		boolean succes;
		
		try {
			session.beginTransaction();
			session.merge(client);
			session.getTransaction().commit();
			succes = true;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        succes = false;
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(session != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
			}
		}
		return succes;
	}
	
	/**
	 * Supprime un client en base de données en avertissant du succès ou non de l'opération
	 * @param client
	 * @return
	 */
	public boolean deleteClient (Client client){
		
		session = HibernateUtil.getSessionFactory().openSession();
		boolean succes;
		
		try {
			session.beginTransaction();
			session.delete(client);
			session.getTransaction().commit();
			succes = true;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        succes = false;
	        if(session.getTransaction() != null) {
	            try {
	                session.getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(session != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }   
			}
		}
		return succes;
	}
	
	/**
	 * Initalise JAXBContext
	 * @throws JAXBException 
	 */
	public void initJAXBContext() throws JAXBException {
		this.context = JAXBContext.newInstance(Client.class);
	}
	
	/**
	 * Utilise les fonctionnalités de JAXB pour sérialiser l'object Client dans un fichier XML
	 * @param client
	 * @throws JAXBException 
	 */
	public String fromClientToXML(Client client, String filename) throws JAXBException {
		String home = System.getProperty("user.home");
		File file = new File(home+"/Downloads/" + filename + ".xml"); 
		
		Marshaller marshaller = this.context.createMarshaller();
		marshaller.marshal(client, file);
		
		return home+"\\Downloads\\";
	}
	
	/**
	 * Utilise les fonctionnalités de JAXB pour déséraliser un fichier XML relatif à l'inscription d'un client
	 * @param filename
	 * @throws JAXBException
	 */
	public Client fromXMLToClient(String path) throws JAXBException {
		Unmarshaller unmarshaller = this.context.createUnmarshaller();
		Client client = (Client) unmarshaller.unmarshal(new File(path));
		return client;
	}
}
