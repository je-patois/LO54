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

import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.controller.LocationController;
import fr.utbm.jaxb.entity.CourseSession;
import fr.utbm.jaxb.entity.Location;

/**
 * Servlet de récupération de la liste des sessions de cours relatives au cours choisi
 */
@WebServlet( name="listcoursesession", urlPatterns = "/listcoursesession" )
public class ListCourseSession extends HttpServlet implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;

	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public ListCourseSession() {
		
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Récupération et affichage de la liste des sessions de cours pour le cours choisi
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		// Récupération de la liste des sessions de cours associées au cours choisi
		CourseSessionController courseSessionController = new CourseSessionController();
		List<CourseSession> courseSessions = courseSessionController.getCourseSessionByCode(request.getParameter("course"));
		
		// Récupération des villes
		LocationController locationController = new LocationController();
		List<Location> locations = locationController.getAllLocations();
		
		// Transmission des paramètres
		request.setAttribute("course", request.getAttribute("course"));
		request.setAttribute("sessions", courseSessions);
		request.setAttribute("locations", locations);
		
		// Redirection vers la page coursesesions.jsp
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/coursesessions.jsp" ).forward( request, response );
    }
	
	/**
	 * Gestion du filtrage sur plusieurs paramètres simultanément
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		// récupération des paramètres
		String dateString = request.getParameter("date");
		String location = request.getParameter("location");
		String course = request.getParameter("course");
		
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
		
		// Récupération des sessions de cours filtrées
		CourseSessionController courseSessionController = new CourseSessionController();
		List<CourseSession> courseSessions = new ArrayList<CourseSession>();
		courseSessions = courseSessionController.getCourseSessionsByDateLocationCode(date, locationId, course);
		
		// Récupération des villes
		LocationController locationController = new LocationController();
		List<Location> locations = locationController.getAllLocations();
		
		// Transmission des paramètres
		request.setAttribute("locations", locations);
		
		request.setAttribute("previousLocation", locationId);
		request.setAttribute("previousDate", dateString);
		request.setAttribute("sessions", courseSessions);
		request.setAttribute("course", course);
		
		// Redirection vers la page home.jsp
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/coursesessions.jsp" ).forward( request, response );
    }

	
	/**
	 * Comportement de la servlet en accès GET
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    /**
     * Comportement de la servlet en accès POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPost(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
