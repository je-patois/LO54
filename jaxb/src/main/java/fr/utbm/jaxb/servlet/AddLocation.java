package fr.utbm.jaxb.servlet;

import java.io.Serializable;

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
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération du paramètre
	    String city = request.getParameter("city");
	    
	    out.println("<html><body><h1>Ajout de la ville en base de données</h1><br/><p>City:" + city + "</p>");
	    
	    // Ajout de la ville en base de données
	    Location locationToAdd = new Location(city);
	    LocationController locationController = new LocationController();
	    
	    boolean success = locationController.addLocation(locationToAdd);
	    if(success) {
	    	out.println("<p>La ville a été ajouté avec succès.</p>");
	    } else {
	    	out.println("<p>Une erreur est survenue durant l'ajout en base de données. Veuillez réessayer plus tard.</p>");
	    }
	    out.println("<a href=\"http://localhost:8080/jaxb/addcoursesession?course=" + request.getParameter("course") + "\">Retourner de création de session de cours</a></body></html>");
	    out.close();
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
