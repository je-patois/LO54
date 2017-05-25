package fr.utbm.jaxb.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.repository.CourseDao;

/**
 * [Couche - Service] - Entité Course
 */
public class CourseService implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	private static final long serialVersionUID = 1L;
	private CourseDao courseDao;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public CourseService() {
		courseDao = new CourseDao();
	}

	
	// --------- GETTERS & SETTERS ---------
	
	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Récupère et renvoie tous les cours
	 * @return
	 */
	public List<Course> getAllCourses() {
		List<Course> myList = courseDao.getCourse();
		return myList;
	}
	
	/**
	 * Ajoute un cours en base de données en avertissant de la réussite ou non de l'opération
	 * @param course
	 * @return
	 */
	public boolean addCourse(Course course) {
		boolean success = courseDao.addCourse(course);
		return success;
	}
	
	/**
	 * Récupère et renvoie un cours dont l'ID est donné en paramètre
	 * @param id
	 * @return
	 */
	public Course getCourseById(String id) {
		Course course = courseDao.getCourseById(id);
		return course;
	}
	
	/**
	 * Récupère et renvoie les cours contenant le mot clé passé en paramètre dans leur titre
	 * @param titleFragment
	 * @return
	 */
	public List<Course> getCourseFilteredByTitle(String titleFragment) {
		List<Course> courses = courseDao.getCourseFilteredByTitle(titleFragment);
		return courses;
	}
	
	/**
	 * Récupère et renvoie les cours dont les codes sont présents dans la liste de cours passée en paramètre
	 * @param codes
	 * @return
	 */
	public List<Course> getGroupCoursesByCode(List<String> codes) {
		List<Course> courses = courseDao.getGroupCoursesByCode(codes);
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
	 * @param titleFragment
	 * @return
	 */
	public List<Course> getCoursesByDateLocationTitleFragment(Date date, Integer locationId, String titleFragment) {
		List<Course> courses = courseDao.getCoursesByDateLocationTitleFragment(date, locationId, titleFragment);
		return courses;
	}
}
