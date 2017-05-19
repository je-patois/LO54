package fr.utbm.jaxb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.util.HibernateUtil;

public class CourseDao implements Serializable{
	
	private Session session;
	
	public CourseDao() {
		
	}
	
	// Récupère toutes les informations de tous les cours
	public List<Course> getCourse (){
			
		session = HibernateUtil.getSessionFactory().openSession();
		List<Course> listeCourse = new ArrayList<Course>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Course");
			listeCourse = query.list();
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
		return listeCourse;
	}

	//Récupère un cours avec son id
	public Course getCourseById (String id){
		session = HibernateUtil.getSessionFactory().openSession();
		Course cours = new Course();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Course where id = :id");
			query.setParameter("id", id);
			cours = (Course) query.uniqueResult();
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
		
		return cours;
	}
	
	//ajout d'un cours
	public boolean addCourse (Course course){
		
		session = HibernateUtil.getSessionFactory().openSession();
		boolean succes;
		
		try {
			session.beginTransaction();
			session.persist(course);
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
	
	//Mise à jour d'un cours
	public boolean updateCourse (Course course){
		
		session = HibernateUtil.getSessionFactory().openSession();
		boolean succes;
		try {
			session.beginTransaction();
			session.merge(course);
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
	
	//Suppression d'un cours
	public boolean deleteCourse (Course course){
		
		session = HibernateUtil.getSessionFactory().openSession();
		boolean succes;
		try {
			session.beginTransaction();
			session.delete(course);
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
