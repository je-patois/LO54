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

@WebServlet( name="listcoursesession", urlPatterns = "/listcoursesession" )
public class ListCourseSession extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	public ListCourseSession() {
		
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		CourseSessionController courseSessionController = new CourseSessionController();
		List<CourseSession> courseSessions = courseSessionController.getCourseSessionByCode(request.getParameter("course"));
		request.setAttribute("course", request.getAttribute("course"));
		request.setAttribute("sessions", courseSessions);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/coursesessions.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
