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

public class LocationDAO implements Serializable {

	private Session session;
	
	// Constructeur par défaut
	public LocationDAO() {
		
	}
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	// Récupère toutes les informations de toutes les locations
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
	
	// Ajoute une location
	public Boolean addLocation(Location location) {
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
	
	// Met à jour une location
		public Boolean updateLocation(CourseSession courseSession) {
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
}
