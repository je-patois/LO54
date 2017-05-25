package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.entity.CourseSession;

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
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		// Récupération de la liste des sessions de cours associées au cours choisi
		CourseSessionController courseSessionController = new CourseSessionController();
		List<CourseSession> courseSessions = courseSessionController.getCourseSessionByCode(request.getParameter("course"));
		
		// Transmission des paramètres
		request.setAttribute("course", request.getAttribute("course"));
		request.setAttribute("sessions", courseSessions);
		
		// Redirection vers la page coursesesions.jsp
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/coursesessions.jsp" ).forward( request, response );
    }

	
	/**
	 * Comportement de la servlet en accès GET
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Comportement de la servlet en accès POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
