package fr.utbm.jaxb.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.JAXBException;

import fr.utbm.jaxb.controller.ClientController;
import fr.utbm.jaxb.controller.CourseSessionController;
import fr.utbm.jaxb.entity.Client;
import fr.utbm.jaxb.entity.CourseSession;

/**
 * Servlet d'import de fichier XML via JAXB
 */
@WebServlet(name="importxmlfile", urlPatterns = "/importxmlfile")
@MultipartConfig // Nécessaire à la manipulation du fichier depuis la balise input type
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
		String courseSessionID = request.getParameter("session");
		// Récupérer simplement le paramètre file n'est pas une option viable :
			// Sous IE/Edge, cette solution fonctionne
			// Sous les autres navigateurs, cette solution ne fonctionne pas, par mesure de sécurité (on récupère le nom du fichier uniquement, et pas le chemin complet)
		// C'est pourquoi nous utilisons une méthode plus complexe, en introduisant un InputStream pour pouvoir manipuler le fichier
		Part filePart = request.getPart("file"); // Récupère le contenu de la balise input type file
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();  // Récupère le nom du fichier
	    InputStream fileContent = filePart.getInputStream(); // Récupère l'InputStream, que JAXB peut manipuler
		
    	
    	// Récupération du client depuis le fichier XML via JAXB
		ClientController clientController = new ClientController();
		Client client = null;
		try {
			client = clientController.fromXMLToClient(fileContent);
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

	    //rajout des paramètres pour le jsp
	    request.setAttribute("success", success);
	    request.setAttribute("cours", courseSession.getCourse().getCode());
	    request.setAttribute("clientId", client.getId());
	    
	    //appel du jsp
	    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/importXMLDone.jsp");			
	    dispatcher.forward(request,response);	
	    
	    // Redirection vers la servlet listcoursesession ou vers l'export du résultat en XML
	    //out.println("<a href=\"http://localhost:8080/jaxb/exportxmlfile?clientID=" + client.getId() + "&course=" + courseSession.getCourse().getCode() + "\">Récupérer le XML associé</a></body></html>");
    }
}
