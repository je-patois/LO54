package fr.utbm.jaxb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.entity.Location;
import fr.utbm.jaxb.util.HibernateUtil;

public class CourseSessionDAO implements Serializable {

	private Session session;
	
	// Constructeur par défaut
	public CourseSessionDAO() {
		
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	// Récupère toutes les informations de toutes les sessions de cours
	public List<CourseSession> getCourseSession() {
		setSession(HibernateUtil.getSessionFactory().openSession());
		List<CourseSession> courseSessionList = new ArrayList<CourseSession>();
	    try {
	        getSession().beginTransaction();
            Query query = getSession().createQuery("from CourseSession");
            courseSessionList = query.list();
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
       return courseSessionList;
	}
	
	public CourseSession getCourseSessionById(int id) {
		setSession(HibernateUtil.getSessionFactory().openSession());
		CourseSession courseSession = new CourseSession();
		try {
			getSession().beginTransaction();
			Query query = getSession().createQuery("from CourseSession where id = :id");
			query.setParameter("id", id);
			courseSession = (CourseSession) query.uniqueResult();
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
		return courseSession;
	}
	
	// Ajoute une session de cours
	public boolean addCourseSession(CourseSession courseSession) {
		setSession(HibernateUtil.getSessionFactory().openSession());
		Boolean success;
	    try {
	        getSession().beginTransaction();
            getSession().persist(courseSession);
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
	
	// Met à jour une session de cours
	public boolean updateCourseSession(Location location) {
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
		
	//Suppression d'une session de cours
	public boolean deleteClient (CourseSession courseSession){
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		boolean succes;
		try {
			getSession().beginTransaction();
			getSession().delete(courseSession);
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
