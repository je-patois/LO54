package fr.utbm.jaxb.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.util.HibernateUtil;

public class CourseDao {
	
	private Session session;
	
	public CourseDao() {
		
	}
	
	// Récupère toutes les informations de tous les clients 
	public List<Course> getCourse (){
			
		session = HibernateUtil.getSessionFactory().openSession();
		List<Course> listeCourse = new ArrayList<Course>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("* from course");
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

	
	//ajout d'une course
	public boolean AddCourse (Course course){
		
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
	
	//mise à jour d'une course
	public boolean UpdateCourse (Course course){
		
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

}
