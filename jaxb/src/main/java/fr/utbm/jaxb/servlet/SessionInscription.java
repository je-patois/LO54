package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;

@WebServlet( name="sessioninscription", urlPatterns = "/sessioninscription" )
public class SessionInscription extends HttpServlet implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public SessionInscription() {
		
	}
	
	protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		request.setAttribute("course", request.getAttribute("course"));
		request.setAttribute("session", request.getAttribute("session"));
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/courseinscription.jsp" ).forward( request, response );
    }
	
	protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
		String adress = request.getParameter("adress");
	    String email = request.getParameter("email");
	    String firstname = request.getParameter("firstname");
	    String lastname = request.getParameter("lastname");
	    String phone = request.getParameter("phone");
	    String course = request.getParameter("course");
	    String sessionID = request.getParameter("session");
	    out.println("<html><body><h1>Ajout du profil en base de données</h1><br/><p>Adress:" + adress + "<br/>Email: " + email + "<br/>Firstname: " + firstname + "<br/>Lastname: " + lastname + "<br/>Phone: " + phone + "<br/>Cours: " + course + "<br/>Session: " + sessionID + "</p>");
	    
	    //Récupération de la session
	    CourseSessionController courseSessionController = new CourseSessionController();
	    CourseSession courseSession = courseSessionController.getCourseSessionByID(Integer.parseInt(sessionID));
	    
	    ClientController clientController = new ClientController();
	    Client client = new Client(lastname, firstname, adress, phone, email);
	    client.setCourseSessionId(courseSession);
	    boolean success = clientController.addClient(client);
	    if(success) {
	    	out.println("<p>Ajout réussi !</p>");
	    } else {
	    	out.println("<p>Echec de l'ajout.</p>");
	    }
	    out.println("</body></html>");
	    //this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/courseinscription.jsp" ).forward( request, response );
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPost(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }
}
