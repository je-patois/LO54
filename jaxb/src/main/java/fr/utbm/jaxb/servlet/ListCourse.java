package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.Course;
import fr.utbm.jaxb.repository.ClientDao;

@WebServlet( name="index", urlPatterns = "" )
public class ListCourse extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private CourseController courseController;
	
	public ListCourse() {

	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseController myCourseController = new CourseController();
		List<Course> allCourses = myCourseController.getAllCourses();

        request.setAttribute("courses", allCourses);
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/home.jsp" ).forward( request, response );
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

	public CourseController getCourseController() {
		return courseController;
	}

	public void setCourseController(CourseController courseController) {
		this.courseController = courseController;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
