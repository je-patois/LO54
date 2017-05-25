package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.controller.LocationController;
import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.entity.Location;

/**
 * Servlet Home
 */
@WebServlet( name="index", urlPatterns = "" )
public class ListCourse extends HttpServlet implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	private CourseController courseController;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public ListCourse() {

	}
	
	
	// --------- GETTERS & SETTERS ---------
	
	public CourseController getCourseController() {
		return courseController;
	}

	public void setCourseController(CourseController courseController) {
		this.courseController = courseController;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// --------- METHODES ---------
	
	/**
	 * Comportement du servlet 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseController courseController = new CourseController();
		List<Course> allCourses = courseController.getAllCourses();
		LocationController locationController = new LocationController();
		List<Location> locations = locationController.getAllLocations();
		request.setAttribute("locations", locations);
        request.setAttribute("courses", allCourses);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/home.jsp" ).forward( request, response );
    }
	
	/** 
	 * Gestion du filtrage sur un paramètre à la fois
	 * @param request
	 * @param response
	 * @param action
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestPost(HttpServletRequest request, HttpServletResponse response, String action)
            throws ServletException, IOException {
		
		CourseController courseController = new CourseController();
		List<Course> courses = new ArrayList<Course>();
		
		// 1 seul paramètre doit être renseigné
		if(action.equals("titleFragment")) { // Mot-clé dans l'intitulé du cours
			
			// Récupération du paramètre
			String titleFragment = request.getParameter("titleFragment");
			
			// Récupération de la liste de cours associée
			courseController = new CourseController();
			courses = courseController.getCourseFilteredByTitle(titleFragment);
			
		} else if(action.equals("date")) { // Date
			
			// Récupération du paramètre
			String dateString = request.getParameter("date");
			
			// Formattage de la donnée
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    Date date = null;
			try {
				date = formatter.parse(dateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			// Récupération de la liste de cours associée: Les sessions de cours relatives à la date concernée sont d'abord récupérées, pour en déduire la bonne liste de cours
			CourseSessionController courseSessionController = new CourseSessionController();
			List<CourseSession> courseSessions = courseSessionController.getCourseSessionByDate(date);
			List<String> selectedCourses = new ArrayList<String>();
			for(CourseSession courseSession: courseSessions) {
				selectedCourses.add(courseSession.getCourse().getCode());
			}
			courses = courseController.getGroupCoursesByCode(selectedCourses);
			
		} else if(action.equals("location")) { // Ville
			
			// Récupération du paramètre
			String location = request.getParameter("location");
			
			// Récupération de la liste de cours associée: Les sessions de cours relatives à la ville concernée sont d'abord récupérées, pour en déduire la bonne liste de cours
			CourseSessionController courseSessionController = new CourseSessionController();
			List<CourseSession> courseSessions = courseSessionController.getCourseSessionByLocation(Integer.parseInt(location));
			List<String> selectedCourses = new ArrayList<String>();
			for(CourseSession courseSession: courseSessions) {
				selectedCourses.add(courseSession.getCourse().getCode());
			}
			courses = courseController.getGroupCoursesByCode(selectedCourses);
			
		}
		
		// Récupération des villes
		LocationController locationController = new LocationController();
		List<Location> locations = locationController.getAllLocations();
		
		// Transmission des paramètres
		request.setAttribute("locations", locations);
		request.setAttribute("courses", courses);
		
		// Redirection vers la page home.jsp
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/home.jsp" ).forward( request, response );
    }
	

	/**
	 * Gestion du filtrage sur plusieurs paramètres simultanément
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestPostMulti(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		// récupération des paramètres
		String dateString = request.getParameter("date");
		String location = request.getParameter("location");
		String titleFragment = request.getParameter("titleFragment");
		
		// Formattage des données et vérification à null : Pour faciliter l'opération côté DAO, les paramètres non ou mal renseignés sont passés à null
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = null;
		try {
			if(!dateString.equals("")) {
				date = formatter.parse(dateString);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Integer locationId = null;
		if(!location.equals("null")) {
			locationId = Integer.parseInt(location);
		}
		
		if(titleFragment.equals("")) {
			titleFragment = null;
		}
		
		// Récupération des cours filtrés
		CourseController courseController = new CourseController();
		List<Course> courses = new ArrayList<Course>();
		courses = courseController.getCoursesByDateLocationTitleFragment(date, locationId, titleFragment);
		
		// Récupération des villes
		LocationController locationController = new LocationController();
		List<Location> locations = locationController.getAllLocations();
		
		// Transmission des paramètres
		request.setAttribute("locations", locations);
		request.setAttribute("courses", courses);
		request.setAttribute("previousSearch", titleFragment);
		request.setAttribute("previousLocation", locationId);
		request.setAttribute("previousDate", dateString);
		
		// Redirection vers la page home.jsp
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/home.jsp" ).forward( request, response );
    }

	/**
	 * Comportement de la servlet en accès GET
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    /**
     * Comportement de la servlet en accès POST. Récupération des données depuis le formulaire et filtrage de la liste de cours
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	response.setContentType("text/html");
    	
    	/*if(request.getParameterMap().size() == 1 && request.getParameterMap().containsKey("titleFragment")) {
    		processRequestPost(request, response, "titleFragment");
    	} else if(request.getParameterMap().size() == 1 && request.getParameterMap().containsKey("date")) {
    		processRequestPost(request, response, "date");
    	} else if(request.getParameterMap().size() == 1 && request.getParameterMap().containsKey("location")) {
    		processRequestPost(request, response, "location");
    	} else {
    		List<String> list = new ArrayList<String>();
    		list.add("location");
    		list.add("date");
    		list.add("titleFragment");
    		processRequestPostMulti(request, response, list);
    	}*/
    	
    	// Appel de la méthode de gestion du filtrage sur plusieurs paramètres
		processRequestPostMulti(request, response);
    }

    /**
     * Infos sur la servlet
     */
    public String getServletInfo() {
        return "Short description";
    }   
}
