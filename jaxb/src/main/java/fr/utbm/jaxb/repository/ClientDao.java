package fr.utbm.jaxb.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.util.HibernateUtil;
import fr.utbm.jaxb.entity.*;

public class ClientDao {

	private Session session; 
	
	
	// constructeur
	public ClientDao() {
		
	}
	
	//
	// Récupère toutes les informations de tous les clients 
	public List<Client> getClient () {
		
		session = HibernateUtil.getSessionFactory().openSession();
		List<Client> listeClient = new ArrayList<Client>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("* from client");
			listeClient = query.list();
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
	
	
	
}
