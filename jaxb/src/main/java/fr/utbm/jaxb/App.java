package fr.utbm.jaxb;

import java.util.List;

import fr.utbm.jaxb.controller.CourseController;
import fr.utbm.jaxb.entity.Course;

public class App 
{
	public static void main( String[] args ) {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		
		/*ClientDao myClientDao = new ClientDao();*/
		
		//Client myNewClient = new Client("Oui", "Aloïs", "1 rue de l'UTBM", "06.06.06.06.06", "alois.kende@utbm.fr");
		//myClientDao.addClient(myNewClient);
		//myNewClient.setId(4);
		
		//myClientDao.updateClient(myNewClient);
		
		//myClientDao.deleteClient(myNewClient);
		
		/*System.out.println(myClientDao.getClientById(2).toString());
		
		
		
		List<Client> myList = myClientDao.getClient();
		for(Client myClient: myList) {
            System.out.println(myClient.toString());
        }*/
		
		CourseController myController = new CourseController();
		List<Course> myList = myController.getAllCourses();
		for(Course myCourse: myList) {
            System.out.println(myCourse.toString());
        }
		
	}
}
