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

public class CourseSessionDAO implements Serializable {

	private Session session;
	
	public CourseSessionDAO() {
		
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
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
}
