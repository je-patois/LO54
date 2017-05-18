package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name="home", urlPatterns = "/home" )
public class HomeServlet extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    //out.println("<html><body>Hello</body></html>");
	    request.getRequestDispatcher("home.html").forward(request, response);
	    //out.println("<html><body><a href>List of films</a></body></html>");
	    out.close();
	}
}
