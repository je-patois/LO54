package fr.utbm.jaxb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.util.HibernateUtil;
import fr.utbm.jaxb.entity.*;

public class ClientDao implements Serializable {

	private Session session; 
	
	
	// constructeur
	public ClientDao() {
		
	}

	// Récupère toutes les informations de tous les clients 
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
	
	//Récupère un client avec son id
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
	
	
	
	//ajout d'un client
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
	
	
	//mise à jour d'un client
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
	
	//Suppression d'un client
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
}
