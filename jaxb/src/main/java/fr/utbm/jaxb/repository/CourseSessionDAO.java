package fr.utbm.jaxb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.entity.Location;
import fr.utbm.jaxb.util.HibernateUtil;

/**
 * [Couche - DAO] - Entité CourseSession
 * @author Exige
 *
 */
public class CourseSessionDAO implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	private static final long serialVersionUID = 1L;
	private Session session;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/** 
	 * Constructeur par défaut
	 */
	public CourseSessionDAO() {
		
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
	 * Récupère et renvoie toutes les sessions de cours
	 * @return
	 */
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
	
	/** 
	 * Récupère et renvoie les sessions de cours avec le nom de ville associé
	 * @return
	 */
	public List<Object> getCourseSessionWithLocation() {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		List<Object> courseSessionList = new ArrayList<Object>();
		
	    try {
	        getSession().beginTransaction();
            Query query = getSession().createQuery("select l.city from CourseSession cs inner join cs.location l");
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
	
	/**
	 * Récupère et renvoie la session de cours dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public CourseSession getCourseSessionByID(int id) {
		
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
	
	/**
	 * Récupère et renvoie les sessions de cours relatives au cours donné en paramètre
	 * @param code
	 * @return
	 */
	public List<CourseSession> getCourseSessionByCode(String code) {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		List<CourseSession> courseSessions = new ArrayList<CourseSession>();
		
		try {
			getSession().beginTransaction();
			//Query query = getSession().createQuery("from CourseSession where courseCode = :code");
			Query query = getSession().createQuery("from CourseSession where COURSE_CODE = :code");
			query.setParameter("code", code);
			courseSessions = query.list();
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
		return courseSessions;
	}
	
	/** 
	 * Récupère et renvoie les sessions de cours se déroulant à la date donnée en paramètre
	 * @param date
	 * @return
	 */
	public List<CourseSession> getCourseSessionByDate(Date date) {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		List<CourseSession> courseSessions = new ArrayList<CourseSession>();
		
		try {
			getSession().beginTransaction();
			Query query = getSession().createQuery("from CourseSession where startDate <= :date and endDate >= :date");
			query.setParameter("date", date);
			courseSessions = query.list();
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
		return courseSessions;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours se déroulant dans la ville donnée en paramètre
	 * @param locationId
	 * @return
	 */
	public List<CourseSession> getCourseSessionByLocation(Integer locationId) {
		
		setSession(HibernateUtil.getSessionFactory().openSession());
		List<CourseSession> courseSessions = new ArrayList<CourseSession>();
		
		try {
			getSession().beginTransaction();
			Query query = getSession().createQuery("from CourseSession where LOCATION_ID = :locationId");
			query.setParameter("locationId", locationId);
			courseSessions = query.list();
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
		return courseSessions;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours dont les paramètres concordent avec :
	 * - une date donnée
	 * - une ville donnée
	 * Les paramètres peuvent être null ou non
	 * ! Utilisation de l'API Criteria
	 * @param date
	 * @param locationId
	 * @param code
	 * @return
	 */
	public List<CourseSession> getCourseSessionsByDateLocationCode(Date date, Integer locationId, String code) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		List<CourseSession> courseSessions = new ArrayList<CourseSession>();
		
		try {
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(CourseSession.class,"cs");
			criteria.createCriteria("course","c")
				.add(Restrictions.eq("c.code", code));
			if (date != null) {
	            criteria.add(Restrictions.le("cs.startDate", date));
	            criteria.add(Restrictions.ge("cs.endDate", date));
	        }
	        if (locationId != null) {
	        	criteria.createAlias("location", "l");
	            criteria.add(Restrictions.eq("l.id", locationId));
	        }
			courseSessions =criteria.list();
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
		return courseSessions;
	}
	
	/** 
	 * Ajoute une session de cours en base de données en avertisssant de la réussite ou non de l'opération
	 * @param courseSession
	 * @return
	 */
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
	
	/**
	 * Met à jour une session de cours en base de données en avertissant du succès ou non de l'opération
	 * @param location
	 * @return
	 */
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
		
	/**
	 * Supprime une session de cours en avertissant du succès ou non de l'opération
	 * @param courseSession
	 * @return
	 */
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
