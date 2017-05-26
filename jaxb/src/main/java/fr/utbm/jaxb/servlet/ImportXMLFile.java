package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;

/**
 * Servlet d'import de fichier XML via JAXB
 */
@WebServlet(name="importxmlfile", urlPatterns = "/importxmlfile")
public class ImportXMLFile extends HttpServlet implements Serializable {

	// ---------- DEFINITION DES VARIABLES ----------
	
	private static final long serialVersionUID = 1L;

	
	// ---------- CONSTRUCTEURS ----------
	
	/**
	 * Constructeur par défaut
	 */
	public ImportXMLFile() {
		
	}
	
	// ---------- METHODES ----------

	/**
	 * Comportement de la servlet en accès POST. Convertit le fichier XML correctement formatté en Client via JAXB
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		response.setContentType("text/html");
	    java.io.PrintWriter out = response.getWriter();
		
		// Récupération des paramètres
		String filePath = request.getParameter("filepath");
		String courseSessionID = request.getParameter("session");
    	
    	// Récupération du client depuis le fichier XML via JAXB
		ClientController clientController = new ClientController();
		Client client = null;
		try {
			client = clientController.fromXMLToClient(filePath);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Modification de ses attributs pour automatiser l'ajout
		client.setId(null); // L'ID est remis à null, pour pouvoir procédre à un nouvel ajout
		// Récupération de la nouvelle session de cours
		CourseSessionController courseSessionController = new CourseSessionController();
		CourseSession courseSession = courseSessionController.getCourseSessionByID(Integer.parseInt(courseSessionID));
		client.setCourseSessionId(courseSession);
		
		// Ajout du client
	    boolean success = clientController.addClient(client);
	    if(success) {
	    	out.println("<p>Ajout réussi !</p>");
	    } else {
	    	out.println("<p>Echec de l'ajout.</p>");
	    }
	    
	    // Redirection vers la servlet listcoursesession ou vers l'export du résultat en XML
	    out.println("<a href=\"http://localhost:8080/jaxb/listcoursesession?course=" + courseSession.getCourse().getCode() + "\">Retourner à la liste des sessions de cours</a>");
	    out.println("<a href=\"http://localhost:8080/jaxb/exportxmlfile?clientID=" + client.getId() + "&course=" + courseSession.getCourse().getCode() + "\">Récupérer le XML associé</a></body></html>");
    }
}
