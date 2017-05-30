package fr.utbm.jaxb.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.service.CourseSessionService;

/**
 * [Couche: Controller] - Entité CourseSession
 */
public class CourseSessionController implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private CourseSessionService courseSessionService;

	
	// --------- CONSTRUCTEURS ---------
	
	public CourseSessionController() {
		courseSessionService = new CourseSessionService();
	}
	
	
	// --------- GETTERS & SETTERS ---------
	
	public CourseSessionService getCourseSessionService() {
		return courseSessionService;
	}

	public void setCourseSessionService(CourseSessionService courseSessionService) {
		this.courseSessionService = courseSessionService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	// --------- METHODES ---------
	
	/** 
	 * Récupère et renvoie les sessions de cours relatives au cours donné en paramètre
	 * @param code
	 * @return
	 */
	public List<CourseSession> getCourseSessionByCode(String code) {
		List<CourseSession> myCourseSession = courseSessionService.getCourseSessionByCode(code);
		return myCourseSession;
	}
	
	/** 
	 * Récupère et renvoie les sessions de cours dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public CourseSession getCourseSessionByID(Integer id) {
		CourseSession myCourseSession = courseSessionService.getCourseSessionByID(id);
		return myCourseSession;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours avec le nom de ville associé
	 * @return
	 */
	public List<Object> getCourseSessionWithLocation() {
		List<Object> myObject = courseSessionService.getCourseSessionWithLocation();
		return myObject;
	}
	
	/** 
	 * Ajoute une nouvelle session de cours en base de données
	 * @param courseSession
	 * @return
	 */
	public boolean addCourseSession(CourseSession courseSession) {
		boolean success = courseSessionService.addCourseSession(courseSession);
		return success;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours se déroulant à la date donnée en paramètre
	 * @param date
	 * @return
	 */
	public List<CourseSession> getCourseSessionByDate(Date date) {
		List<CourseSession> courseSessions = courseSessionService.getCourseSessionByDate(date);
		return courseSessions;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours se déroulant dans la ville donnée en paramètre
	 * @param locationId
	 * @return
	 */
	public List<CourseSession> getCourseSessionByLocation(Integer locationId) {
		List<CourseSession> courseSessions = courseSessionService.getCourseSessionByLocation(locationId);
		return courseSessions;
	}
	
	/**
	 * Récupère et renvoie les sessions de cours dont les paramètres concordent avec :
	 * - une date donnée
	 * - une ville donnée
	 * - un cours donné
	 * Les paramètres peuvent être null ou non
	 * @param date
	 * @param locationId
	 * @param code
	 * @return
	 */
	public List<CourseSession> getCourseSessionsByDateLocationCode(Date date, Integer locationId, String code) {
		List<CourseSession> courseSessions = courseSessionService.getCourseSessionsByDateLocationCode(date, locationId, code);
		return courseSessions;
	}
}
