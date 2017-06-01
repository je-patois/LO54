package fr.utbm.jaxb.servlet;

import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.entity.Client;

/**
 * Servlet d'export de Client en XML via JAXB
 */
@WebServlet(name="exportxmlfile", urlPatterns = "/exportxmlfile")
public class ExportXMLFile extends HttpServlet implements Serializable {

	// ---------- DEFINITION DES VARIABLES ----------
	
	private static final long serialVersionUID = 1L;
	private String filename = "InscriptionDetails";
	
	
	// ---------- CONSTRUCTEURS ----------
	
	/**
	 * Constructeur par défaut
	 */
	public ExportXMLFile() {
		
	}
	
	
	// ---------- METHODES ----------
	
	/**
	 * Comportement de la servlet en accès GET. Exporte les informations du client dans un fichier XML
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
	    ServletException, java.io.IOException {
		
	    response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
	    
	    // Récupération des paramètres
	    String clientID = request.getParameter("clientID");
	    String course = request.getParameter("course");
	    
	    // Récupération du client en base de données
	    ClientController clientController = new ClientController();
	    Client client = clientController.getClientById(Integer.parseInt(clientID));

	    String path = "";
	    
	    try {
			path = clientController.fromClientToXML(client, filename);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //rajout des paramètres pour le jsp
	    request.setAttribute("path", path);
	    request.setAttribute("filename", filename);
	    
	    //appel du jsp
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/exportXMLDone.jsp");			
	    dispatcher.forward(request,response);
	}
}