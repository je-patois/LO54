package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;

/**
 * Servlet d'inscription à une session de cours
 */
@WebServlet( name="sessioninscription", urlPatterns = "/sessioninscription" )
public class SessionInscription extends HttpServlet implements Serializable {

	// ---------- DEFINITION DES VARIABLES ----------
	private static final long serialVersionUID = 1L;
	
	
	// ---------- CONSTRUCTEURS ----------
	
	/** 
	 * Constructeur par défaut
	 */
	public SessionInscription() {
		
	}
	
	
	// ---------- METHODES ----------
	
	/**
	 * En accès Get, la servlet redirige vers la page courseinscription.jsp avec les bon paramètres
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		// Transmission des paramètres
		request.setAttribute("course", request.getAttribute("course"));
		request.setAttribute("session", request.getAttribute("session"));
		
		// Redirection vers la page courseinscription.jsp
        this.getServletContext().getRequestDispatcher( "/WEB-INF/jsp/courseinscription.jsp" ).forward( request, response );
    }
	
	/**
	 * En accès POST, la servlet inscrit un client à la session de cours choisie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des paramètres
		String adress = request.getParameter("adress");
	    String email = request.getParameter("email");
	    String firstname = request.getParameter("firstname");
	    String lastname = request.getParameter("lastname");
	    String phone = request.getParameter("phone");
	    String course = request.getParameter("course");
	    String sessionID = request.getParameter("session");
	    
	    //out.println("<html><body><h1>Ajout du profil en base de données</h1><br/><p>Adress:" + adress + "<br/>Email: " + email + "<br/>Firstname: " + firstname + "<br/>Lastname: " + lastname + "<br/>Phone: " + phone + "<br/>Cours: " + course + "<br/>Session: " + sessionID + "</p>");
	    
	    //Récupération de la session
	    CourseSessionController courseSessionController = new CourseSessionController();
	    CourseSession courseSession = courseSessionController.getCourseSessionByID(Integer.parseInt(sessionID));
	    
	    // Ajout du client
	    ClientController clientController = new ClientController();
	    Client client = new Client(lastname, firstname, adress, phone, email);
	    client.setCourseSessionId(courseSession);
	    
	    
	    boolean success = clientController.addClient(client);
	    
	    //rajout des paramètres pour le jsp
	    request.setAttribute("success", success);
	    request.setAttribute("clientId", client.getId());
	    
	    //appel du jsp
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseInscriptionDone.jsp");			
	    dispatcher.forward(request,response);
	    
	    
    }
	
	/**
	 * Comportement de la servlet en accès GET
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    /**
     * Comportement de la servlet en accès POST
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestPost(request, response);
    }

    /** 
     * Infos sur la servlet
     */
    public String getServletInfo() {
        return "Short description";
    }
}
