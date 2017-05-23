package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.entity.Course;

@WebServlet(name="addcoursesession", urlPatterns = "/addcoursesession")
public class AddCourseSession extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public AddCourseSession() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, java.io.IOException {
    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    String startDate = request.getParameter("startDate");
    String endDate = request.getParameter("endDate");
    out.println("<html><body><h1>Data:</h1><br/><p>Start date:" + startDate + "<br/>End date: " + endDate + "</p>");
    out.close();
}

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
    ServletException, java.io.IOException {
    response.setContentType("text/html");
    java.io.PrintWriter out = response.getWriter();
    request.getRequestDispatcher("/WEB-INF/jsp/addcoursesession.jsp").forward(request, response);
    out.close();
}
}
