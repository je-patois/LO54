package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.entity.Client;

/**
 * Servlet de récupération de la liste des clients inscrits à la session de cours choisie
 */
@WebServlet( name="listregistered", urlPatterns = "/listregistered" )
public class ListRegistered extends HttpServlet implements Serializable {

	// ---------- DEFINITION DES VARIABLES ----------
	
	private static final long serialVersionUID = 1L;
	
	
	// ---------- CONSTRUCTEURS ----------
	public ListRegistered() {
		
	}

	
	// ---------- METHODES ----------
	
	/**
	 * Récupération et affichage des clients inscrits à la session de cours choisie
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		//response.setContentType("text/html");
	    //java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des paramètres
		String course = request.getParameter("course");
		String session = request.getParameter("session");
		
		//Récupération des clients inscrits à la session de cours
		ClientController clientController = new ClientController();
		CourseSessionController courseSessionController = new CourseSessionController();
		List<Client> clients = clientController.getClientsByCourseSession(courseSessionController.getCourseSessionByID(Integer.parseInt(session)));
		
		
		/*for(Client client: clients) {
            out.println("<p>Nom: " + client.getLastname() + "<br/>Prénom: " + client.getFirstname() + "<br/>Adress: " + client.getAdress() + "<br/>Phone: " + client.getPhone() + "<br/>email: " + client.getEmail() + "</p>");
        }*/
		
		// rajout des paramètres pour le jsp
		request.setAttribute("course", course);
		request.setAttribute("session", session);
		request.setAttribute("clients", clients);
		
		// appel du jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/listRegistered.jsp");			
	    dispatcher.forward(request,response);	
		
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

    /**
     * Infos sur la servlet
     */
    public String getServletInfo() {
        return "Short description";
    }
}
