package fr.utbm.jaxb.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.service.CourseService;

/**
 * [Couche: Controller] - Entité Course
 */
public class CourseController implements Serializable {
	 
	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private CourseService courseService;
	
	
	// --------- CONSTRUCTEURS ---------
	
	public CourseController() {
		courseService = new CourseService();
	}

	
	// --------- GETTERS & SETTERS ---------
	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	// --------- METHODES ---------
	
	/**
	 *  Récupère et renvoie tous les cours
	 * @return
	 */
	public List<Course> getAllCourses() {
		List<Course> myList = courseService.getAllCourses();
		return myList;
	}
	
	/**
	 *  Ajoute un cours en base de donnée en avertissant du succès ou non de l'opération
	 * @param course
	 * @return
	 */
	public boolean addCourse(Course course) {
		boolean success = courseService.addCourse(course);
		return success;
	}
	
	/**
	 *  Récupère et renvoie le cours ayant l'ID donné
	 * @param id
	 * @return
	 */
	public Course getCourseById(String id) {
		Course course = courseService.getCourseById(id);
		return course;
	}
	
	/**
	 * Récupère et renvoie les cours contenant le mot clé passé en paramètre dans leur titre
	 * @param titleFragment
	 * @return
	 */
	public List<Course> getCourseFilteredByTitle(String titleFragment) {
		List<Course> courses = courseService.getCourseFilteredByTitle(titleFragment);
		return courses;
	}
	
	/**
	 *  Récupère et renvoie les cours dont les codes sont présents dans la liste de cours passée en paramètre
	 * @param codes
	 * @return
	 */
	public List<Course> getGroupCoursesByCode(List<String> codes) {
		List<Course> courses = courseService.getGroupCoursesByCode(codes);
		return courses;
	}
	
	/** 
	 * Récupère et renvoie les cours dont :
	 * - une session est en cours à la date passée en paramètre
	 * - qui se déroule dans la ville donnée en paramètre
	 * - qui contient le mot clé passé en paramètre dans son titre
	 * Les paramètres peuvent être null ou non
	 * @param date
	 * @param locationId
	 * @param title
	 * @return
	 */
	public List<Course> getCoursesByDateLocationTitleFragment(Date date, Integer locationId, String title) {
		List<Course> courses = courseService.getCoursesByDateLocationTitleFragment(date, locationId, title);
		return courses;
	}
}
