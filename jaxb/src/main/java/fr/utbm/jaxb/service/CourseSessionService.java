package fr.utbm.jaxb.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.repository.CourseSessionDAO;

/**
 * [Couche - Service] - Entité CourseSession
 */
public class CourseSessionService implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	private static final long serialVersionUID = 1L;
	private CourseSessionDAO courseSessionDao;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/** 
	 * Constructeur par défaut
	 */
	public CourseSessionService() {
		courseSessionDao = new CourseSessionDAO();
	}
	
	
	// --------- GETTERS & SETTERS ---------
	
	public CourseSessionDAO getCourseSessionDao() {
		return courseSessionDao;
	}


	public void setCourseSessionDao(CourseSessionDAO courseSessionDao) {
		this.courseSessionDao = courseSessionDao;
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Récupère et renvoie les sessions de cours relatives au cours donné en paramètre
	 * @param code
	 * @return
	 */
	public List<CourseSession> getCourseSessionByCode(String code) {
		List<CourseSession> myCourseSession = courseSessionDao.getCourseSessionByCode(code);
		return myCourseSession;
	}
	
	/***
	 * Récupère et renvoie les sessions de cours dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public CourseSession getCourseSessionByID(Integer id) {
		CourseSession myCourseSession = courseSessionDao.getCourseSessionByID(id);
		return myCourseSession;
	}

	/**
	 * Récupère et renvoie les sessions de cours avec le nom de ville associé
	 * @return
	 */
	public List<Object> getCourseSessionWithLocation() {
		List<Object> myObject = courseSessionDao.getCourseSessionWithLocation();
		return myObject;
	}
	
	/**
	 * Ajoute une nouvelle session de cours en base de données
	 * @param courseSession
	 * @return
	 */
	public boolean addCourseSession(CourseSession courseSession) {
		boolean success = courseSessionDao.addCourseSession(courseSession);
		return success;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours se déroulant à la date donnée en paramètre
	 * @param date
	 * @return
	 */
	public List<CourseSession> getCourseSessionByDate(Date date) {
		List<CourseSession> courseSessions = courseSessionDao.getCourseSessionByDate(date);
		return courseSessions;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours se déroulant dans la ville donnée en paramètre
	 * @param locationId
	 * @return
	 */
	public List<CourseSession> getCourseSessionByLocation(Integer locationId) {
		List<CourseSession> courseSessions = courseSessionDao.getCourseSessionByLocation(locationId);
		return courseSessions;
	}
}
