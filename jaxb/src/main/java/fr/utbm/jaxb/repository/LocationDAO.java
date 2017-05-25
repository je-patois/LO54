package fr.utbm.jaxb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.entity.Location;
import fr.utbm.jaxb.util.HibernateUtil;

/**
 * [Couche - DAO] - Entité Location
 */
public class LocationDAO implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private Session session;
	

	// --------- CONSTRUCTEUR ---------
	
	/**
	 * Constructeur par défaut
	 */
	public LocationDAO() {
		
	}
	
	
	// --------- GETTERS & SETTERS ---------
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
	// --------- METHODES ---------
	
	/**
	 * Récupère et renvoie toutes les villes
	 * @return
	 */
	public List<Location> getLocation() {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		List<Location> locationList = new ArrayList<Location>();
		
	    try {
	        getSession().beginTransaction();
            Query query = getSession().createQuery("from Location");
            locationList = query.list();
	        getSession().getTransaction().commit();
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(getSession().getTransaction() != null) {
	            try {
	            	getSession().getTransaction().rollback();
	            } catch(HibernateException he2) {
	            	he2.printStackTrace();
	            }
	        }
		}
		finally {
	        if(getSession() != null) {
	            try {
	            	getSession().close();
	            } catch(Exception e) {
	            	System.out.println(e);
	            }
            }
       }
       return locationList;
	}
	
	/**
	 * Récupère et renvoie une ville dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Location getLocationById(int id) {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		Location location = new Location();
		
		try {
			getSession().beginTransaction();
			Query query = getSession().createQuery("from Location where id = :id");
			query.setParameter("id", id);
			location = (Location) query.uniqueResult();
			getSession().getTransaction().commit();
		}
		
		catch (HibernateException he) {
	        he.printStackTrace();
	        if(getSession().getTransaction() != null) {
	            try {
	            	getSession().getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		
		finally {
		
			if(getSession() != null) {
	            try { 
	            	session.close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	                
			}
	
		}
		return location;
	}
	
	/**
	 * Ajoute une ville en base de données en avertissant de la réussite ou non de l'opération
	 * @param location
	 * @return
	 */
	public boolean addLocation(Location location) {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		Boolean success;
		
	    try {
	        getSession().beginTransaction();
            getSession().persist(location);
	        getSession().getTransaction().commit();
	        success = true;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        success = false;
	        if(getSession().getTransaction() != null) {
	            try {
	            	getSession().getTransaction().rollback();
	            } catch(HibernateException he2) {
	            	he2.printStackTrace();
	            }
	        }
		}
		finally {
	        if(getSession() != null) {
	            try {
	            	getSession().close();
	            } catch(Exception e) {
	            	System.out.println(e);
	            }
            }
       }
       return success;
	}
	
	/**
	 * Met à jour une ville en base en avertissant de la réussite ou non de l'opération
	 * @param courseSession
	 * @return
	 */
	public boolean updateLocation(CourseSession courseSession) {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		Boolean success;
		
	    try {
	        getSession().beginTransaction();
            getSession().merge(courseSession);
	        getSession().getTransaction().commit();
	        success = true;
		}
		catch (HibernateException he) {
	        he.printStackTrace();
	        success = false;
	        if(getSession().getTransaction() != null) {
	            try {
	            	getSession().getTransaction().rollback();
	            } catch(HibernateException he2) {
	            	he2.printStackTrace();
	            }
	        }
		}
		finally {
	        if(getSession() != null) {
	            try {
	            	getSession().close();
	            } catch(Exception e) {
	            	System.out.println(e);
	            }
            }
       }
       return success;
	}
	
	/** 
	 * Supprime une ville en avertissant de la réussite ou non de l'opération
	 * @param location
	 * @return
	 */
	public boolean deleteClient (Location location){
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		boolean succes;
		
		try {
			getSession().beginTransaction();
			getSession().delete(location);
			getSession().getTransaction().commit();
			succes = true;
		}
		
		catch (HibernateException he) {
	        he.printStackTrace();
	        succes = false;
	        if(getSession().getTransaction() != null) {
	            try {
	            	getSession().getTransaction().rollback();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }
	        }
		}
		finally {
			if(getSession() != null) {
	            try { 
	            	getSession().close();
	            }catch(HibernateException he2) {
	            	he2.printStackTrace(); 
	            }    
			}
		}
		return succes;
	}
}
