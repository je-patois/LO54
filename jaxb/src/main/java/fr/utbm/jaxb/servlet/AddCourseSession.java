package fr.utbm.jaxb.servlet;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * Servlet d'ajout de session de cours
 */
@WebServlet(name="addcoursesession", urlPatterns = "/addcoursesession")
public class AddCourseSession extends HttpServlet implements Serializable {

	// --------- DEFINITION DES VARIBALES ---------
	
	private static final long serialVersionUID = 1L;

	
	// --------- CONSTRUCTEUS ---------
	
	/** 
	 * Constructeur par défaut
	 */
	public AddCourseSession() {
		
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Comportement de la servlet en accès POST. Récupération des données depuis le formulaire et ajout de la session de cours en base de données
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des paramtères
	    String startDate = request.getParameter("startDate");
	    String endDate = request.getParameter("endDate");
	    String course = request.getParameter("course");
	    String location = request.getParameter("location");
	    
	    out.println("<html><body><h1>Data:</h1><br/><p>Start date:" + startDate + "<br/>End date: " + endDate + "<br/>Course: " + course + "<br/>Location: " + location + "</p>");
	    
	    // Formattage des dates pour compatabilité avec la base de données
	    CourseSessionController courseSessionController = new CourseSessionController();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Exemple: 2017-25-05
	    Date startDateFormart = null;
	    Date endDateFormart = null;
		try {
			startDateFormart = formatter.parse(startDate);
			endDateFormart = formatter.parse(endDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// Ajout de la session de cours en base de données
	    CourseSession courseSessionToAdd = new CourseSession(startDateFormart, endDateFormart); // Via le constructeur, on peut initialiser au maximum les dates
	    // Il reste un cours et une ville à ajouter pour obtenir un enregistrement complet
	    CourseController courseController = new CourseController();
	    Course courseToAdd = courseController.getCourseById(course); // Récupération du cours
	    LocationController locationController = new LocationController();
	    Location locationToAdd = locationController.getLocationById(Integer.parseInt(location)); // Récupération de la ville
	    // Ajout des informations manquantes à la session de cours
	    courseSessionToAdd.setCourse(courseToAdd);
	    courseSessionToAdd.setLocation(locationToAdd);
	    
	    boolean success = courseSessionController.addCourseSession(courseSessionToAdd);
	    if(success) {
	    	out.println("<p>Ajout réussi !</p>");
	    } else {
	    	out.println("<p>Echec de l'ajout.</p>");
	    }
	    out.println("<a href=\"http://localhost:8080/jaxb/listcoursesession?course=" + courseToAdd.getCode() + "\">Retourner à la liste des sessions de cours</a></body></html>");
	    out.close();
	}
	
	/**
	 * Comportement de la servlet en accès GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des villes
	    LocationController locationController = new LocationController();
	    List<Location> allLocations = locationController.getAllLocations();
	    request.setAttribute("locations", allLocations);
	    
	    // Redirection vers la page addcoursesession.jsp
	    request.getRequestDispatcher("/WEB-INF/jsp/addcoursesession.jsp").forward(request, response);
	    out.close();
	}
}