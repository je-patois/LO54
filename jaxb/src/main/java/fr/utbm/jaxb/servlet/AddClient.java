package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.repository.ClientDao;

/**
 * Servlet d'ajout de client
 */
@WebServlet(name="addclient", urlPatterns = "/addclient")
public class AddClient extends HttpServlet implements Serializable {

	// --------- DEFINITION DES VARIABLES ---------
	private static final long serialVersionUID = 1L;

	
	// --------- CONSTRUCTEURS ---------
	
	/**
	 * Constructeur par défaut
	 */
	public AddClient() {
		
	}
	
	
	// --------- METHODES ---------
	
	/**
	 * Comportement de la servlet en accès POST. Récupération des données depuis le formulaire et ajout du client en base de données
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des paramètres
	    String adress = request.getParameter("adress");
	    String email = request.getParameter("email");
	    String firstname = request.getParameter("firstname");
	    String lastname = request.getParameter("lastname");
	    String phone = request.getParameter("phone");
	    
	    out.println("<html><body><h1>Adding client to database</h1><br/><p>Adress:" + adress + "<br/>Email: " + email + "<br/>Firstname: " + firstname + "<br/>Lastname: " + lastname + "<br/>Phone: " + phone + "</p>");
	    
	    // Ajout du client en base de données
	    Client clientToAdd = new Client(lastname, firstname, adress, phone, email);
	    ClientDao myClientDao = new ClientDao();
	    myClientDao.addClient(clientToAdd);
	    
	    out.println("<p>The client has been successfully added.</p>");
	    out.println("</body></html>");
	    out.close();
	}
}
