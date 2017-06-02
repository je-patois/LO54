package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.LocationController;
import fr.utbm.jaxb.entity.Location;

/**
 * Servlet d'ajout de lieu
 */
@WebServlet(name="addlocation", urlPatterns = "/addlocation")
public class AddLocation extends HttpServlet implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;

	
	// --------- CONSTRUCTEURS ---------
	
	/** 
	 * Constructeur par défaut
	 */
	public AddLocation() {
		
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Comportement de la servlet en accès POST. Récupération des données depuis le formulaire et ajout de la ville en base de données
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
	    
	    // Récupération du paramètre
	    String city = request.getParameter("city");
	    
	    
	    // Ajout de la ville en base de données
	    Location locationToAdd = new Location(city);
	    LocationController locationController = new LocationController();
	    
	    boolean success = locationController.addLocation(locationToAdd);
	    
	    //rajout des paramètres pour le jsp
	    request.setAttribute("success", success);
	    
	    // appel de la page jsp
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/locationAdded.jsp");			
	    dispatcher.forward(request,response);
	}
	
	/**
	 * Comportement de la servlet en accès GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    String course = request.getParameter("course");
	    request.setAttribute("course", course);
	    
	    // Redirection vers la page addlocation.jsp
	    request.getRequestDispatcher("/WEB-INF/jsp/addlocation.jsp").forward(request, response);
	    
	    out.close();
	}
}
