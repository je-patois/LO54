package fr.utbm.jaxb.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.Transformers;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.util.HibernateUtil;

/**
 * [Couche: DAO] - Entité Course
 * @author Exige
 *
 */
public class CourseDao implements Serializable{
	
	// --------- DEIFNITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private Session session;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/** 
	 * Constructeur par défaut
	 */
	public CourseDao() {
		
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
	 * Récupère et renvoie tous les cours
	 * @return
	 */
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


	/** 
	 * Récupère et renvoie un cours dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Course getCourseById (String id){
		
		session = HibernateUtil.getSessionFactory().openSession();
		Course cours = new Course();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Course where code = :id");
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
	
	/**
	 * Récupère et renvoie les cours contenant le mot clé passé en paramètre dans leur titre
	 * @param titleFragment
	 * @return
	 */
	public List<Course> getCourseFilteredByTitle (String titleFragment){
			
		session = HibernateUtil.getSessionFactory().openSession();
		List<Course> listeCourse = new ArrayList<Course>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Course where title like :titleFragment");
			query.setParameter("titleFragment", "%" + titleFragment + "%");
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
	
	/**
	 * Récupère et renvoie les cours dont les codes sont présents dans la liste de cours passée en paramètre
	 * @param codes
	 * @return
	 */
	public List<Course> getGroupCoursesByCode(List<String> codes){
			
		session = HibernateUtil.getSessionFactory().openSession();
		List<Course> listeCourse = new ArrayList<Course>();
		
		try {
			session.beginTransaction();
			Query query = session.createQuery("from Course where code in (:codes)");
			query.setParameterList("codes", codes);
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
		
	
	/** 
	 * Récupère et renvoie les cours dont :
	 * - une session est en cours à la date passée en paramètre
	 * - qui se déroule dans la ville donnée en paramètre
	 * - qui contient le mot clé passé en paramètre dans son titre
	 * Les paramètres peuvent être null ou non
	 * ! Utilisation de l'API Criteria pour gérer les cas null et la jointure externe
	 * @param date
	 * @param locationId
	 * @param titleFragment
	 * @return
	 */
	public List<Course> getCoursesByDateLocationTitleFragment(Date date, Integer locationId, String titleFragment) {
		
		session = HibernateUtil.getSessionFactory().openSession();
		List<Course> courses = new ArrayList<Course>();
		
		try {
			session.beginTransaction();
			/*Query query = session.createQuery("select distinct c from CourseSession cs inner join cs.course c inner join cs.location l where ((:date is null and cs.startDate is null) or cs.startDate <= :date) and ((:date is null and cs.endDate is null) or cs.endDate >= :date) and ((:locationId is null and l.id is null) or l.id = :locationId) and ((:titleFragment is null and c.title is null) or c.title like :titleFragment)");
			query.setParameter("date", date);
			query.setParameter("locationId", locationId);
			query.setParameter("titleFragment", "%" + titleFragment + "%");
			System.out.println("Parameters: Date: " + date + "Location: " + locationId + "TitleFragment: " + titleFragment);
			courses = query.list();*/
			
			/*Criteria crit = session.createCriteria(CourseSession.class, "cs")
			.createAlias("cs.course", "c", JoinType.RIGHT_OUTER_JOIN)
			.createAlias("cs.location", "l")
			.setProjection( Projections.projectionList()
			        .add( Projections.distinct(Projections.property("course")) )
			    );
			if(date != null) {
				crit.add(Restrictions.le("cs.startDate", date));
				crit.add(Restrictions.ge("cs.endDate", date));
			}
			if(locationId != null) {
				crit.add(Restrictions.eq("l.id", locationId));
			}
			if(titleFragment != null) {
				crit.add(Restrictions.like("c.title", "%" + titleFragment + "%"));
			}*/
			/*Criteria crit = session.createCriteria(CourseSession.class, "cs");
					crit.createAlias("course", "c", JoinType.RIGHT_OUTER_JOIN)
					.setProjection( Projections.projectionList()
					        .add( Projections.distinct(Projections.property("course")) )
					    );
			List result = crit.list();
			System.out.println(crit.toString());
			System.out.println(result.toString());*/
			
			/*Criteria query = session.createCriteria(CourseSession.class, "cs");
	        if (date != null) {
	            query.add(Restrictions.le("cs.startDate", date));
	            query.add(Restrictions.ge("cs.endDate", date));
	        }
	        if (locationId != null) {
	            query.createAlias("location", "l");
	            query.add(Restrictions.eq("l.id", locationId).ignoreCase());
	        }
	        if (titleFragment != null) {
	            query.createAlias("course", "c", JoinType.RIGHT_OUTER_JOIN)
	            .setFetchMode("course", FetchMode.JOIN);
	            query.add(Restrictions.like("c.title", titleFragment, MatchMode.ANYWHERE).ignoreCase());
	        }
	        List<CourseSession> res = query.list();
	        //for (CourseSession e : res) {
	          //  Hibernate.initialize(e.getLocation().getId());
	          //  Hibernate.initialize(e.getCourse().getCode());
	        //}*/
			
			Criteria criteria = session.createCriteria(CourseSession.class,"cs");
			criteria.createCriteria("course","c",JoinType.RIGHT_OUTER_JOIN)
			    .setProjection(Projections.projectionList()
			    		.add(Projections.distinct(Projections.property("c.id").as("code")))
			    		.add(Projections.property("c.title").as("title")))
			    		.setResultTransformer(Transformers.aliasToBean(Course.class));
			if (date != null) {
	            criteria.add(Restrictions.le("cs.startDate", date));
	            criteria.add(Restrictions.ge("cs.endDate", date));
	        }
	        if (locationId != null) {
	        	criteria.createAlias("location", "l");
	            criteria.add(Restrictions.eq("l.id", locationId));
	        }
			if (titleFragment != null) {
	            criteria.add(Restrictions.like("c.title", titleFragment, MatchMode.ANYWHERE));
	        }
			courses =criteria.list();
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
		return courses;
	}
	
	/** 
	 * Ajoute un cours en base de données en avertissant de la réussite ou non de l'opération
	 * @param course
	 * @return
	 */
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
	
	/**
	 * Met à jour un cours en base de données en avertissant du succès ou non de l'opération
	 * @param course
	 * @return
	 */
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
	
	/** 
	 * Supprime un cours en base de données en avertissant du succès ou non de l'opération
	 * @param course
	 * @return
	 */
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
