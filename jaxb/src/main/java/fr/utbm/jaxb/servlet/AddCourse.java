package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.RequestDispatcher;
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
	    //java.io.PrintWriter out = response.getWriter();
	    
	    
	    
	    
	    // Récupération des paramètres
	    String code = request.getParameter("code");
	    String title = request.getParameter("title");
	    
	    // Ajout du cours en base de données
	    Course courseToAdd = new Course(code, title);
	    CourseController courseController = new CourseController();
	    
	    boolean success = courseController.addCourse(courseToAdd);
	    
	    //rajout des paramètre pour le jsp
	    request.setAttribute("success", success);
	    
	    //appel du jsp
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseAdded.jsp");			
	    dispatcher.forward(request,response);	
	    
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
