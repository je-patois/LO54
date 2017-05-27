package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.entity.Course;

/**
 * Servlet d'ajout de cours
 */
@WebServlet(name="addcourse", urlPatterns = "/addcourse")
public class AddCourse extends HttpServlet implements Serializable {

	// --------- DEINFITION DES VARIABLES ---------
	
	private static final long serialVersionUID = 1L;
	
	
	// --------- CONSTRUCTEURS ---------
	
	/** Constructeur par défaut
	 * 
	 */
	public AddCourse() {
		
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Comportement de la servlet en accès POST. Récupération des données depuis le formulaire et ajout du cours en base de données
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des paramètres
	    String code = request.getParameter("code");
	    String title = request.getParameter("title");
	    
	    out.println("<html><body><h1>Ajout du cours en base de données</h1><br/><p>Code:" + code+ "<br/>Title: " + title + "</p>");
	    
	    // Ajout du cours en base de données
	    Course courseToAdd = new Course(code, title);
	    CourseController courseController = new CourseController();
	    
	    boolean success = courseController.addCourse(courseToAdd);
	    if(success) {
	    	out.println("<p>Le cours a été ajouté avec succès.</p>");
	    } else {
	    	out.println("<p>Une erreur est survenue durant l'ajout en base de données. Veuillez réessayer plus tard.</p>");
	    }
	    out.println("<a href=\"http://localhost:8080/jaxb\">Retourner à la page princpale</a></body></html>");
	    out.close();
	}
	
	/**
	 * Comportement de la servlet en accès GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Redirection vers la page addcourse.jsp
	    request.getRequestDispatcher("/WEB-INF/jsp/addcourse.jsp").forward(request, response);
	    
	    out.close();
	}
}
