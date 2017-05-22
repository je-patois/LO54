package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.entity.Course;

@WebServlet(name="addcourse", urlPatterns = "/addcourse")
public class AddCourse extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public AddCourse() {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    String code = request.getParameter("code");
	    String title = request.getParameter("title");
	    out.println("<html><body><h1>Adding course to database</h1><br/><p>Code:" + code+ "<br/>Title: " + title + "</p>");
	    Course courseToAdd = new Course(code, title);
	    CourseController courseController = new CourseController();
	    boolean success = courseController.addCourse(courseToAdd);
	    if(success) {
	    	out.println("<p>The course has been successfully added.</p>");
	    } else {
	    	out.println("<p>An error occured when adding the course to database. Please try later.</p>");
	    }
	    out.println("</body></html>");
	    out.close();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    request.getRequestDispatcher("/WEB-INF/jsp/addcourse.jsp").forward(request, response);
	    out.close();
	}
}
